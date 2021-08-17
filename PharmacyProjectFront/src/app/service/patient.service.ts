import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Medicine } from "../model/medicine";
@Injectable()
export class PatientService {
  constructor(private http: HttpClient) {
  }
  public getMyAllergies(id:String): Observable<Medicine[]> {
    return this.http.get<Medicine[]>("http://localhost:8081/api/patients/getMyAllergies/"+id);
  }
  public addAllergy(userId:String,medId:string): Observable<String> {
    return this.http.post<String>("http://localhost:8081/api/patients/addAllergy/"+medId,userId);
  }
  public getAllMedicines(): Observable<Medicine[]> {
    return this.http.get<Medicine[]>("http://localhost:8081/api/patients/getAllMedicines");
  }
}