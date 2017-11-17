import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { AdvertsComponent } from './adverts/adverts.component';
import { AddAdvertComponent } from './adverts/add-advert/add-advert.component';
import { AdvertComponent } from './adverts/advert/advert.component';
import { AdvertDetailComponent } from './adverts/advert-detail/advert-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AdvertsComponent,
    AddAdvertComponent,
    AdvertComponent,
    AdvertDetailComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
