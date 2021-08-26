import { OrderItem } from "./orderItem";
import { Pharmacy } from "./pharmacy";

export class Order{
    id!:number;
    timeLimit!:Date;
    pharmacyName!:string;
    orderStatus!:string;

}