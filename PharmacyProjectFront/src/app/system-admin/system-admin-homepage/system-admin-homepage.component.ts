import { Component, OnInit } from '@angular/core';
import { Routes, Router } from '@angular/router';
import { USERNAME_KEY, USER_ID_KEY, USER_ROLE_KEY, USER_TOKEN_KEY } from 'src/app/config/localStorageKeys';
import { LoginService } from 'src/app/login/login.service';
import { User } from 'src/app/user';




@Component({
  templateUrl: './system-admin-homepage.component.html'

})

export class SystemAdminHomepageComponent implements OnInit {

     user: User;
    request!: Request;
  
    constructor(private router: Router, private loginService: LoginService) {
        this.user = new User();
    
      }
      ngOnInit(): void {
       this.getUser();
      }
    
    
      getUser() {
    
        this.loginService.getLoggedUser().subscribe({
          next: user => {
            this.user = user;
            console.log(this.user.firstName);
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
