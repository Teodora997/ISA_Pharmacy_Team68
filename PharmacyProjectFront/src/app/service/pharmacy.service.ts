import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { MedicineForReservation } from "../model/medicineForReservation";
import { Pharmacy } from "../model/pharmacy";
import { PharmacyAndPriceForMedicine } from "../model/pharmacyAndPriceForMedicine";
import { SearchPharmacy } from "../model/searchPharmacy";

@Injectable()
export class PharmacyService {
  constructor(private http: HttpClient) {
  }

  public getAllPhamracies(): Observable<Pharmacy[]> {
    return this.http.get<Pharmacy[]>("http://localhost:8081/api/pharmacies/allPharmacies");
  }

  public getAvailablePharmacies(): Observable<Pharmacy[]> {
    return this.http.get<Pharmacy[]>("http://localhost:8081/api/pharmacies/getAvailablePharmacies");
  }
  public searchPharmacies(sp:SearchPharmacy): Observable<Pharmacy[]> {
    return this.http.post<Pharmacy[]>("http://localhost:8081/api/pharmacies/searchPharmacies",sp);
  }
  public getPharmacy(id:number): Observable<Pharmacy> {
    return this.http.get<Pharmacy>("http://localhost:8081/api/pharmacies/getPharmacy/"+ id);
  }

  public getPharmaciesForMedicine(medicineId:String): Observable<PharmacyAndPriceForMedicine[]> {
    return this.http.post<PharmacyAndPriceForMedicine[]>("http://localhost:8081/api/pharmacies/getPharmaciesForMedicine",medicineId);
  }
  public getPharmaciesForMedicineReservation(medicineId:String): Observable<MedicineForReservation[]> {
    return this.http.post<MedicineForReservation[]>("http://localhost:8081/api/pharmacies/getPharmaciesForMedicineReservation",medicineId);
  }
}
