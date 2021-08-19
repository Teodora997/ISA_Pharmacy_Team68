import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { USERNAME_KEY, USER_ID_KEY, USER_ROLE_KEY, USER_TOKEN_KEY } from 'src/app/config/localStorageKeys';
import { LoginService } from 'src/app/login/login.service';
import { Medicine } from 'src/app/model/medicine';
import { MedicineService } from 'src/app/service/medicine.service';
import { PharmacyService } from 'src/app/service/pharmacy.service';
import { User } from 'src/app/user';



@Component({
  selector: 'admin-all-medicines',
  templateUrl: './admin-all-medicines.component.html'
})

export class AdminAllMedicinesComponent implements OnInit {
  
  allMedicines : Medicine[] = [];  
  searchParameter!: string;
  filterParameter!:string;
  user: User;
  request!: Request;
  selectedMedicine: Medicine;

  constructor(private router: Router,private medicineService:MedicineService, private pharmacyService: PharmacyService,private loginService:LoginService) {
    this.selectedMedicine=new Medicine();
    this.user=new User();
   }

ngOnInit(): void {
    this.getUser();
    this.medicineService.getAllMedicines().subscribe({
        next: m => {
            this.allMedicines = m;
            
        }

    });

}
pretraga(){
  console.log(this.searchParameter);
  let sp = "";
        if(this.searchParameter== undefined){
            sp = "all";
        } else {
            sp= this.searchParameter;
        }

        console.log(this.searchParameter);
        console.log(sp);

        this.medicineService.searchMedicines(sp).subscribe({
            next: m => {
                this.allMedicines = m;
            }

        });
}

filter(){
  console.log(this.filterParameter);
  let sp = "";
        if(this.filterParameter== undefined){
            sp = "all";
        } else {
            sp= this.filterParameter;
        }

        console.log(this.filterParameter);
        console.log(sp);

        this.medicineService.filterMedicines(sp,this.allMedicines).subscribe({
            next: m => {
                this.allMedicines = m;
            }

        });
}


getUser() {
    
    this.loginService.getLoggedUser().subscribe({
      next: t => {
        this.user = t;
        console.log(this.user.city);
      }

    });

  }
  

  
  redirect() {
    this.router.navigate(["/homepage"]);
  }
}