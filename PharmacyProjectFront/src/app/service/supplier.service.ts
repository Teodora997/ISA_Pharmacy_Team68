import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { DisplayOffer } from "../model/displayOffer";
import { Offer } from "../model/offer";
import { Order } from "../model/order";
import { OrderItem } from "../model/orderItem";

@Injectable()
export class SupplierService {
  constructor(private http: HttpClient) {
  }

  public getOrders(userId:string): Observable<Order[]> { 
    return this.http.post<Order[]>("http://localhost:8081/api/supplier/getOrders",userId);
  }
  public getItemsFromOrder(orderId:number): Observable<OrderItem[]> {
    return this.http.post<OrderItem[]>("http://localhost:8081/api/supplier/getItemsFromOrder",orderId);
  }

  public sendOffer(userId:string,orderId:number,offer:Offer): Observable<any> {
    return this.http.post<any>("http://localhost:8081/api/supplier/sendOffer/"+ userId+"/"+orderId,offer);
  }
  public getOffers(userId:string): Observable<DisplayOffer[]> {
    return this.http.post<DisplayOffer[]>("http://localhost:8081/api/supplier/getOffers",userId);
  }
  public changeOffer(userId:string,orderId:number,offer:DisplayOffer): Observable<any> {
    return this.http.post<any>("http://localhost:8081/api/supplier/changeOffer/"+ userId+"/"+orderId,offer);
  }
}
