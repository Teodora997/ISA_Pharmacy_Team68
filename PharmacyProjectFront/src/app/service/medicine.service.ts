import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Medicine } from "../model/medicine";
import { MedicineForReservation } from "../model/medicineForReservation";
import { Pharmacy } from "../model/pharmacy";
import { SearchPharmacy } from "../model/searchPharmacy";

@Injectable()
export class MedicineService {
  constructor(private http: HttpClient) {
  }

  public getAllMedicines(): Observable<Medicine[]> {
    return this.http.get<Medicine[]>("http://localhost:8081/api/medicines/getAllMedicines");
  }
  public searchMedicines(sp:String): Observable<Medicine[]> {
    return this.http.post<Medicine[]>("http://localhost:8081/api/medicines/searchMedicines",sp);
  }
  public filterMedicines(sp:String,allMedicines:Medicine[]): Observable<Medicine[]> {
    return this.http.post<Medicine[]>("http://localhost:8081/api/medicines/filterMedicines/"+sp,allMedicines);
  }
  public makeReservation(med:MedicineForReservation,patientId:string): Observable<MedicineForReservation[]> {
    return this.http.post<MedicineForReservation[]>("http://localhost:8081/api/medicines/makeReservation/"+patientId,med);
  }
  public getReservationsByPatient(patientId:string): Observable<MedicineForReservation[]> {
    return this.http.get<MedicineForReservation[]>("http://localhost:8081/api/medicines/getReservationsByPatient/"+patientId);
  }
  public cancelReservation(reservation:MedicineForReservation) :Observable<Object>{
    return this.http.post<Object>("http://localhost:8081/api/medicines/cancelReservation",reservation);
  }
}
