import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Pharmacy } from "../model/pharmacy";
import { SearchPharmacy } from "../model/searchPharmacy";

@Injectable()
export class PharmacyService {
  constructor(private http: HttpClient) {
  }

  public getAllPhamracies(): Observable<Pharmacy[]> {
    return this.http.get<Pharmacy[]>("http://localhost:8081/api/pharmacies/allPharmacies");
  }
  public searchPharmacies(sp:SearchPharmacy): Observable<Pharmacy[]> {
    return this.http.post<Pharmacy[]>("http://localhost:8081/api/pharmacies/searchPharmacies",sp);
  }
}
