import { RouterModule, Routes,Router } from '@angular/router';
import { CoursesComponent } from './courses/courses.component';
import {GroupsComponent} from './courses/groups.component';
import { ProfileComponent } from './profile/profile.component';
import { TermsComponent } from './terms/terms.component';
import { RegisterComponent } from './register/register.component';
import {ClassStudentListComponent} from './class-student-list/class-student-list.component';

const routes: Routes = [
{ path: 'courses', component: CoursesComponent },
{ path: 'groups', component: GroupsComponent },
{ path: 'teachers', component: CoursesComponent },
{ path: 'editProfile', component: ProfileComponent },
{ path: 'register', component: RegisterComponent },
{ path: 'terms', component: TermsComponent },
{ path: 'classes', component: ClassStudentListComponent }

];
export const appRoutingProviders: any[] = [

];
export const routing = RouterModule.forRoot(routes);