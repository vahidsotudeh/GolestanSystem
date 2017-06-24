import { Injectable } from '@angular/core';
import { RestangularModule, Restangular } from 'ngx-restangular';
import {Term} from '../../terms/term';
import {Master} from '../../poao-classes/master';
import {Lecture} from '../../poao-classes/lecture';
import {GaCourse} from '../../courses/ga-course';
import {Observable} from 'rxjs/Observable';
@Injectable()
export class GaTermsService {
   
  constructor(private restangular: Restangular) {

  }
  public  getTermList():Promise<Array<Term>>{
    return this.restangular.one('terms/list').getList().toPromise();
  }
  public updateTerm(term:Term):boolean{
    this.restangular.all("terms/update").post(term);
    
    // this.restangular.post("lectures/update",course);
    return true;
  }
  public addTerm(Term:Term):boolean{
    this.restangular.all("terms/add").post(Term);
    // this.restangular.post("lectures/update",course);
    return true;
  }
  public deleteTerm(id:number):boolean{
    this.restangular.one("terms/delete",id).get();
    return true;
  }
  public getCourseList():Promise<Array<GaCourse>>{
    return this.restangular.one('courses/list').getList().toPromise();
  }
  public getMasterList():Promise<Array<Master>>{
    return this.restangular.one('masters/list').getList().toPromise();
  }
  public addLecture(lec:Lecture):boolean{
    this.restangular.all("lectures/add").post(lec);
    // this.restangular.post("lectures/update",course);
    return true;
  }
  public getLectureByTerm(id:number):Promise<Array<Lecture>>{
    return this.restangular.one('terms/lectures',id).getList().toPromise();
  }
  public deleteLecture(id:number):boolean{
    this.restangular.one("lectures/delete",id).get();
    return true;
  }

} 

