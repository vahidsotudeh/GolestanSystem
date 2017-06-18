import { RouterModule, Routes,Router } from '@angular/router';
import { CoursesComponent } from './courses/courses.component';

const routes: Routes = [
{ path: 'courses', component: CoursesComponent },
{ path: 'teachers', component: CoursesComponent }
];
export const appRoutingProviders: any[] = [

];
export const routing = RouterModule.forRoot(routes);