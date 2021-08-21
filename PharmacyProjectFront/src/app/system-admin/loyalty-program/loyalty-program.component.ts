import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/login/login.service';
import { LoyaltyProgram } from 'src/app/model/loyaltyProgram';
import { Pharmacy } from 'src/app/model/pharmacy';
import { SystemAdminService } from 'src/app/service/system-admin.service';
import { User } from 'src/app/user';


@Component({
  selector: 'loyalty-program',
  templateUrl: './loyalty-program.component.html'
})
export class LoyaltyProgramComponent implements OnInit{


  user: User;
  newLoyalty: LoyaltyProgram;
  password1: string;
  submitted = false;
  done:boolean=false;
  

  constructor(private loginService: LoginService,private systemAdminService: SystemAdminService,private formBuilder: FormBuilder,private router:Router) {
    this.newLoyalty=new LoyaltyProgram();
    
    this.user= new User();
    this.password1="";
  }


  ngOnInit()  {
    this.password1="";
  }
  


  addLoyaltyProgram() {
    console.log(this.newLoyalty);

    this.systemAdminService.addLoyaltyProgram(this.newLoyalty).subscribe(
        {
            next: program => {
                this.newLoyalty = program;
                console.log(this.newLoyalty);
                alert("Loyalty program added!");
            }
        });
   
   
}

refresh() {
    window.location.reload();
}

}
