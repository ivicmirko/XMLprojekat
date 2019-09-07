export class SearchFormParams {
    destinationName:string;
    checkIn:Date;
    checkOut:Date;
    //numRooms:Number;
    numPersons:Number;

    constructor(destinationName:string,checkIn:Date,checkOut:Date,numPersons:Number){
            this.destinationName=destinationName;
            this.checkIn=checkIn;
            this.checkOut=checkOut;
            this.numPersons=numPersons;
            //this.numRooms=numRooms;
        }
}
