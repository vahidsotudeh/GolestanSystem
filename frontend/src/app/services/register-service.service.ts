import { Injectable } from '@angular/core';
import { RestangularModule, Restangular } from 'ngx-restangular';
import {Lecture} from '../poao-classes/lecture';
@Injectable()
export class RegisterServiceService {

  constructor(private restangular: Restangular) {

  }
  public getLectureList():Promise<Array<Lecture>>{
    return this.restangular.one('lectures/list').getList().toPromise();
  }
  
  // public getUser():Promise<User>{
  //   return this.restangular.one('users/currentUser').get().toPromise();
  // }
  // public updateUser(user:User):boolean{
  //   // console.log(this.restangular.one("lectures/update").post(course));
  //   this.restangular.all("users/update").post(user);
    
  //   // this.restangular.post("lectures/update",course);
  //   return true;
  // }
}
