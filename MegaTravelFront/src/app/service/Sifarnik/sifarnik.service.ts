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

const srcResUrl="http://localhost:8763/srcres/api/"

@Injectable({
  providedIn: 'root'
})
export class SifarnikService {

  private getAllDestinationsUrl=srcResUrl+"src/getAllDestinations";
  private getAllCategoriesUrl=srcResUrl+"src/getAllCategories";
  private getAllFasUrl=srcResUrl+"src/getAllfas";
  private getAllUasUrl=srcResUrl+"src/getAlluas";
  private getAllFacilityTypesUrl=srcResUrl+"src/getAllFacilityTypes";
  private addCategoryUrl=srcResUrl+"src/addCategory";
  private deleteCategoryUrl=srcResUrl+"src/deleteCategory/";
  private addFASUrl=srcResUrl+"src/addfas";
  private deleteFASUrl=srcResUrl+"src/deletefas/";
  private addUASUrl=srcResUrl+"src/adduas";
  private deleteUASUrl=srcResUrl+"src/deleteuas/";
  private addTypeUrl=srcResUrl+"src/addType";
  private deleteTypeUrl=srcResUrl+"src/deleteType/";

  constructor(private http:HttpClient) { }

  getAllDestinations():Observable<Destination[]>{
    return this.http.get<Destination[]>(this.getAllDestinationsUrl,httpOptions);
  }

  getAllFacilityTypes():Observable<FacilityType[]>{
    return this.http.get<FacilityType[]>(this.getAllFacilityTypesUrl,httpOptions);
  }

  addType(type:FacilityType):Observable<FacilityType>{
    return this.http.post<FacilityType>(this.addTypeUrl,type,httpOptions);
  }

  deleteType(id:Number):Observable<any>{
    let url=this.deleteTypeUrl+id;
    return this.http.delete(url,httpOptions);
  }

  getAllCategories():Observable<Category[]>{
    return this.http.get<Category[]>(this.getAllCategoriesUrl,httpOptions);
  }

  addCategory(category:Category):Observable<Category>{
    return this.http.post<Category>(this.addCategoryUrl,category,httpOptions);
  }

  deleteCategory(id:Number):Observable<any>{
    let url=this.deleteCategoryUrl+id;
    return this.http.delete(url,httpOptions);
  }

  getAlluas():Observable<UnitAS[]>{
    return this.http.get<UnitAS[]>(this.getAllUasUrl,httpOptions);
  }

  addUas(uas:UnitAS):Observable<UnitAS>{
    return this.http.post<UnitAS>(this.addUASUrl,uas,httpOptions);
  }

  deleteUas(id:Number):Observable<any>{
    let url=this.deleteUASUrl+id;
    return this.http.delete(url,httpOptions);
  }

  getAllfas():Observable<FacilityAS[]>{
    return this.http.get<FacilityAS[]>(this.getAllFasUrl,httpOptions);
  }

  addFas(fas:FacilityAS):Observable<FacilityAS>{
    return this.http.post<FacilityAS>(this.addFASUrl,fas,httpOptions);
  }

  deleteFas(id:Number):Observable<any>{
    let url=this.deleteFASUrl+id;
    return this.http.delete(url,httpOptions);
  }
}
