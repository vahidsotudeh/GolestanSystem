import { BrowserModule,Title } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {routing} from './app.routes';
// import {HttpModule, Headers, Response, ResponseOptions} from "@angular/http";
// import {RestangularConfigFactory} from './services/config'
import { RestangularModule,Restangular  } from 'ngx-restangular';
import { RouterModule, Routes } from '@angular/router';
import { Ng2Bs3ModalModule } from 'ng2-bs3-modal/ng2-bs3-modal';
import { AppComponent } from './app.component';
import { CoursesComponent } from './courses/courses.component';

export function RestangularConfigFactory (RestangularProvider) {
  RestangularProvider.setBaseUrl('http://217.182.230.17:8080');
  //RestangularProvider.setFullResponse(true);
  RestangularProvider.addResponseInterceptor((data, operation, what, url, response)=> {
       console.log(data.length);
       console.log(url);
       console.log(what);

       return data;
    });
}


@NgModule({
  declarations: [
    AppComponent,
    CoursesComponent
  ],
  imports: [
    BrowserModule,
    RestangularModule.forRoot(RestangularConfigFactory),
    routing,
    Ng2Bs3ModalModule
  ],
  providers: [Title],
  bootstrap: [AppComponent]
})
export class AppModule {

 }
