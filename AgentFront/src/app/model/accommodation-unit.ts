import { UnitAS } from './unit-as';
import { PricePerMonth } from './price-per-month';
import { AccommodationFacility } from './accommodation-facility';

export class AccommodationUnit {

    id:Number;
    capacity:Number;
    canBeCancelled:Boolean;
    daysBefore:Number;
    unitAS:UnitAS[];
    pricePerMonth:PricePerMonth;
    accommodationFacility:AccommodationFacility;
    currentPrice:Number;
    cancelDate:Date;
    numberOfDays:Number;

    constructor(id:Number, capacity:Number,canBeCancelled:Boolean,daysBefore:Number,unitAS:UnitAS[],accommodationFacility:AccommodationFacility,
        currentPrice:Number,pricePerMonth:PricePerMonth,cancelDate:Date,numberOfDays:Number){
        this.id=id;
        this.capacity=capacity;
        this.canBeCancelled=canBeCancelled;
        this.daysBefore=daysBefore;
        this.unitAS=unitAS;
        this.accommodationFacility=accommodationFacility;
        this.currentPrice=currentPrice;
        this.cancelDate=cancelDate;
        this.numberOfDays=numberOfDays;
    }
}
