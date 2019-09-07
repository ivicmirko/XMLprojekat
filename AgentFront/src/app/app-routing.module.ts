import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { FacilitiesComponent } from './facilities/facilities.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'facilities', component: FacilitiesComponent},
  //{path: 'reservations', component: Rese}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
