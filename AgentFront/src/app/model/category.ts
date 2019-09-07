import { AccommodationFacility } from './accommodation-facility';

export class Category {
    
    id:Number;
    name:String;
    accommodationFacility:AccommodationFacility[];

    constructor(id:Number,name:String,accommodationFacility:AccommodationFacility[]){
        this.id=id;
        this.name=name;
        this.accommodationFacility=accommodationFacility;
    }
}
