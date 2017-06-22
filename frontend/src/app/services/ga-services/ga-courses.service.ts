import { Injectable } from '@angular/core';
import { RestangularModule, Restangular } from 'ngx-restangular';
import {GaCourse,GaCourseGroups} from '../../courses/ga-course'
import {GaGroup,GaGroupCourses} from '../../courses/ga-group'
import {Observable} from 'rxjs/Observable';
@Injectable()
export class GaCoursesService {
   
  constructor(private restangular: Restangular) {

  }
  public  getCourseList():Promise<Array<GaCourse>>{
    return this.restangular.one('lectures/list').getList().toPromise();
  }
  public getGroupsList():Promise<Array<GaGroup>>{
    return this.restangular.one('groups/list').getList().toPromise();
  }
  public updateCourse(course:GaCourse):boolean{
    // console.log(this.restangular.one("lectures/update").post(course));
    this.restangular.all("lectures/update").post(course);
    
    // this.restangular.post("lectures/update",course);
    return true;
  }
  public deleteCourse(id:number):boolean{
    this.restangular.one("lectures/delete",id).get();
    return true;
  }
} 

