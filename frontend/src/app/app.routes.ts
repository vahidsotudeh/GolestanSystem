import { RouterModule, Routes,Router } from '@angular/router';
import { CoursesComponent } from './courses/courses.component';
import {GroupsComponent} from './courses/groups.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';

const routes: Routes = [
{ path: 'courses', component: CoursesComponent },
{ path: 'groups', component: GroupsComponent },
{ path: 'teachers', component: CoursesComponent },
{ path: 'editProfile', component: EditProfileComponent }
];
export const appRoutingProviders: any[] = [

];
export const routing = RouterModule.forRoot(routes);