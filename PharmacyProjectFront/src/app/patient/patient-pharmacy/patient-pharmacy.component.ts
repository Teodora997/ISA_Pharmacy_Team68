import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { HttpClient } from "@angular/common/http";
import { Pharmacy } from "src/app/model/pharmacy";
import { PharmacyService } from "src/app/service/pharmacy.service";
import { LoginService } from "src/app/login/login.service";
import { User } from "src/app/user";
import { USERNAME_KEY, USER_ID_KEY, USER_ROLE_KEY, USER_TOKEN_KEY } from "src/app/config/localStorageKeys";


@Component({
    templateUrl: './patient-pharmacy.component.html'
})

export class PatientPharmacyComponent implements OnInit {
    pharmacy: Pharmacy;
    id!: number;
    user:User;
    request!: Request;
    

    constructor(private router: Router, private pharmacyService: PharmacyService,private route: ActivatedRoute,private loginService:LoginService) {
        this.pharmacy=new Pharmacy();
        this.user = new User();
       }
    ngOnInit(): void {
        this.getUser();
        const param = this.route.snapshot.paramMap.get('id');
        if (param) {
            this.id = +param;
            this.getPharmacy(this.id);

        }
    }
    getPharmacy(id:number){
        this.pharmacyService.getPharmacy(id).subscribe({
            next: pharmacy => {
                this.pharmacy = pharmacy;
            }

        }

        );
    }
    getUser() {
    
        this.loginService.getLoggedUser().subscribe({
          next: t => {
            this.user = t;
            console.log(this.user.city);
          }
    
        });
    
      }
      
      logout(): void {
        this.loginService.logout(this.request).subscribe(result => this.redirect());
        localStorage.removeItem(USER_ID_KEY);
        localStorage.removeItem(USER_ROLE_KEY);
        localStorage.removeItem(USERNAME_KEY);
        localStorage.removeItem(USER_TOKEN_KEY);

        
        alert('Logged out!');
      }
      
      redirect() {
        this.router.navigate(["/homepage"]);
      }
}
