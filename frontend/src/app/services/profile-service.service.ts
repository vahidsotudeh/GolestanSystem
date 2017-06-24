import { Injectable } from '@angular/core';
import { RestangularModule, Restangular } from 'ngx-restangular';
import {User} from '../poao-classes/user';
import {Observable} from 'rxjs/Observable';
@Injectable()
export class ProfileService {
   
  constructor(private restangular: Restangular) {

  }
  public  getUser():Promise<User>{
    return this.restangular.one('users/currentUser').get().toPromise();
  }
  public updateUser(user:User):boolean{
    // console.log(this.restangular.one("lectures/update").post(course));
    this.restangular.all("users/update").post(user);
    
    // this.restangular.post("lectures/update",course);
    return true;
  }
} 

