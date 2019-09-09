import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http' 
import {ReactiveFormsModule, FormsModule} from '@angular/forms'


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { LoginComponent } from './login/login.component';
import { from } from 'rxjs';

import { FacilitiesComponent } from './facilities/facilities.component';
import { TokenInterceptorServiceService } from './service/TokenInterceptorService/token-interceptor-service.service';
import { AgentReservationComponent } from './agent-reservation/agent-reservation.component';
import { ReservationsComponent } from './reservations/reservations.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    LoginComponent,
    FacilitiesComponent,
    AgentReservationComponent,
    ReservationsComponent
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
