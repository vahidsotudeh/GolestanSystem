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

  
  inClassView:boolean=true;
  constructor() { }

  ngOnInit() {
  }

}
