import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AdvertListComponent} from './adverts/advert-list.component';
import {AddAdvertComponent} from './adverts/add-advert/add-advert.component';
import {AdvertDetailComponent} from './adverts/advert-detail/advert-detail.component';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';
import {AuthGuardService} from './auth-guard.service';


const appRoutes: Routes = [
  { path: '', component: AdvertListComponent },
  { path: 'advert-list', component: AdvertListComponent },
  { path: 'add-advert', component: AddAdvertComponent },
  { path: 'advert-detail', children: [
      {path: ':id', component: AdvertDetailComponent},
      {path: ':id/#edit', canActivate: [AuthGuardService], component: AdvertDetailComponent}
      ]},
  { path: '404', component: PageNotFoundComponent},
  { path: '**', redirectTo: '404'}
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
