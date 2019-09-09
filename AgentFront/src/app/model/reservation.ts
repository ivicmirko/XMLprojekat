import { AccommodationUnit } from './accommodation-unit';

export class Reservation {

    id:Number;
    checkInDate:Date;
    checkOutDate:Date;
    isRealised:boolean;
    accommodationUnit:AccommodationUnit;
    usernameGuest:String;
    totalPrice:Number;
    facilityName:String;


    constructor(id:Number,checkInDate:Date,checkOutDate:Date,isRealised:boolean,
        accommodationUnit:AccommodationUnit,usernameGuest:String, totalPrice:Number, facilityName:string){
        this.id=id;
        this.accommodationUnit=accommodationUnit;
        this.isRealised=isRealised;
        this.checkInDate=checkInDate;
        this.checkOutDate=checkOutDate;
        this.usernameGuest=usernameGuest;
        this.totalPrice=totalPrice;
        this.facilityName=facilityName;
    }
}
