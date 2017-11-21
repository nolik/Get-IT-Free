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
    BrowserModule
  ],
  providers: [AdvertService],
  bootstrap: [AppComponent]
})
export class AppModule { }
