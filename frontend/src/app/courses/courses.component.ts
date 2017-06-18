import { Component, OnInit ,ViewChild } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import {Observable} from 'rxjs/Observable';
import {GaCoursesService} from '../services/ga-services/ga-courses.service';
import {GaCourse,GaCourseGroups} from '../courses/ga-course'
import { ModalComponent } from 'ng2-bs3-modal/ng2-bs3-modal';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css'],
  providers:[GaCoursesService]
})
export class CoursesComponent implements OnInit {
  @ViewChild('myModal')
    modal: ModalComponent;
  rowCounter:number;
  isEditing:boolean=false;
  isDeleting:boolean=false;
  selectedCourseId:number;
  selectedCourseIndex:number;
  confirmMessage:String;
  public coursesArr:GaCourse[];
  ngOnInit() {
    this.rowCounter=1;
    this.modal.onClose.subscribe(()=>this.ApproveOperation());
    this.modal.onDismiss.subscribe(()=>this.cancelOperation())
    this.modal.onOpen.subscribe(()=>this.openConfirmPanel())
  }
  public constructor(private titleService: Title,private route: ActivatedRoute, public gaCoursesService:GaCoursesService ) {
    this.setTitle("Courses");
    
    gaCoursesService.getCourseList().then(
      (data) => {
      this.coursesArr=data;
      console.log(data );
      }
    );
    console.log(this.coursesArr);
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
  public addCourse(){

  }
  public openConfirmPanel(){

  }
  public cancelOperation(){
    this.isDeleting=false;
    this.isEditing=false;
  }
  public ApproveOperation(){
      if(this.isDeleting){
        this.coursesArr.splice(this.selectedCourseIndex,1);
        this.isDeleting=false;
        this.isEditing=false;        
        //send delete to server
      }else if(this.isEditing){
        //show course fields in form to edit
        this.isDeleting=false;
        this.isEditing=false;
      }
  }
}
