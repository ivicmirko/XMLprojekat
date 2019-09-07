import { AccommodationFacility } from './accommodation-facility';

export class Destination {
    id:Number;
    name:string;
    latitude:Number;
    longitude:Number;
    accommodationFacility:AccommodationFacility[];

    constructor(id:Number,name:string,latitude:Number,
        longitude:Number,accommodationFacility:AccommodationFacility[]){
            this.id=id;
            this.name=name;
            this.longitude=longitude;
            this.latitude=latitude;
            this.accommodationFacility=accommodationFacility;
    }
}
