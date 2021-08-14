import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { User } from '../user';
import { RequestForReg } from './requestForReg';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit{


  user: User;
  registrationModel: User;
  password1: string;
  submitted = false;
  done:boolean=false;
  

  constructor(private userService:UserService,private formBuilder: FormBuilder,private router:Router) {
    this.registrationModel=new User();
    this.user= new User();
    this.password1="";
  }


  ngOnInit()  {
    this.password1="";
  }
  


  register(){
    console.log(this.registrationModel.password);
    if(this.registrationModel.password==this.password1){
      this.userService.register(this.registrationModel).subscribe(
        {
          next: user =>{
            this.registrationModel=user;
            console.log(this.user);
            if(this.user==null){
              console.log("User with this email already exists!");
              alert("User with this email already exists!");
            }else{
              alert("Successufully registered!");
            this.router.navigate(["/login"]);
            }
          }
        }
      );
      
    }
      else{
        alert("Passwords must be the same!");
      }

  }

}
