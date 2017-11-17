import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AdvertModel} from './advert.model';

@Component({
  selector: 'app-advert',
  templateUrl: './advert.component.html',
  styleUrls: ['./advert.component.css']
})
export class AdvertComponent implements OnInit {
  @Input() advert: AdvertModel;
  @Output() advertSelector = new EventEmitter<AdvertModel>();

  constructor() { }

  ngOnInit() {
  }

  orderAdvert(advert: AdvertModel) {
    this.advert.ordered = true;
  }

  onSelected(advert: AdvertModel) {
    this.advertSelector.emit(advert);
  }
}
