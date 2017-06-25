import { Component, OnInit,ViewChild } from '@angular/core';
import { ModalComponent } from 'ng2-bs3-modal/ng2-bs3-modal';
import { NgForm } from '@angular/forms';
import { IMultiSelectOption } from 'angular-2-dropdown-multiselect';
import { IMultiSelectTexts } from 'angular-2-dropdown-multiselect';
import { IMultiSelectSettings } from 'angular-2-dropdown-multiselect';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import {Lecture} from '../poao-classes/lecture';
import {LectureStudent} from '../poao-classes/lecture-student';
import {Observable} from 'rxjs/Observable';
import {ClassesService} from '../services/classes.service';

@Component({
  selector: 'app-class-student-list',
  templateUrl: './class-student-list.component.html',
  styleUrls: ['./class-student-list.component.css'],
  providers:[ClassesService]
})
export class ClassStudentListComponent implements OnInit {

  @ViewChild('gradeLectureStudent') 
    public gradeLectureStudent: NgForm;

  public classes:Lecture[];
  public students:LectureStudent[];
  inClassView:boolean=true;
  selectedClass:string="";
  public constructor(private titleService: Title,private route: ActivatedRoute, public classesService:ClassesService ) {
    this.setTitle("کلاس ها");
    this.retrieveData();    
  }
  public setTitle( newTitle: string) {
    this.titleService.setTitle( newTitle );
  }

  ngOnInit() {

  }
  public retrieveData(){
    this.classesService.getCurrentMasterClassList().then((data)=>{
      this.classes=data;
    });
  }
  public studentList(index,id){
    this.inClassView=!this.inClassView;
    this.selectedClass=this.classes[index].course.name;
    this.classesService.getLectureStudent(id).then((data)=>{
        this.students=data;
    });
  }
}
