import { Injectable } from '@angular/core';
import { RestangularModule, Restangular } from 'ngx-restangular';
import {Term} from '../../terms/term';
import {Observable} from 'rxjs/Observable';
@Injectable()
export class GaTermsService {
   
  constructor(private restangular: Restangular) {

  }
  public  getTermList():Promise<Array<Term>>{
    return this.restangular.one('term/list').getList().toPromise();
  }
  public updateTerm(term:Term):boolean{
    this.restangular.all("terms/update").post(term);
    
    // this.restangular.post("lectures/update",course);
    return true;
  }
  public addCourse(Term:Term):boolean{
    this.restangular.all("terms/add").post(Term);
    // this.restangular.post("lectures/update",course);
    return true;
  }
  public deleteCourse(id:number):boolean{
    this.restangular.one("terms/delete",id).get();
    return true;
  }
} 

