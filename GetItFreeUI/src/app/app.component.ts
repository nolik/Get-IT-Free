import {Component, Input, OnInit} from '@angular/core';
import {AdvertModel} from './adverts/advert/advert.model';
import {AdvertService} from './adverts/advert.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  detailAdvert: AdvertModel;


  loadedFeature: string;


  constructor(private advertService: AdvertService) {
  }

  ngOnInit() {
    this.advertService.advertSelected
      .subscribe(
        (advert: AdvertModel) => {
          this.detailAdvert = advert;
          this.loadedFeature = 'advert-detail';
        }
      );
  }
}
