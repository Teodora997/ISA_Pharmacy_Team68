import { Component, OnInit } from '@angular/core';
import { Routes, Router } from '@angular/router';
import { User } from 'src/app/user';
import { UserService } from 'src/app/user.service';
import { LoginService } from 'src/app/login/login.service';
import { PromotionService } from 'src/app/service/promotionService';
import { USERNAME_KEY, USER_ID_KEY, USER_ROLE_KEY, USER_TOKEN_KEY } from 'src/app/config/localStorageKeys';
import {Promotion} from 'src/app/model/promotion';
import { HttpClient } from '@angular/common/http'


interface Food {
  value: string;
  viewValue: string;
}

@Component({
  
  templateUrl: './define-discount.component.html',
  
})
export class DefineDiscountComponent implements OnInit {

  user: User;
  medList : String[] = [];
  stringId : any;
  id!: any;
  regMedPrice: string = "";
  selectedPrice!: string;
  selectedMed!: string;
  tempList: String [] =[];
  promotion : Promotion;
  description !: string;
  priceAfter!: number;
  startDate!: string;
  endDate!: string;
 
  


  constructor(private router: Router, private loginService: LoginService
    , private promotionService: PromotionService,
    private userService: UserService,
    private http: HttpClient,) 
  {
    this.user = new User();
    this.promotion = new Promotion();
    this.stringId = localStorage.getItem(USER_ID_KEY);
    //this.medList = this.getMedecine();
    //this.getMedecine();
    //this.medList = [];
   // this.userId = 0;

   }

  ngOnInit(): void {
    this.medList = [];
    this.tempList = [];
    this.regMedPrice = "";
    this.selectedMed = "";
    this.description = "";
    this.priceAfter = 0;
    this.startDate="";
    this.endDate="";
    this.id = "";
    this.promotion.pharmacyId = 0;
    this.promotion.medicineName = "";
    
    //this.medList = this.getMedecine();

    this.promotionService.getMedicineForPromotion(this.stringId).subscribe(
     {
      next: data  =>
      { 
         for(var i = 0; i < data.length; i++)
         {
           this.medList.push(data[i]);
          }
          
          this.promotionService.getPharmacyId(this.stringId).subscribe(
            data => {
              this.promotion.pharmacyId = data;
              alert('uspesno dodat');
            },
            error => console.error('error',error)
          );
          
          
          
         
          
        }
      }); 
      
    console.log(this.stringId);
      
    
   
    
  }

  onChangeSelect(val: string): void {
    this.promotionService.getMedicinePrice(val).subscribe(
      data =>{
      this.regMedPrice = data; 
     
      var numberToValue = Number(this.regMedPrice);
      this.promotion.priceBefore = numberToValue;
      this.promotion.medicineName = this.selectedMed;
      console.log(this.promotion.priceBefore);
      console.log(this.promotion.medicineName);
      }
      );

      console.log(this.selectedMed);
      
  }
  
  onChangeDescription(val : string): void {
    this.promotion.description = val;
    console.log(this.description);
  }
  onChangePriceAfter(val: number): void {
    var number = Number(val);
    this.promotion.priceAfter = number;
    console.log(this.priceAfter);
  }

  onChangeStartDate(val : string): void {
    this.promotion.startDate = val;
    console.log(this.startDate);
    console.log(this.promotion.pharmacyId);
  }
  onChangeEndDate(val : string): void {
    this.promotion.endDate = val;
    console.log(this.endDate);
   // this.getPharmacyId();
    //console.log(this.promotion.pharmacyId);
    
    
  }
  
  /*getPharmacyId() : void
  {
    var retVal : number = 45;
    var temp: any = localStorage.getItem(USER_ID_KEY);
    console.log(temp);
    this.promotionService.getPharmacyId(temp).subscribe(
    
      data => {
        this.promotion.pharmacyId = data;
        console.log(this.promotion.pharmacyId);
      }
    
    );
    console.log(this.promotion.pharmacyId);
     //return retVal;
        
  } */

  addPromotion() {
    const formData = new FormData();
    this.promotion.id = 0;
    //this.promotion.medicineName = "sdsadas";
    
    
    

    return this.http.post('http://localhost:8081/api/promotion/addPromotion/', this.promotion).toPromise();
  }
   
  
  
}


  
   


   
  


  





  
  

  
  
  




