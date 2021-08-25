import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Offer } from "../model/offer";
import { Order } from "../model/order";
import { OrderItem } from "../model/orderItem";

@Injectable()
export class SupplierService {
  constructor(private http: HttpClient) {
  }

  public getOrders(): Observable<Order[]> {
    return this.http.get<Order[]>("http://localhost:8081/api/supplier/getOrders");
  }
  public getItemsFromOrder(orderId:number): Observable<OrderItem[]> {
    return this.http.post<OrderItem[]>("http://localhost:8081/api/supplier/getItemsFromOrder",orderId);
  }

  public sendOffer(orderId:number,offer:Offer): Observable<any> {
    return this.http.post<any>("http://localhost:8081/api/supplier/sendOffer/"+ orderId,offer);
  }
  
}
