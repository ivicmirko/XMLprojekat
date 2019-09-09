import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Destination } from 'src/app/model/destination';
import { FacilityType } from 'src/app/model/facility-type';
import { Category } from 'src/app/model/category';
import { UnitAS } from 'src/app/model/unit-as';
import { FacilityAS } from 'src/app/model/facility-as';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

const agentUrl="http://localhost:2225/api/agent/res/"

@Injectable({
  providedIn: 'root'
})
export class SifarnikService {

  private getAllDestinationsUrl=agentUrl+"getAllDestinations";
  private getAllCategoriesUrl=agentUrl+"getAllCategories";
  private getAllFasUrl=agentUrl+"getAllfas";
  private getAllUasUrl=agentUrl+"getAlluas";
  private getAllFacilityTypesUrl=agentUrl+"getAllFacilityTypes";


  constructor(private http:HttpClient) { }

  getAllDestinations():Observable<Destination[]>{
    return this.http.get<Destination[]>(this.getAllDestinationsUrl,httpOptions);
  }

  getAllFacilityTypes():Observable<FacilityType[]>{
    return this.http.get<FacilityType[]>(this.getAllFacilityTypesUrl,httpOptions);
  }

  getAllCategories():Observable<Category[]>{
    return this.http.get<Category[]>(this.getAllCategoriesUrl,httpOptions);
  }

  getAlluas():Observable<UnitAS[]>{
    return this.http.get<UnitAS[]>(this.getAllUasUrl,httpOptions);
  }

  getAllfas():Observable<FacilityAS[]>{
    return this.http.get<FacilityAS[]>(this.getAllFasUrl,httpOptions);
  }
}
