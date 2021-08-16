import { Component, OnInit } from '@angular/core';
import { Routes, Router } from '@angular/router';
import { USERNAME_KEY, USER_ID_KEY, USER_ROLE_KEY, USER_TOKEN_KEY } from 'src/app/config/localStorageKeys';
import { LoginService } from 'src/app/login/login.service';
import { User } from 'src/app/user';




@Component({
  templateUrl: './patient-homepage.component.html'

})

export class PatientHomepageComponent implements OnInit {

    user: User;
    request!: Request;
  
    constructor(private router: Router, private loginService: LoginService) {
        this.user = new User();
    
      }
      ngOnInit(): void {
       this.getUser();
      }
      editProfile():void{

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
