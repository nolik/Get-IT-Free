import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { AdvertListComponent } from './adverts/advert-list.component';
import { AddAdvertComponent } from './adverts/add-advert/add-advert.component';
import { AdvertComponent } from './adverts/advert/advert.component';
import { AdvertDetailComponent } from './adverts/advert-detail/advert-detail.component';
import {DropdownDirective} from './shared/dropdown.directive';
import {AdvertService} from './adverts/advert.service';
import {RouterModule, Routes} from '@angular/router';

const appRoutes: Routes = [
  { path: '', component: AdvertListComponent },
  { path: 'advert-list', component: AdvertListComponent },
  { path: 'add-advert', component: AddAdvertComponent },
  { path: 'advert-detail/:id', component: AdvertDetailComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AdvertListComponent,
    AddAdvertComponent,
    AdvertComponent,
    AdvertDetailComponent,
    DropdownDirective
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [AdvertService],
  bootstrap: [AppComponent]
})
export class AppModule { }
