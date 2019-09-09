import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClientModule, HttpClient } from '@angular/common/http';

import { NewFacilityDTO } from 'src/app/model/new-facility-dto';
import { Observable } from 'rxjs';
import { AccommodationFacility } from 'src/app/model/accommodation-facility';
import { NewUnitDto } from 'src/app/model/new-unit-dto';
import { AccommodationUnit } from 'src/app/model/accommodation-unit';
import { NewReservationDTO } from 'src/app/model/new-reservation-dto';
import { Reservation } from 'src/app/model/reservation';
import { AccommodationUnitDTO } from 'src/app/model/accommodation-unit-dto';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

const agentUrl="http://localhost:2225/api/agent/res/"

@Injectable({
  providedIn: 'root'
})
export class AccommodationService {

  private addFacilityUrl=agentUrl+"addFacility";
  private uploadImageUrl=agentUrl+"uploadImage/";
  private getAllFacilitiesUrl=agentUrl+"getAllFacilities";
  private addUnitUrl=agentUrl+"addUnit";
  private addReservationUrl=agentUrl+"newReservation";
  private realizeReservationUrl=agentUrl+"realizeReservation/"
  private getAllUnitsUrl=agentUrl+"getAllUnits";
  private getAllReservationsUrl=agentUrl+"getAllReservations";
  constructor(private http:HttpClient) { }

  addFacility(facility:NewFacilityDTO):Observable<Number>{
    return this.http.post<Number>(this.addFacilityUrl,facility,httpOptions);
  }

  uploadImage(image:File,id:Number){
    let url=this.uploadImageUrl+id;
    const formData:FormData=new FormData();
    formData.append("image",image);
    return this.http.post(url,formData);
  }

  getAllFacilities(agentId:Number):Observable<AccommodationFacility[]>{
    return this.http.get<AccommodationFacility[]>(this.getAllFacilitiesUrl,httpOptions);
  }

  getAllUnits(agentId:Number):Observable<AccommodationUnitDTO[]>{
    //let url=this.getAllUnitsUrl+agentId;
    return this.http.get<AccommodationUnitDTO[]>(this.getAllUnitsUrl,httpOptions);
  }

  getAllReservations(agentId:Number):Observable<Reservation[]>{
    //let url=this.getAllReservationsUrl+agentId;
    return this.http.get<Reservation[]>(this.getAllReservationsUrl,httpOptions);
  }

  addUnit(unit:NewUnitDto):Observable<any>{
    return this.http.post<any>(this.addUnitUrl,unit,httpOptions);
  }

  makeReservation(reservation:NewReservationDTO):Observable<any>{
    return this.http.post<any>(this.addReservationUrl,reservation,httpOptions);
  }

  realizeReservation(id:Number):Observable<any>{
    let url=this.realizeReservationUrl+id;
    return this.http.put(url,httpOptions);
  }

  
}
