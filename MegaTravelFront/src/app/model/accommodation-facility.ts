import { FacilityAS } from './facility-as';
import { FacilityType } from './facility-type';
import { Category } from './category';
import { Destination } from './destination';

export class AccommodationFacility {
    id:Number;
    name:String;
    description:String;
    image:any;
    rating:Number;
    voters:Number;
    location:Location;
    facilityAS:FacilityAS[];
    //accommodationUnit:AccommodationUnit;
    facilityType:FacilityType;
    category:Category;
    destination:Destination;
    minPrice:Number;

    constructor(id:Number,name:String,description:String,rating:Number,voters:Number,
        location:Location,facilityAS:FacilityAS[],facilityType:FacilityType,category:Category,destination:Destination,
        minPrice:Number){
            this.id=id;
            this.name=name;
            this.description=description;
            // this.images=images;
            this.rating=rating;
            this.voters=voters;
            this.location=location;
            this.facilityType=facilityType;
            this.facilityAS=facilityAS;
            //this.accommodationUnit=accommodationUnit;
            this.category=category;
            this.destination=destination;
            this.minPrice=minPrice;
        }
}

