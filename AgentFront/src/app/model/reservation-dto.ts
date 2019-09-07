export class ReservationDTO {

    //id:Number;
    checkInDate:Date;
    checkOutDate:Date;
    //status:String;
    idUnit:Number;
    usernameGuest:String;
    totalPrice:Number;


    constructor(checkInDate:Date,checkOutDate:Date,idUnit:Number,usernameGuest:String, totalPrice:Number){
        this.checkInDate=checkInDate;
        this.checkOutDate=checkOutDate;
        this.idUnit=idUnit;
        this.usernameGuest=usernameGuest;
        this.totalPrice=totalPrice;
    }
}
