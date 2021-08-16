import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/login/login.service';
import { SystemAdminService } from 'src/app/service/system-admin.service';
import { User } from 'src/app/user';


@Component({
  selector: 'add-dermatologist',
  templateUrl: './add-dermatologist.component.html'
})
export class AddDermatologistComponent implements OnInit{


  user: User;
  newDermatologist: User;
  password1: string;
  submitted = false;
  done:boolean=false;
  

  constructor(private loginService: LoginService,private systemAdminService: SystemAdminService,private formBuilder: FormBuilder,private router:Router) {
    this.newDermatologist=new User();
    
    this.user= new User();
    this.password1="";
  }


  ngOnInit()  {
    this.password1="";
  }
  


  register() {
    console.log(this.newDermatologist);

    this.systemAdminService.registerDermatologist(this.newDermatologist).subscribe(
        {
            next: dermatologist => {
                this.newDermatologist = dermatologist;
                console.log(this.newDermatologist);
                alert("Added new dermatologist!");
                this.refresh();
                if (this.newDermatologist == null) {
                    alert("User with this email is already registered!");
                }
            }
        });
   
   
}

refresh() {
    window.location.reload();
}

}
