import { Component , ViewEncapsulation} from '@angular/core';
import { CoursesComponent } from './courses/courses.component';
import {routing} from './app.routes';
import {Router} from '@angular/router';

@Component({
  encapsulation: ViewEncapsulation.None,
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: [
    './app.component.css',
    '../assets/css/master.css'
  ]
})
export class AppComponent {
    public router : Router;
    flagTest = true;
    constructor(r: Router) {
        this.router =r;
    }

  public courseManagement(){
    this.router.navigate(['/courses']);
    this.flagTest=false;

  }
  public groupManagement(){
    this.router.navigate(['/groups']);
    this.flagTest=false;

  }
  public editProfile(){
    this.router.navigate(['/editProfile']);
    this.flagTest=false;

  }
  public termsManagement(){
    this.router.navigate(['/terms']);
    this.flagTest=false;

  }
  title = 'app';

}
