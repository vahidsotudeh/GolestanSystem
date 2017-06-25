import { Component ,OnInit, ViewEncapsulation} from '@angular/core';
import { CoursesComponent } from './courses/courses.component';
import {ProfileService} from './services/profile-service.service';
import {routing} from './app.routes';
import {User} from './poao-classes/user';
import {Router} from '@angular/router';
declare var $: any

@Component({
  encapsulation: ViewEncapsulation.None,
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: [
    './app.component.css',
    '../assets/css/master.css'
  ],
  providers:[ProfileService]
})
export class AppComponent implements OnInit {

  public router : Router;
  flagTest = true;
  constructor(r: Router,public profileService:ProfileService) {
    this.currentUser=new User();
      this.router =r;
  }
  currentUser:User;

  ngOnInit() {
    this.profileService.getUser().then((data)=>{
      this.currentUser=data;
    });
  }
  public courseManagement(){
    this.router.navigate(['/courses']);
    this.flagTest=false;

  }
  public groupManagement(){
    $("#menuBar>ul>li.active").removeClass("active");
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
  public registerManagement(){
    this.router.navigate(['/register']);
    this.flagTest=false;
  }
  public classesManagement(){
    this.router.navigate(['/classes']);
    this.flagTest=false;
  }

  public isGroupManager():boolean{    
    if(this.currentUser!=undefined)
    if(this.currentUser.roles.find(x => x.name =="GROUP_MANAGER")!=null){
      return true;
    }
    return false;
  }
  public isStudent():boolean{
    if(this.currentUser!=undefined)
    if(this.currentUser.roles.find(x => x.name =="STUDENT")!=null){
      return true;
    }
    return false;
  }
  public isMaster():boolean{
    if(this.currentUser!=undefined)
    if(this.currentUser.roles.find(x => x.name =="MASTER")!=null){
      return true;
    }
    return false;
  }
  public getRoles():String{
    if(this.isGroupManager()){
      return "GROUP_MANAGER";
    }else if (this.isMaster()){
      return "MASTER";
    }else{
      return "STUDENT";
    }
  }

  title = 'app';


}
