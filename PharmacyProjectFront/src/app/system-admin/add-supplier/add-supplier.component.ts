import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/login/login.service';
import { SystemAdminService } from 'src/app/service/system-admin.service';
import { User } from 'src/app/user';


@Component({
  selector: 'add-supplier',
  templateUrl: './add-supplier.component.html'
})
export class AddSupplierComponent implements OnInit{


  user: User;
  newSupplier: User;
  password1: string;
  submitted = false;
  done:boolean=false;
  

  constructor(private loginService: LoginService,private systemAdminService: SystemAdminService,private formBuilder: FormBuilder,private router:Router) {
    this.newSupplier=new User();
    
    this.user= new User();
    this.password1="";
  }


  ngOnInit()  {
    this.password1="";
  }
  


  register() {
    console.log(this.newSupplier);

    this.systemAdminService.registerSupplier(this.newSupplier).subscribe(
        {
            next: supplier => {
                this.newSupplier = supplier;
                console.log(this.newSupplier);
                alert("Added new supplier!");
                this.refresh();
                if (this.newSupplier == null) {
                    alert("User with this email is already registered!");
                }
            }
        });
   
   
}

refresh() {
    window.location.reload();
}

}
