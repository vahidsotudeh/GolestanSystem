import { Component, OnInit ,ViewChild } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import {Observable} from 'rxjs/Observable';
import {GaTermsService} from '../services/ga-services/ga-terms.service';
import {GaCourse} from '../courses/ga-course';
import {Lecture} from '../Poao-classes/lecture';
import {Term} from './term';
import { ModalComponent } from 'ng2-bs3-modal/ng2-bs3-modal';
import { NgForm } from '@angular/forms';
import { IMultiSelectOption } from 'angular-2-dropdown-multiselect';
import { IMultiSelectTexts } from 'angular-2-dropdown-multiselect';
import { IMultiSelectSettings } from 'angular-2-dropdown-multiselect';
declare var $: any

@Component({
  selector: 'app-terms',
  templateUrl: './terms.component.html',
  styleUrls: ['./terms.component.css'],
  providers:[GaTermsService]
})
export class TermsComponent implements OnInit {
  @ViewChild('myModal')
    modal: ModalComponent;
  @ViewChild('pleaseSelectModal')
    pleaseSelectModal: ModalComponent;
  @ViewChild('addTermForm') 
    public addTermForm: NgForm;
  @ViewChild('addLectureToTermForm') 
    public addLectureToTermForm: NgForm;
  coursesModel: number[];
  courses: IMultiSelectOption[];  
  mastersModel: number[];
  masters: IMultiSelectOption[];  

  mySettings: IMultiSelectSettings = {
    enableSearch: true,
    checkedStyle: 'fontawesome',
    buttonClasses: 'btn btn-default btn-block',
    dynamicTitleMaxItems: 3,
    displayAllSelectedText: false,
    selectionLimit: 1,
    autoUnselect: true
  };
  groupsText: IMultiSelectTexts = {
      checkAll: 'همه را انتخاب کنید',
      uncheckAll: 'انتخاب ها را کنید',
      checked: 'انتخاب شد',
      checkedPlural: 'تا انتخاب شدند',
      searchPlaceholder: 'بگردید',
      defaultTitle: 'درس ها',
      allSelected: 'همه انتخاب شدند',
  };
  preRequiredsText: IMultiSelectTexts = {
      checkAll: 'همه را انتخاب کنید',
      uncheckAll: 'انتخاب ها را کنید',
      checked: 'انتخاب شد',
      checkedPlural: 'تا انتخاب شدند',
      searchPlaceholder: 'بگردید',
      defaultTitle: 'اساتید',
      allSelected: 'همه انتخاب شدند',
  };

