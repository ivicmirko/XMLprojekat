import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { ProfileDTO } from 'src/app/model/profile-dto';
import { AccommodationFacility } from 'src/app/model/accommodation-facility';

@Injectable({
  providedIn: 'root'
})
export class ShareService {

  shareIsLogged= new Subject<any>();
  shareProfile= new Subject<ProfileDTO>();
  shareFacilities=new Subject<AccommodationFacility[]>();

  constructor() { }

  sendIsLogged(isLogged:boolean){
    this.shareIsLogged.next(isLogged);
  }

  sendProfile(profile:ProfileDTO){
    this.shareProfile.next(profile);
  }

  sendFacilities(facilities:AccommodationFacility[]){
    this.shareFacilities.next(facilities);
  }
}
