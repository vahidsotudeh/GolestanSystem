import { Component, OnInit ,ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {Observable} from 'rxjs/Observable';
import {User} from '../poao-classes/user';
import {ProfileService} from '../services/profile-service.service';
import { Title } from '@angular/platform-browser';
import { ModalComponent } from 'ng2-bs3-modal/ng2-bs3-modal';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
  providers:[ProfileService]
})
export class ProfileComponent implements OnInit {
  @ViewChild('myModal')
    modal: ModalComponent;
  @ViewChild('userModifyForm') 
    public courseForm: NgForm;
  
  currentUser :User;
  public constructor(private titleService: Title,private route: ActivatedRoute, public profileService:ProfileService ) {
    this.setTitle("profile");
    this.retrieveData();    
    this.currentUser=new User();
  }
  ngOnInit() {
    this.modal.onClose.subscribe(()=>this.ApproveOperation());
    this.modal.onDismiss.subscribe(()=>this.cancelOperation())
    this.modal.onOpen.subscribe(()=>this.openConfirmPanel())
    
  }
  public openConfirmPanel(){

  }
  public cancelOperation(){
  }
  public ApproveOperation(){
   
  }
  public setTitle( newTitle: string) {
    this.titleService.setTitle( newTitle );
  }
  public retrieveData(){
    this.profileService.getUser().then((data)=>{
      this.currentUser=data;
    });

  }
  public modifyForm(form:NgForm){
      if(form.value.email)
        this.currentUser.email=form.value.email;
      if(form.value.firstName)
        this.currentUser.firstName=form.value.firstName;
      if(form.value.lastName)
        this.currentUser.lastName=form.value.lastName;
      if(form.value.password)
        this.currentUser.password=form.value.password;
      this.profileService.updateUser(this.currentUser);
      this.retrieveData();

}

}
