import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { FacilitiesComponent } from './facilities/facilities.component';
import { ReservationsComponent } from './reservations/reservations.component';
import { MessageComponent } from './message/message.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'facilities', component: FacilitiesComponent},
  {path: 'reservations', component: ReservationsComponent},
  {path: 'messages', component: MessageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
