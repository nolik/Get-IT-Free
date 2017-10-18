import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AdvertComponent } from './advert/advert.component';
import { AdvertsComponent } from './adverts/adverts.component';

@NgModule({
  declarations: [
    AppComponent,
    AdvertComponent,
    AdvertsComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
