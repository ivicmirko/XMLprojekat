import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http'
import {ReactiveFormsModule, FormsModule} from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { SearchFilterComponent } from './search-filter/search-filter.component';
import { FacilityTypeComponent } from './sifarnik/facility-type/facility-type.component';
import { FacilityASComponent } from './sifarnik/facility-as/facility-as.component';
import { UnitASComponent } from './sifarnik/unit-as/unit-as.component';
import { TokenInterceptorServiceService } from './service/TokenInterceptorService/token-interceptor-service.service';
import { KategorijaComponent } from './sifarnik/kategorija/kategorija.component';
import { UserAdminComponent } from './user-admin/user-admin.component';
import { AgentAdminComponent } from './agent-admin/agent-admin.component';
import { SearchUnitsComponent } from './search-units/search-units.component';
import { UserReservationsComponent } from './user-reservations/user-reservations.component';


@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    RegistrationComponent,
    LoginComponent,
    HomeComponent,
    SearchFilterComponent,
    FacilityTypeComponent,
    FacilityASComponent,
    UnitASComponent,
    KategorijaComponent,
    UserAdminComponent,
    AgentAdminComponent,
    SearchUnitsComponent,
    UserReservationsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorServiceService,
      multi: true,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
