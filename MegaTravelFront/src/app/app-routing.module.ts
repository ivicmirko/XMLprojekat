import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { SearchFilterComponent } from './search-filter/search-filter.component';
import { FacilityASComponent } from './sifarnik/facility-as/facility-as.component';
import { UnitASComponent } from './sifarnik/unit-as/unit-as.component';
import { FacilityTypeComponent } from './sifarnik/facility-type/facility-type.component';
import { KategorijaComponent } from './sifarnik/kategorija/kategorija.component';
import { UserAdminComponent } from './user-admin/user-admin.component';
import { AgentAdminComponent } from './agent-admin/agent-admin.component';
import { SearchUnitsComponent } from './search-units/search-units.component';
import { UserReservationsComponent } from './user-reservations/user-reservations.component';



const routes: Routes = [
  {path: '', component:HomeComponent},
  {path: 'login', component:LoginComponent},
  {path: 'registration', component:RegistrationComponent},
  {path: 'search', component:SearchFilterComponent},
  {path: 'admin/category', component:KategorijaComponent},
  {path: 'admin/facilityAS', component:FacilityASComponent},
  {path: 'admin/unitAS', component:UnitASComponent},
  {path: 'admin/facilityType', component:FacilityTypeComponent},
  {path: 'admin/allusers', component: UserAdminComponent},
  {path: 'admin/allagents', component: AgentAdminComponent},
  {path: 'searchunits', component: SearchUnitsComponent},
  {path: 'userreservations', component:UserReservationsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
