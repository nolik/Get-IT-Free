import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {AdvertModel} from './advert/advert.model';
import {AdvertService} from './advert.service';

@Component({
  selector: 'app-adverts',
  templateUrl: './adverts.component.html',
  styleUrls: ['./adverts.component.css'],
  providers: [AdvertService]
})
export class AdvertsComponent implements OnInit {
  @Output() selectedDetailsAdvert = new EventEmitter<AdvertModel>();

  adverts: AdvertModel[];

  constructor(private advertService: AdvertService) {
  }

  ngOnInit() {
    this.adverts = this.advertService.getAdverts();
  }

  onAdvertSelected(advert: AdvertModel) {
    this.selectedDetailsAdvert.emit(advert);
  }
}
