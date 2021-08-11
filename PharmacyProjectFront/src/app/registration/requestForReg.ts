import { User } from "../user";


export class RequestForReg{
    constructor(
        public userData: User,
        public id: number,
        public isAccepted: boolean
    ){}

    public getId(){
        return this.id;
    }
}