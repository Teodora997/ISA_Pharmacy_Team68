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
  alternatives: string[] = [];
  medicines: Medicine[] = [];
  

  constructor(private loginService: LoginService,private systemAdminService: SystemAdminService,private formBuilder: FormBuilder,private router:Router) {
    this.newMedicine=new Medicine();
    this.medicines=[];
    this.user= new User();
    this.password1="";
  }


  ngOnInit()  {
    this.password1="";
    this.getAllMedicines();
  }
  
  getAllMedicines() {

    this.systemAdminService.getAllMedicines().subscribe(
        {
            next: m => {
                this.medicines = m;
                console.log(this.medicines);
            }
        });
   
   
}

  addMedicine() {
    console.log("Saljem lijek na bek: "+this.newMedicine);

    this.systemAdminService.addMedicine(this.newMedicine).subscribe(
        {
            next: medicine => {
                this.newMedicine = medicine;
                console.log(this.newMedicine);
                
               
                if (this.newMedicine == null) {
                    alert("Medicine with this id is already registered!");
                }else{
                  alert("Added new medicine!");
                }
                
                this.systemAdminService.addAlternatives(this.alternatives, this.newMedicine.id).subscribe(
                  {
                      next: a=> {
                          this.alternatives = a;
                          this.refresh();

                      }
                     
                  });
                 
            }
            
        });
   
}

refresh() {
    window.location.reload();
}

}
