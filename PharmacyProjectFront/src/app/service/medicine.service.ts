import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Medicine } from "../model/medicine";
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
}
