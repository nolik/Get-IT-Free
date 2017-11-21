import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {AdvertModel} from './advert/advert.model';
import {AdvertService} from './advert.service';

@Component({
  selector: 'app-adverts',
  templateUrl: './advert-list.component.html',
  styleUrls: ['./advert-list.component.css']
})
export class AdvertListComponent implements OnInit {

  adverts: AdvertModel[];

  constructor(private advertService: AdvertService) {
  }

  ngOnInit() {
    this.adverts = this.advertService.getAdverts();
  }

}
