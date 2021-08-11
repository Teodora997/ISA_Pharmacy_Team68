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


  
  registrationModel= new User("","","","","","","","","","");
  requestModel= new RequestForReg(this.registrationModel,0,false);
  registerForm!: FormGroup;
  submitted = false;
  done:boolean=false;
  

  constructor(private userService:UserService,private formBuilder: FormBuilder,private router:Router) {}


  ngOnInit(): void {
    this.registerForm=this.formBuilder.group({
      firstName: ['',Validators.required],
      lastName:['',Validators.required],
      email: ['',[Validators.required,Validators.email]],
      address:['',Validators.required],
      city: ['',Validators.required],
      telephone:['',Validators.required],
      password: ['',[Validators.required,Validators.minLength(3)]],
      password1:['',[Validators.required,Validators.minLength(3)]]  
    });
  }
  
  get f() {return this.registerForm.controls;}

  onSubmit(){

    console.log(this.requestModel.userData.email);
    this.userService.enroll(this.requestModel)
    .subscribe(
      data=>{
        alert("Request is sent")
        this.done=true;
        console.log("Success!")
      },
      error=>console.error("Error!",error)
    )

    this.submitted=true;
    if(this.registerForm.invalid){
      return;
    }
    alert('Registered')
  }

}
