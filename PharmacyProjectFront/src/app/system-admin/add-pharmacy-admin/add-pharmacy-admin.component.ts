import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/login/login.service';
import { SystemAdminService } from 'src/app/service/system-admin.service';
import { User } from 'src/app/user';


@Component({
  selector: 'add-pharmacy-admin',
  templateUrl: './add-pharmacy-admin.component.html'
})
export class AddPharmacyAdminComponent implements OnInit{


  user: User;
  newPhAdmin: User;
  password1: string;
  submitted = false;
  done:boolean=false;
  

  constructor(private loginService: LoginService,private systemAdminService: SystemAdminService,private formBuilder: FormBuilder,private router:Router) {
    this.newPhAdmin=new User();
    
    this.user= new User();
    this.password1="";
  }


  ngOnInit()  {
    this.password1="";
  }
  


  register() {
    console.log(this.newPhAdmin);

    this.systemAdminService.registerPharmacyAdmin(this.newPhAdmin).subscribe(
        {
            next: phAdmin => {
                this.newPhAdmin = phAdmin;
                console.log(this.newPhAdmin);
                alert("Added new pharmacy admin!");
                this.refresh();
                if (this.newPhAdmin == null) {
                    alert("User with this email is already registered!");
                }
            }
        });
   
   
}

refresh() {
    window.location.reload();
}

}
