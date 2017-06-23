import { BrowserModule,Title } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {routing} from './app.routes';
import { FormsModule } from '@angular/forms';
// import {HttpModule, Headers, Response, ResponseOptions} from "@angular/http";
// import {RestangularConfigFactory} from './services/config'
import { RestangularModule,Restangular  } from 'ngx-restangular';
import { RouterModule, Routes } from '@angular/router';
import { Ng2Bs3ModalModule } from 'ng2-bs3-modal/ng2-bs3-modal';
import { AppComponent } from './app.component';
import { CoursesComponent } from './courses/courses.component';
import { MultiselectDropdownModule } from 'angular-2-dropdown-multiselect';
import { GroupsComponent } from './courses/groups.component';
import { TermsComponent } from './terms/terms.component';
import { ProfileComponent } from './profile/profile.component';
export function RestangularConfigFactory (RestangularProvider) {
  RestangularProvider.setBaseUrl('http://localhost:8080/api');
  //RestangularProvider.setFullResponse(true);
  RestangularProvider.addResponseInterceptor((data, operation, what, url, response)=> {
       return data;
    });
}


@NgModule({
  declarations: [
    AppComponent,
    CoursesComponent,
    GroupsComponent,
    TermsComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    RestangularModule.forRoot(RestangularConfigFactory),
    routing,
    Ng2Bs3ModalModule,
    MultiselectDropdownModule,    
    FormsModule
  ],
  providers: [Title],
  bootstrap: [AppComponent]
})
export class AppModule {

 }
