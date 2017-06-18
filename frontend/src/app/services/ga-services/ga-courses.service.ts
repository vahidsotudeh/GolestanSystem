import { Injectable } from '@angular/core';
import { RestangularModule, Restangular } from 'ngx-restangular';
import {GaCourse,GaCourseGroups} from '../../courses/ga-course'
import {Observable} from 'rxjs/Observable';
@Injectable()
export class GaCoursesService {
   
  constructor(private restangular: Restangular) {

  }
  public  getCourseList():Promise<Array<GaCourse>>{
    return this.restangular.one('lectures/list').getList().toPromise();
    // return this.restangular.one('lectures/list').getList().then((data) => {
    //   console.log("ssss");
    //   console.log(data );
    //   console.log("ssss");      
    //   }).catch((ex) => {
    //     console.log(ex);
    //   }
    // );

  }
} 