  rowCounter:number;
  isEditing:boolean=false;
  isDeleting:boolean=false;
  operationSuccessFull:boolean=false;
  operationUnSuccessFull:boolean=false;
  alertMessage:string;
  selectedCourseId:number;
  selectedCourseIndex:number;
  confirmMessage:String;
  public terms:Term[];
  public lecturesArr:Lecture[];
  ngOnInit() {
    // this.courseGroups = [
    //     { id: 1, name: 'مهندسی نرم افزار' },
    //     { id: 2, name: 'مهندسی اینترنت' },
    // ];    
    this.rowCounter=1;
    this.modal.onClose.subscribe(()=>this.ApproveOperation());
    this.modal.onDismiss.subscribe(()=>this.cancelOperation())
    this.modal.onOpen.subscribe(()=>this.openConfirmPanel())
  }
  public constructor(private titleService: Title,private route: ActivatedRoute, public gaTermsService:GaTermsService ) {
    this.setTitle("Terms");
    this.retrieveData();    
    // this.gaCoursesServices=gaCoursesService;
  }
    public setTitle( newTitle: string) {
    this.titleService.setTitle( newTitle );
  }
  public editTermSelect(index :number,id:number){
    $("#term"+this.selectedCourseIndex).css('background-color', '');
    this.isEditing=true;
    this.isDeleting=false;
    this.selectedCourseId=id;
    this.selectedCourseIndex=index;
    this.confirmMessage="آیا از ویرایش ترم مطمئن هستید؟";
    this.modal.open();
    $("#term"+index).css('background-color', '#fbffbb');
    
  }
  public removeCourse(index :number,id:number){
    this.isEditing=false;
    this.isDeleting=true;
    this.selectedCourseId=id;
    this.selectedCourseIndex=index;
    this.confirmMessage="آیا از حذف ترم مطمئن هستید؟";
    this.modal.open();
  }
  public addLecture(formFields : NgForm){
    //this.modifyForm(formFields);
  }
  public addLectureToTerm(formFields : NgForm){
    if(this.isEditing){
        var newLecture=new Lecture();
        newLecture.code=formFields.value.lectureCodeTxt;
        newLecture.master.id=this.mastersModel[0];
        newLecture.roomNumber=formFields.value.roomNumberTxt;
        newLecture.term.id=this.selectedCourseId;
        this.gaTermsService.addLecture(newLecture);
        this.operationSuccessFull=true;
        this.alertMessage="درس به ترم اضافه شد";
    }else{
        this.pleaseSelectModal.open();
    }
  }
  public removeLecture(index,id){
      this.gaTermsService.deleteLecture(id);
      this.lecturesArr.splice(index,1);
  }
  public openConfirmPanel(){

  }
  public cancelOperation(){
    this.isDeleting=false;
    this.isEditing=false;
    $("#term"+this.selectedCourseIndex).css('background-color', '');
  }
  public ApproveOperation(){
    console.log(this.isEditing);
      if(this.isDeleting){
        this.terms.splice(this.selectedCourseIndex,1);
        this.isDeleting=false;
        this.isEditing=false;  
        this.gaTermsService.deleteTerm(this.selectedCourseId);
        this.addTermForm.reset();      
        // this.opera
        //send delete to server
      }else if(this.isEditing){
        this.isDeleting=false;
        this.addTermForm.controls['yearTxt'].setValue(this.terms[this.selectedCourseIndex].year);  
        this.addTermForm.controls['termSelection'].setValue(this.terms[this.selectedCourseIndex].semester);  
        this.gaTermsService.getLectureByTerm(this.selectedCourseId).then((data)=>{
          this.lecturesArr=data;
        });
        // this.lecuresArr
        //show course fields in form to edit
        // var tempArrindexGroups:number[]=new Array;
        // var tempArrindexPreReqs:number[]=new Array;
        // this.courseForm.controls['lecName'].setValue(this.coursesArr[this.selectedCourseIndex].name);  
        // this.courseForm.controls['lecCode'].setValue(this.coursesArr[this.selectedCourseIndex].code);  
        // this.courseForm.controls['lecPracUnit'].setValue(this.coursesArr[this.selectedCourseIndex].practicalUnitCount);  
        // this.courseForm.controls['lecTheorUnit'].setValue(this.coursesArr[this.selectedCourseIndex].theoreticalUnitCount);  
        // for(var i=0;i<this.coursesArr[this.selectedCourseIndex].groups.length;i++){
        //   var grId:Number=this.coursesArr[this.selectedCourseIndex].groups[i].id;
        //   tempArrindexGroups[i]=grId.valueOf();
        // }
        // // console.log(this.coursesArr[this.selectedCourseId]);
        // console.log(this.selectedCourseIndex + " index");
        
        
        // for(var i=0;i<this.coursesArr[this.selectedCourseIndex].preRequiredCourses.length;i++){
        //   var grId:Number=this.coursesArr[this.selectedCourseIndex].preRequiredCourses[i].id;
        //   tempArrindexPreReqs[i]=grId.valueOf();
        //   console.log(tempArrindexPreReqs);
          
        // }

        // this.courseGroupsModel=tempArrindexGroups;     
        // this.coursePreRequiredModel=tempArrindexPreReqs;     
        // this.isDeleting=false;
      }
  }
  public cancelEditing(){
    this.isDeleting=false;
    this.isEditing=false;
    this.addTermForm.reset();
    $("#term"+this.selectedCourseIndex).css('background-color', '');
  }
  public addTerm(formFields : NgForm){
    if(!this.isEditing){
      var newTerm=new Term();
      newTerm.semester=formFields.value.termSelection;
      newTerm.year=formFields.value.yearTxt;
      this.gaTermsService.addTerm(newTerm);
      this.operationSuccessFull=true;
      this.alertMessage="ترم اضافه شد";
      this.retrieveData();
    }else if (this.isEditing){
      var newTerm=new Term();
      newTerm.semester=formFields.value.termSelection;
      newTerm.year=formFields.value.yearTxt;
      newTerm.id=this.selectedCourseId;
      this.gaTermsService.addTerm(newTerm);
      this.operationSuccessFull=true;
      this.alertMessage="ترم ویرایش شد";
      this.retrieveData();
    }
    // console.log("hellp");
    //   var groups:GaCourseGroups[]=new Array;
    //   for(var i=0;i<this.courseGroupsModel.length;i++){
    //       groups[i]={id:this.courseGroupsModel[i],name:this.groupsArr.find(x => x.id === this.courseGroupsModel[i]).name.toString()};
    //   }
    //   var preDefs:GaCourseGroups[]=new Array;
    //   for(var i=0;i<this.coursePreRequiredModel.length;i++){
    //       preDefs[i]={id:this.coursePreRequiredModel[i],name:this.coursesArr.find(x => x.id === this.coursePreRequiredModel[i]).name.toString()};
    //   }
    //   console.log(formFields.value);
      
    //   var course=new GaCourse(
    //     this.selectedCourseId,
    //     formFields.value.lecName,
    //     formFields.value.lecCode,
    //     groups,
    //     preDefs,
    //     formFields.value.lecPracUnit,
    //     formFields.value.lecTheorUnit
    //   );
    //   console.log(course);
    // if(this.isEditing){
      
    //   this.gaCoursesService.updateCourse(course);
    //   this.courseForm.reset();
    //   this.isEditing=false;
    //   this.isDeleting=false;
    //   this.operationSuccessFull=true;
    //   this.alertMessage="درس مورد نظر شما بروزرسانی شد.";
    //   this.retrieveData();

    // }else{
    //   course.id=null;
    //   this.gaCoursesService.addCourse(course);
    //   this.courseForm.reset();
    //   this.isEditing=false;
    //   this.isDeleting=false;
    //   this.operationSuccessFull=true;
    //   this.alertMessage="درس اضافه شد.";
    //   this.retrieveData();
    // }
  }
  public onChangecourseGroups(event){
    // console.log(this.coursePreRequiredModel);
  }
  public retrieveData(){
    this.gaTermsService.getTermList().then(
      (data) => {
      this.terms=data;
      this.gaTermsService.getCourseList().then((data)=>{
        var tempArrData:IMultiSelectOption[]=new Array;
        for(var i=0;i<data.length;i++){
          tempArrData[i]={id:data[i].id,name:data[i].name.toString()};
        }
        this.courses=tempArrData;
        console.log(data);
      });
      
      this.gaTermsService.getMasterList().then((data)=>{ 
        
        var tempArrData:IMultiSelectOption[]=new Array;
        for(var i=0;i<data.length;i++){
          tempArrData[i]={id:data[i].id,name:data[i].firstName+data[i].lastName};
        }
        this.masters=tempArrData;
          
      });
      }
    );

  }
  
}

