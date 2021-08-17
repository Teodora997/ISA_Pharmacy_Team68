import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/login/login.service';
import { SystemAdminService } from 'src/app/service/system-admin.service';
import { User } from 'src/app/user';


@Component({
  selector: 'add-system-admin',
  templateUrl: './add-system-admin.component.html'
})
export class AddSystemAdminComponent implements OnInit{


  user: User;
  newSysAdmin: User;
  password1: string;
  submitted = false;
  done:boolean=false;
  

  constructor(private loginService: LoginService,private systemAdminService: SystemAdminService,private formBuilder: FormBuilder,private router:Router) {
    this.newSysAdmin=new User();
    
    this.user= new User();
    this.password1="";
  }


  ngOnInit()  {
    this.password1="";
  }
  


  register() {
    console.log(this.newSysAdmin);

    this.systemAdminService.registerSystemAdmin(this.newSysAdmin).subscribe(
        {
            next: sysAdmin => {
                this.newSysAdmin = sysAdmin;
                console.log(this.newSysAdmin);
                alert("Added new system admin!");
                this.refresh();
                if (this.newSysAdmin == null) {
                    alert("User with this email is already registered!");
                }
            }
        });
   
   
}

refresh() {
    window.location.reload();
}

}
