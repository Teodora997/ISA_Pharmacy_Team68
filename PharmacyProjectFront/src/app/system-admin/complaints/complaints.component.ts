import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { USERNAME_KEY, USER_ID_KEY, USER_ROLE_KEY, USER_TOKEN_KEY } from 'src/app/config/localStorageKeys';
import { LoginService } from 'src/app/login/login.service';
import { Complaint } from 'src/app/model/complaint';
import { Medicine } from 'src/app/model/medicine';
import { Pharmacy } from 'src/app/model/pharmacy';
import { PharmacyAndPriceForMedicine } from 'src/app/model/pharmacyAndPriceForMedicine';
import { MedicineService } from 'src/app/service/medicine.service';
import { PharmacyService } from 'src/app/service/pharmacy.service';
import { SystemAdminService } from 'src/app/service/system-admin.service';
import { User } from 'src/app/user';



@Component({
  selector: 'complaints',
  templateUrl: './complaints.component.html'
})

export class ComplaintsComponent implements OnInit {
  
  complaints: Complaint[]=[]; 
  user: User;
  request!: Request; 
  complaintReply!:string;
  ret:Object=new Object();
  response!:any;


  constructor(private router: Router,private systemAdminService:SystemAdminService, private pharmacyService: PharmacyService,private loginService:LoginService) {
   
    this.user=new User(); 
   }

ngOnInit(): void {
    this.getUser();
    this.systemAdminService.getComplaints().subscribe({
        next: c => {
            this.complaints = c;
            
        }

    });

}

replyComplaint(c:Complaint){
   
    this.systemAdminService.replyComplaint(c.id,c.complaintReply).subscribe({
      next: t => {
        this.response = t;
        if(this.response==0){
          alert("Succesufull!");
        }else{
          alert("Already answered!");
        }
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