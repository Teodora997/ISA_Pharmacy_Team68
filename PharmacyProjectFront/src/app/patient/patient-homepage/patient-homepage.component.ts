import { Component, OnInit } from '@angular/core';
import { Routes, Router } from '@angular/router';
import { USERNAME_KEY, USER_ID_KEY, USER_ROLE_KEY, USER_TOKEN_KEY } from 'src/app/config/localStorageKeys';
import { LoginService } from 'src/app/login/login.service';
import { UserService } from 'src/app/service';
import { User } from 'src/app/user';




@Component({
  templateUrl: './patient-homepage.component.html'

})

export class PatientHomepageComponent implements OnInit {

    user: User;
    request!: Request;
    editedUser: User;
  
    constructor(private router: Router, private loginService: LoginService,private userService:UserService) {
        this.user = new User();
        this.editedUser=new User();
      }
      ngOnInit(): void {
       this.getUser();
      }

      editProfile():void{
        console.log("izmjena profilaaaaaa " +this.user.firstName);
        this.userService.editProfile(this.user).subscribe();
        alert("Profile edited!");   
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
