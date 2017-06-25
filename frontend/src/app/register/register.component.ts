import { Component, OnInit,ViewChild } from '@angular/core';
import { ModalComponent } from 'ng2-bs3-modal/ng2-bs3-modal';
import { NgForm } from '@angular/forms';
import { IMultiSelectOption } from 'angular-2-dropdown-multiselect';
import { IMultiSelectTexts } from 'angular-2-dropdown-multiselect';
import { IMultiSelectSettings } from 'angular-2-dropdown-multiselect';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import {Lecture} from '../poao-classes/lecture';
import {Observable} from 'rxjs/Observable';
import {RegisterServiceService} from '../services/register-service.service';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  providers:[RegisterServiceService]

})
export class RegisterComponent implements OnInit {
  @ViewChild('myModal')
    modal: ModalComponent;
  @ViewChild('lectureModifyForm') 
    public courseForm: NgForm;

  lectures:Array<Lecture>;  
  coursesModel: number[];
  courses: IMultiSelectOption[];  
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
      defaultTitle: 'گروه ها',
      allSelected: 'همه انتخاب شدند',
  };
  isEditing:boolean=false;
  isDeleting:boolean=false;
  operationSuccessFull:boolean=false;
  operationUnSuccessFull:boolean=false;
  alertMessage:string;
  confirmMessage:String;

  constructor(private titleService: Title,private route: ActivatedRoute, public registerService:RegisterServiceService ) { 
    this.setTitle("انتخاب واحد");
  }

  ngOnInit() {
    this.retrieveData();    
  }
  public setTitle( newTitle: string) {
    this.titleService.setTitle( newTitle );
  }
  public retrieveData(){
    this.registerService.getLectureList().then(
      (data) => {
        console.log(data);
        
      this.lectures=data;
      var tempArrData:IMultiSelectOption[]=new Array;
      for(var i=0;i<data.length;i++){
        tempArrData[i]={id:data[i].id,name:data[i].course.code+""+data[i].code+":"+data[i].course.name+":"+data[i].master.firstName+data[i].master.lastName+":از"+data[i].lectureTimes[0].startTime+" تا "+data[i].lectureTimes[0].endTime};
      }
      this.courses=tempArrData;
      console.log(data );
      // this.gaCoursesService.getGroupsList().then((data)=>{ 
      //   this.groupsArr=data;
      //   var tempArrData:IMultiSelectOption[]=new Array;
      //   for(var i=0;i<data.length;i++){
      //     tempArrData[i]={id:data[i].id,name:data[i].name.toString()};
      //   }
      //   this.courseGroups=tempArrData;
          
      // });
      }
    );
    
  }

}
