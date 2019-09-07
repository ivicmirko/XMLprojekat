import { AccommodationFacility } from './accommodation-facility';

export class Location {
    id:Number;
    latitude:Number;
    longitude:Number;
    description:String;
    address:String;
    accommodationFacility:AccommodationFacility;

    constructor(id:Number,latitude:Number,longitide:Number,description:String,address:String,
        accommodationFacility){
            this.id=id;
            this.latitude=latitude;
            this.longitude=longitide;
            this.description=description;
            this.address=address;
            this.accommodationFacility=accommodationFacility;

    }
}
