import { Component, OnInit } from '@angular/core';
import { Routes, Router } from '@angular/router';
import { USERNAME_KEY, USER_ID_KEY, USER_ROLE_KEY, USER_TOKEN_KEY } from 'src/app/config/localStorageKeys';
import { LoginService } from 'src/app/login/login.service';
import { Medicine } from 'src/app/model/medicine';
import { UserService } from 'src/app/service';
import { PatientService } from 'src/app/service/patient.service';
import { User } from 'src/app/user';




@Component({
  templateUrl: './patient-homepage.component.html'

})

export class PatientHomepageComponent implements OnInit {

    user: User;
    request!: Request;
    editedUser: User;
    myAllergies: Medicine[];
    allMedicines: Medicine[];
    newAllergy!: string;
    poruka:String;
  
    constructor(private router: Router, private loginService: LoginService,private userService:UserService,private patientService: PatientService) {
        this.user = new User();
        this.myAllergies=[];
        this.editedUser=new User();
        this.allMedicines= [];
        this.poruka="";
      }
      ngOnInit(): void {
       this.getUser();
      }
      //********PATIENT ALERGIES*******
      getMyAllergies() {
        console.log("UZIMA ALERGIJE"+this.user.id);
        this.patientService.getMyAllergies(this.user.id).subscribe({
               next: allergies => {
                 this.myAllergies = allergies;
                 console.log("UZIMA ALERGIJE"+this.user.id);
               }
           });
      }
      addAllergy(){
        console.log("Dodaje alergiju");
        this.patientService.addAllergy(this.user.id,this.newAllergy).subscribe({
          next: poruka=>
          {
            this.poruka=poruka;
            alert(this.poruka);
          }
        });
        //window.location.reload();
      }
      getAllMedicines(){
        this.patientService.getAllMedicines().subscribe({
          next: medicines => {
            this.allMedicines = medicines;
            console.log("UZIMA ALERGIJE"+this.user.id);
          }
      });
      }

      //******EDIT PROFILE *******
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
            this.getMyAllergies();
            this.getAllMedicines();
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
