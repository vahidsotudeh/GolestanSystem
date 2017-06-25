import { Injectable } from '@angular/core';
import { RestangularModule, Restangular } from 'ngx-restangular';
import {Observable} from 'rxjs/Observable';
import {Lecture} from '../poao-classes/lecture';
import {LectureStudent} from '../poao-classes/lecture-student';
@Injectable()
export class ClassesService {
   
  constructor(private restangular: Restangular) {

  }
  public  getCurrentMasterClassList():Promise<Array<Lecture>>{
    return this.restangular.one('lectures/master/current').getList().toPromise();
  }
  public getLectureStudent(id:number):Promise<Array<LectureStudent>>{
    return this.restangular.one('studentLecture/'+id).getList().toPromise();
  }
  // public updateCourse(course:GaCourse):boolean{
  //   // console.log(this.restangular.one("lectures/update").post(course));
  //   this.restangular.all("courses/update").post(course);
    
  //   // this.restangular.post("lectures/update",course);
  //   return true;
  // }
  // public addCourse(course:GaCourse):boolean{
  //   this.restangular.all("courses/add").post(course);
  //   // this.restangular.post("lectures/update",course);
  //   return true;
  // }
  // public deleteCourse(id:number):boolean{
  //   this.restangular.one("courses/delete",id).get();
  //   return true;
  // }
} 

