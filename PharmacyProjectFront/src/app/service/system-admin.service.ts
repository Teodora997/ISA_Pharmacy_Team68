import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Complaint } from "../model/complaint";
import { LoyaltyProgram } from "../model/loyaltyProgram";
import { Medicine } from "../model/medicine";
import { Pharmacy } from "../model/pharmacy";
import { User } from "../user";


@Injectable()
export class SystemAdminService {
  constructor(private http: HttpClient) {
  }

 public registerDermatologist(user:User){
        return this.http.post<User>("http://localhost:8081/api/users/registerDermatologist",user);

 }
 public registerSupplier(user:User){
    return this.http.post<User>("http://localhost:8081/api/users/registerSupplier",user);

}

public registerPharmacyAdmin(user:User){
    return this.http.post<User>("http://localhost:8081/api/users/registerPharmacyAdmin",user);

}
public addPharmacyForAdmin(pharmacy: string, phAdminId:string) {
    return this.http.post<string>("http://localhost:8081/api/users/addPharmacyForAdmin/" + phAdminId, pharmacy);
}
public registerSystemAdmin(user:User){
    return this.http.post<User>("http://localhost:8081/api/users/registerSystemAdmin",user);

}
public addPharmacy(pharmacy:Pharmacy){
    return this.http.post<Pharmacy>("http://localhost:8081/api/pharmacies/addPharmacy",pharmacy);

}
public addMedicine(medicine:Medicine){
    return this.http.post<Medicine>("http://localhost:8081/api/medicines/addMedicine",medicine);

}
public addAlternatives(alternatives: string[], medicineId:string) {
    return this.http.post<string[]>("http://localhost:8081/api/medicines/addAlternatives/" + medicineId, alternatives);
}
public getAllMedicines():Observable<Medicine[]>{
    return this.http.get<Medicine[]>("http://localhost:8081/api/medicines/getAllMedicines");
  }
  public addLoyaltyProgram(program:LoyaltyProgram) {
    return this.http.post<LoyaltyProgram>("http://localhost:8081/api/systemAdmin/addLoyaltyProgram", program);
}
public getComplaints():Observable<Complaint[]>{
    return this.http.get<Complaint[]>("http://localhost:8081/api/systemAdmin/getComplaints");
  }
  public replyComplaint(cId:number,complaintReply:string){
    return this.http.post("http://localhost:8081/api/systemAdmin/replyComplaint/"+cId,complaintReply); 

}
}
