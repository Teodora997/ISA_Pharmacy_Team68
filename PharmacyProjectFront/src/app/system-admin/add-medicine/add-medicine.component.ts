import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/login/login.service';
import { Medicine } from 'src/app/model/medicine';
import { SystemAdminService } from 'src/app/service/system-admin.service';
import { User } from 'src/app/user';


@Component({
  selector: 'add-medicine',
  templateUrl: './add-medicine.component.html'
})
export class AddMedicineComponent implements OnInit{


  user: User;
  newMedicine: Medicine;
  password1: string;
  submitted = false;
  done:boolean=false;
  

  constructor(private loginService: LoginService,private systemAdminService: SystemAdminService,private formBuilder: FormBuilder,private router:Router) {
    this.newMedicine=new Medicine();
    
    this.user= new User();
    this.password1="";
  }


  ngOnInit()  {
    this.password1="";
  }
  


  addMedicine() {
    console.log(this.newMedicine);

    this.systemAdminService.addMedicine(this.newMedicine).subscribe(
        {
            next: medicine => {
                this.newMedicine = medicine;
                console.log(this.newMedicine);
                alert("Added new medicine!");
               
                if (this.newMedicine == null) {
                    alert("Medicine with this id is already registered!");
                }
            }
        });
   
   
}

refresh() {
    window.location.reload();
}

}
