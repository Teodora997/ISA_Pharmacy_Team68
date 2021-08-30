import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import {Promotion} from 'src/app/model/promotion';


@Injectable()
export class PromotionService {
    url = "http://localhost:8081/api/promotion/getMedicinesForPromotion";

    constructor(private http: HttpClient) {
    }

        public getMedicineForPromotion(adminId : String): Observable<String[]> 
        {
            return this.http.get<String[]>("http://localhost:8081/api/promotion/getMedicinesForPromotion/" + adminId);
        }

        public getMedicinePrice(medName: string): Observable<string>
        {
            return this.http.get<string>("http://localhost:8081/api/promotion/getMedicinePrice/" + medName);
        } 

        public getPharmacyId(data: string): Observable<number>{
            return this.http.get<number>("http://localhost:8081/api/phadmin/getPharmacyId/" + data);
        }










}