import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
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
}
