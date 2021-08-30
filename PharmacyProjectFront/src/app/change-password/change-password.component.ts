import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { LoginService } from "../login/login.service";
import { PasswordChanger } from "../model/passwordChanger";
import { User } from "../user";

@Component({
    selector: 'change-password',
    templateUrl: './change-password.component.html'
  })
  
  export class ChangePasswordComponent implements OnInit {
    user: User;
    passwordChanger:PasswordChanger;
  

    constructor(private router: Router, private loginService: LoginService) {
      
      this.user = new User();
      this.passwordChanger=new PasswordChanger();
  
    }
  
    ngOnInit() {
      this.getUser();
    }
      
    changePassword(){
      this.loginService.changePassword(this.passwordChanger).subscribe({
          next: u => {
            this.user = u;
            console.log(this.user);
           
            if (this.user.role == "PATIENT") {
  
              this.router.navigate(["/patient-homepage"]);
    
            } else if (this.user.role == "ROLE_PH_ADMIN") {
    
              this.router.navigate(["/phadmin-homepage"]);
    
            } else if (this.user.role == "ROLE_SYS_ADMIN") {
                console.log("aaaaaaaaaaaa");
    
              this.router.navigate(["/system-admin-homepage"]);
    
            } else if (this.user.role == "ROLE_SUPPLIER") {
    
              this.router.navigate(["/supplier-homepage"]);
    
            }else if (this.user.role == "ROLE_PHARMACIST") {
  
              this.router.navigate(["/pharmacist-homepage"]);
    
            }else if (this.user.role == "ROLE_DERMATOLOGIST") {
    
              this.router.navigate(["/dermatologist-homepage"]);
    
            }
    
        }
        });
  
    }
  
    getUser() {
  
        this.loginService.getLoggedUser().subscribe({
          next: user => {
            this.user = user;
    
            console.log(this.user);
            
    
          }
    
        });
    
      }
  
  }