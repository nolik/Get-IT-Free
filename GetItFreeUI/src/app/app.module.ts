import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { AdvertListComponent } from './adverts/advert-list.component';
import { AddAdvertComponent } from './adverts/add-advert/add-advert.component';
import { AdvertComponent } from './adverts/advert/advert.component';
import { AdvertDetailComponent } from './adverts/advert-detail/advert-detail.component';
import { DropdownDirective} from './shared/dropdown.directive';
import { AdvertService} from './adverts/advert.service';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AppRoutingModule} from './app-routing.module';
import { AuthGuardService} from './auth-guard.service';
import { AuthService} from './auth.service';
import { ErrorPageComponent } from './error-page/error-page.component';
import {AdvertDetailResolver} from './adverts/advert-detail/advert-detail-resolver.service';
import { AdvertEditComponent } from './adverts/advert-detail/advert-edit/advert-edit.component';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AdvertListComponent,
    AddAdvertComponent,
    AdvertComponent,
    AdvertDetailComponent,
    DropdownDirective,
    ErrorPageComponent,
    AdvertEditComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [AdvertService, AuthGuardService, AuthService, AdvertDetailResolver],
  bootstrap: [AppComponent]
})
export class AppModule { }
