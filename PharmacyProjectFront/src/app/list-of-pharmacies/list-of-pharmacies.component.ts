import { Component, OnInit } from '@angular/core';
import { PharmacyService } from '../pharmacy.service';
import { Pharmacy } from './pharmacy';

@Component({
  selector: 'app-list-of-pharmacies',
  templateUrl: './list-of-pharmacies.component.html',
  styleUrls: ['./list-of-pharmacies.component.css']
})
export class ListOfPharmaciesComponent implements OnInit {

  public pharmacies:Pharmacy[]=[];
  constructor(private pharmacyService:PharmacyService) { }
  public getPharmacies():void{
    this.pharmacyService.getPharmacies().subscribe(
    (
      response:Pharmacy[])=>{
        this.pharmacies=response;
      }
    
    )
  }
  ngOnInit(): void {
    this.getPharmacies();
  }

}
