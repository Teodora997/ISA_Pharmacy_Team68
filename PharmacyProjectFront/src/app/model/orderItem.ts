import { Medicine } from "./medicine";

export class OrderItem {
    id!:number;
    medicine!: Medicine;
    amount!:number;
}