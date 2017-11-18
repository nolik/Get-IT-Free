import {Component, Input} from '@angular/core';
import {AdvertModel} from './adverts/advert/advert.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
 detailAdvert: AdvertModel;
  title = 'Get It Free portal';

  loadedFeature = 'adverts';

  onNavigate(feature: string) {
    this.loadedFeature = feature;
  }

  openDetailAdvert(detailAdvert: AdvertModel) {
    this.detailAdvert = detailAdvert;
    this.loadedFeature = 'detailAdvert';
  }
}
