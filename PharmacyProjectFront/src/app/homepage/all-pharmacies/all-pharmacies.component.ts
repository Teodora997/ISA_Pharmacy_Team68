import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pharmacy } from 'src/app/model/pharmacy';
import { SearchPharmacy } from 'src/app/model/searchPharmacy';
import { PharmacyService } from 'src/app/service/pharmacy.service';

@Component({
  selector: 'all-pharmacies',
  templateUrl: './all-pharmacies.component.html'
})

export class AllPharmaciesComponent implements OnInit {
  allPharmacies : Pharmacy[] = [];
  previewSearch:boolean;  
  searchParameters: SearchPharmacy;

  constructor(private router: Router, private pharmacyService: PharmacyService) {
    this.searchParameters = new SearchPharmacy();
    this.previewSearch=false;
   }

ngOnInit(): void {
    this.pharmacyService.getAllPhamracies().subscribe({
        next: pharmacies => {
            this.allPharmacies = pharmacies;
            
        }

    });

}
pretraga(){
  console.log(this.searchParameters.name);
  let sp = new SearchPharmacy();
        if(this.searchParameters.name == undefined){
            sp.name = "all";
        } else {
            sp.name = this.searchParameters.name;
        }

        if(this.searchParameters.address == undefined){
            sp.address = "all";
        } else {
            sp.address = this.searchParameters.address;
        }




        console.log(this.searchParameters);
        console.log(sp);

        this.pharmacyService.searchPharmacies(sp).subscribe({
            next: pharmacies => {
                this.allPharmacies = pharmacies;
            }

        });
}

}