import { Component, OnInit } from '@angular/core';
import { Routes, Router } from '@angular/router';
import { USERNAME_KEY, USER_ID_KEY, USER_ROLE_KEY, USER_TOKEN_KEY } from 'src/app/config/localStorageKeys';
import { LoginService } from 'src/app/login/login.service';
import { User } from 'src/app/user';
import { UserService } from 'src/app/user.service';




@Component({
  templateUrl: './system-admin-homepage.component.html'

})

export class SystemAdminHomepageComponent implements OnInit {

     user: User;
     editedUser: User;
    request!: Request;
  
    constructor(private router: Router, private loginService: LoginService,private userService:UserService) {
        this.user = new User();
        this.editedUser=new User();
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
      editProfile():void{
        console.log("izmjena profilaaaaaa " +this.user.firstName);
        this.userService.editProfile(this.user).subscribe();
        alert("Profile edited!");   
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
