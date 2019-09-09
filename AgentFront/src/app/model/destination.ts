import { AccommodationFacility } from './accommodation-facility';

export class Destination {
    id:Number;
    name:string;
    latitude:Number;
    longitude:Number;

    constructor(id:Number,name:string,latitude:Number,
        longitude:Number){
            this.id=id;
            this.name=name;
            this.longitude=longitude;
            this.latitude=latitude;
            
    }
}
