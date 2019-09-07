import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Destination } from 'src/app/model/destination';
import { FacilityType } from 'src/app/model/facility-type';
import { Category } from 'src/app/model/category';
import { UnitAS } from 'src/app/model/unit-as';
import { FacilityAS } from 'src/app/model/facility-as';
import { ThrowStmt } from '@angular/compiler';
import { SearchFormParams } from 'src/app/model/search-form-params';
import { AccommodationFacility } from 'src/app/model/accommodation-facility';
import { AccommodationUnit } from 'src/app/model/accommodation-unit';
import { ReservationDTO } from 'src/app/model/reservation-dto';
import { Reservation } from 'src/app/model/reservation';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

const srcUrl="http://localhost:8763/srcres/api/src/"
const resUrl="http://localhost:8763/srcres/api/res/"

@Injectable({
  providedIn: 'root'
})
export class SearchReservationService {

  private getFreeFacilitiesUrl=srcUrl+"getFreeFacilities";
  private getFreeUnitsUrl=resUrl+"getFreeUnits/"
  private getFacilityUrl=resUrl+"getFacility/"
  private makeReservationUrl=resUrl+"makeReservation"
  private getMyReservationsUrl=resUrl+'getMyReservations/'
  private cancelReservationUrl=resUrl+'cancelReservation//'

  // private findFreeFacilitiesUrl=srcResUrl+"res/findFreeFacilities";

  constructor(private http:HttpClient) { }

  getFreeFacilities(searchParams:SearchFormParams):Observable<AccommodationFacility[]>{
    return this.http.post<AccommodationFacility[]>(this.getFreeFacilitiesUrl,searchParams,httpOptions);
  }

  getFreeUnits(searchParams:SearchFormParams,idFacility:Number):Observable<AccommodationUnit[]>{
    let url=this.getFreeUnitsUrl+idFacility;
    return this.http.post<AccommodationUnit[]>(url,searchParams,httpOptions);
  }

  getFacility(idFacility:Number):Observable<AccommodationFacility>{
    let url=this.getFacilityUrl+idFacility;
    return this.http.get<AccommodationFacility>(url,httpOptions);
  }

  makeReservation(reservationDTO:ReservationDTO):Observable<any>{
    return this.http.post<any>(this.makeReservationUrl,reservationDTO,httpOptions);
  }

  cancelReservation(id:Number){
    let url=this.cancelReservationUrl+id;
    return this.http.get(url,httpOptions);
  }

  getMyReservations(username:String):Observable<Reservation[]>{
    let url=this.getMyReservationsUrl+username;
    return this.http.get<Reservation[]>(url,httpOptions);
  }

  
}
