import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/login/login.service';
import { Pharmacy } from 'src/app/model/pharmacy';
import { PharmacyService } from 'src/app/service/pharmacy.service';
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
  pharmacy!:string;
  pharmacies: Pharmacy[];
  
  constructor(private loginService: LoginService,private pharmacyService: PharmacyService, private systemAdminService: SystemAdminService,private formBuilder: FormBuilder,private router:Router) {
    this.newPhAdmin=new User();
    this.pharmacies=[];
    this.user= new User();
    this.password1="";
  }


  ngOnInit()  {
    this.password1="";
    this.getAvailablePharmacies();
  }
  
  getAvailablePharmacies() {

    this.pharmacyService.getAvailablePharmacies().subscribe(
        {
            next: p => {
                this.pharmacies = p;
                if(this.pharmacies==null){
                  alert("Available pharmacy does not exist!");
                }
                console.log(this.pharmacies);
            }
        });
   
   
}

  register() {
    console.log(this.newPhAdmin);   

    this.systemAdminService.registerPharmacyAdmin(this.newPhAdmin).subscribe(
        {
            next: phAdmin => {
                this.newPhAdmin = phAdmin;
                console.log(this.newPhAdmin);
                alert("Added new pharmacy admin!");
                if (this.newPhAdmin == null) {
                    alert("User with this email is already registered!");
                }
                this.systemAdminService.addPharmacyForAdmin(this.pharmacy, this.newPhAdmin.id).subscribe(
                  {
                      next: p=> {
                          this.pharmacy = p;
                          

                      }
                     
                  });
            }
        });
   
   
}

refresh() {
    window.location.reload();
     
}

}
