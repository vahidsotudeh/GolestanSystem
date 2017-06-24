import { Component, OnInit ,ViewChild } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import {Observable} from 'rxjs/Observable';
import {GaCoursesService} from '../services/ga-services/ga-courses.service';
import {GaCourse,GaCourseGroups} from '../courses/ga-course'
import {GaGroup,GaGroupCourses} from '../courses/ga-group'
import { ModalComponent } from 'ng2-bs3-modal/ng2-bs3-modal';
import { NgForm } from '@angular/forms';
import { IMultiSelectOption } from 'angular-2-dropdown-multiselect';
import { IMultiSelectTexts } from 'angular-2-dropdown-multiselect';
import { IMultiSelectSettings } from 'angular-2-dropdown-multiselect';
@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css'],
  providers:[GaCoursesService]
})
export class CoursesComponent implements OnInit {
  @ViewChild('myModal')
    modal: ModalComponent;
  @ViewChild('lectureModifyForm') 
    public courseForm: NgForm;
  courseGroupsModel: number[];
  courseGroups: IMultiSelectOption[];  
  coursePreRequiredModel: number[];
  coursePreRequired: IMultiSelectOption[];  

  mySettings: IMultiSelectSettings = {
    enableSearch: true,
    checkedStyle: 'fontawesome',
    buttonClasses: 'btn btn-default btn-block',
    dynamicTitleMaxItems: 3,
    displayAllSelectedText: false
  };
  groupsText: IMultiSelectTexts = {
      checkAll: 'همه را انتخاب کنید',
      uncheckAll: 'انتخاب ها را کنید',
      checked: 'انتخاب شد',
      checkedPlural: 'تا انتخاب شدند',
      searchPlaceholder: 'بگردید',
      defaultTitle: 'گروه ها',
      allSelected: 'همه انتخاب شدند',
  };
  preRequiredsText: IMultiSelectTexts = {
      checkAll: 'همه را انتخاب کنید',
      uncheckAll: 'انتخاب ها را کنید',
      checked: 'انتخاب شد',
      checkedPlural: 'تا انتخاب شدند',
      searchPlaceholder: 'بگردید',
      defaultTitle: 'پیش نیازها',
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
  public coursesArr:GaCourse[];
  public groupsArr:GaGroup[];
  gaCoursesServices:GaCoursesService;
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
  public constructor(private titleService: Title,private route: ActivatedRoute, public gaCoursesService:GaCoursesService ) {
    this.setTitle("Courses");
    this.retrieveData();    
    console.log(this.coursesArr);
    this.gaCoursesServices=gaCoursesService;
  }
  public setTitle( newTitle: string) {
    this.titleService.setTitle( newTitle );
  }
  public editCourseSelect(index :number,id:number){
    this.isEditing=true;
    this.isDeleting=false;
    this.selectedCourseId=id;
    this.selectedCourseIndex=index;
    this.confirmMessage="آیا از ویرایش درس مطمئن هستید؟";
    this.modal.open();
    
  }
  public removeCourse(index :number,id:number){
    this.isEditing=false;
    this.isDeleting=true;
    this.selectedCourseId=id;
    this.selectedCourseIndex=index;
    this.confirmMessage="آیا از حذف درس مطمئن هستید؟";
    this.modal.open();
  }
  public addLecture(formFields : NgForm){
    this.modifyForm(formFields);
  }
  public openConfirmPanel(){

  }
  public cancelOperation(){
    this.isDeleting=false;
    this.isEditing=false;
  }
  public ApproveOperation(){
    console.log(this.isEditing);
      if(this.isDeleting){
        // this.coursesArr.splice(this.selectedCourseIndex,1);
        this.isDeleting=false;
        this.isEditing=false;  
        this.gaCoursesService.deleteCourse(this.selectedCourseId);
        this.courseForm.reset();      
        // this.opera
        //send delete to server
      }else if(this.isEditing){
        //show course fields in form to edit
        var tempArrindexGroups:number[]=new Array;
        var tempArrindexPreReqs:number[]=new Array;
        this.courseForm.controls['lecName'].setValue(this.coursesArr[this.selectedCourseIndex].name);  
        this.courseForm.controls['lecCode'].setValue(this.coursesArr[this.selectedCourseIndex].code);  
        this.courseForm.controls['lecPracUnit'].setValue(this.coursesArr[this.selectedCourseIndex].practicalUnitCount);  
        this.courseForm.controls['lecTheorUnit'].setValue(this.coursesArr[this.selectedCourseIndex].theoreticalUnitCount);  
        for(var i=0;i<this.coursesArr[this.selectedCourseIndex].groups.length;i++){
          var grId:Number=this.coursesArr[this.selectedCourseIndex].groups[i].id;
          tempArrindexGroups[i]=grId.valueOf(); 
        }
        // console.log(this.coursesArr[this.selectedCourseId]);
        console.log(this.selectedCourseIndex + " index");
        
        
        for(var i=0;i<this.coursesArr[this.selectedCourseIndex].preRequiredCourses.length;i++){
          var grId:Number=this.coursesArr[this.selectedCourseIndex].preRequiredCourses[i].id;
          tempArrindexPreReqs[i]=grId.valueOf();
          console.log(tempArrindexPreReqs);
          
        }

        this.courseGroupsModel=tempArrindexGroups;     
        this.coursePreRequiredModel=tempArrindexPreReqs;     
        this.isDeleting=false;
      }
  }
  public cancelEditing(){
    this.isDeleting=false;
    this.isEditing=false;
    this.courseForm.reset();
    
  }
  public modifyForm(formFields : NgForm){
    console.log("hellp");
      var groups:GaCourseGroups[]=new Array;
      for(var i=0;i<this.courseGroupsModel.length;i++){
          groups[i]={id:this.courseGroupsModel[i],name:this.groupsArr.find(x => x.id === this.courseGroupsModel[i]).name.toString()};
      }
      var preDefs:GaCourseGroups[]=new Array;
      for(var i=0;i<this.coursePreRequiredModel.length;i++){
          preDefs[i]={id:this.coursePreRequiredModel[i],name:this.coursesArr.find(x => x.id === this.coursePreRequiredModel[i]).name.toString()};
      }
      console.log(formFields.value);
      
      var course=new GaCourse(
        this.selectedCourseId,
        formFields.value.lecName,
        formFields.value.lecCode,
        groups,
        preDefs,
        formFields.value.lecPracUnit,
        formFields.value.lecTheorUnit
      );
      console.log(course);
    if(this.isEditing){
      
      this.gaCoursesService.updateCourse(course);
      this.courseForm.reset();
      this.isEditing=false;
      this.isDeleting=false;
      this.operationSuccessFull=true;
      this.alertMessage="درس مورد نظر شما بروزرسانی شد.";
      this.retrieveData();

    }else{
      course.id=null;
      this.gaCoursesService.addCourse(course);
      this.courseForm.reset();
      this.isEditing=false;
      this.isDeleting=false;
      this.operationSuccessFull=true;
      this.alertMessage="درس اضافه شد.";
      this.retrieveData();
    }
  }
  public onChangecourseGroups(event){
    console.log(this.coursePreRequiredModel);
  }
  public retrieveData(){
    this.gaCoursesService.getCourseList().then(
      (data) => {
      this.coursesArr=data;
      var tempArrData:IMultiSelectOption[]=new Array;
      for(var i=0;i<data.length;i++){
        tempArrData[i]={id:data[i].id,name:data[i].name.toString()};
      }
      this.coursePreRequired=tempArrData;
      console.log(data );
      this.gaCoursesService.getGroupsList().then((data)=>{ 
        this.groupsArr=data;
        var tempArrData:IMultiSelectOption[]=new Array;
        for(var i=0;i<data.length;i++){
          tempArrData[i]={id:data[i].id,name:data[i].name.toString()};
        }
        this.courseGroups=tempArrData;
          
      });
      }
    );

  }
}

