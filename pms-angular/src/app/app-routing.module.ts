import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';
import { HomeComponent } from './home/home.component';
import { PensionDetailComponent } from './pension-detail/pension-detail.component';
import { PmsLoginComponent } from './pms-login/pms-login.component';

const routes: Routes = [
  {
    path: 'pension',
    component: PensionDetailComponent
  },
  {
    path: 'login',
    component: PmsLoginComponent
  },
  {
    path: 'aboutus',
    component: AboutusComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'contactus',
    component: ContactusComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
