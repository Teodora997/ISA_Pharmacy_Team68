import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/login/login.service';
import { Pharmacy } from 'src/app/model/pharmacy';
import { SystemAdminService } from 'src/app/service/system-admin.service';
import { User } from 'src/app/user';


@Component({
  selector: 'add-pharmacy',
  templateUrl: './add-pharmacy.component.html'
})
export class AddPharmacyComponent implements OnInit{


  user: User;
  newPharmacy: Pharmacy;
  password1: string;
  submitted = false;
  done:boolean=false;
  

  constructor(private loginService: LoginService,private systemAdminService: SystemAdminService,private formBuilder: FormBuilder,private router:Router) {
    this.newPharmacy=new Pharmacy();
    
    this.user= new User();
    this.password1="";
  }


  ngOnInit()  {
    this.password1="";
  }
  


  addPharmacy() {
    console.log(this.newPharmacy);

    this.systemAdminService.addPharmacy(this.newPharmacy).subscribe(
        {
            next: pharmacy => {
                this.newPharmacy = pharmacy;
                console.log(this.newPharmacy);
                alert("Added new pharmacy!");
                this.refresh();
            }
        });
   
   
}

refresh() {
    window.location.reload();
}

}
