import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AdvertListComponent} from './adverts/advert-list.component';
import {AddAdvertComponent} from './adverts/add-advert/add-advert.component';
import {AdvertDetailComponent} from './adverts/advert-detail/advert-detail.component';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';
// import {AuthGuardService} from './auth-guard.service';
import {ErrorPageComponent} from './error-page/error-page.component';
import {AdvertDetailResolver} from './adverts/advert-detail/advert-detail-resolver.service';
import {AdvertEditComponent} from './adverts/advert-detail/advert-edit/advert-edit.component';
import {SignupComponent} from './signup/signup.component';
import {GuestGuard} from './guard';
import {LoginComponent} from './login';


const appRoutes: Routes = [
  {path: '', redirectTo: '/advert-list', pathMatch: 'full'},
  {path: 'advert-list', component: AdvertListComponent},
  {path: 'add-advert', component: AddAdvertComponent},
  {
    path: 'advert-detail', children: [
      {path: ':_id', component: AdvertDetailComponent, resolve: {detailedAdvert: AdvertDetailResolver}},
      {path: ':_id/edit', /*canActivate: [AuthGuardService],*/ component: AdvertEditComponent}
    ]
  },
  {
    path: 'signup',
    component: SignupComponent,
    canActivate: [GuestGuard],
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent,
    canActivate: [GuestGuard]
  },
  {path: '404', component: PageNotFoundComponent},
  {
    path: 'error', children: [
      {path: 'custom-error', component: ErrorPageComponent, data: {message: 'Catch a custom error'}}
    ]
  },
  {path: '**', redirectTo: '404'}
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
