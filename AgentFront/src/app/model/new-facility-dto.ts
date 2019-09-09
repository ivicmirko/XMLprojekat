import { NumberValueAccessor } from '@angular/forms';

export class NewFacilityDTO {
    name:String;
    description:String;
    address:String;
    latitude:Number;
    longitude:Number;
    descriptionLocation:String;
    image:FormData;
    facilityTypeId:Number;
    categoryId:Number;
    facilityAS:Number[];
    destinationId:Number;
    agentId:Number;
}
