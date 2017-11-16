import {Component, Input, OnInit} from '@angular/core';
import {AdvertModel} from './advert.model';

@Component({
  selector: 'app-advert',
  templateUrl: './advert.component.html',
  styleUrls: ['./advert.component.css']
})
export class AdvertComponent implements OnInit {
  @Input() advert: AdvertModel;

  constructor() { }

  ngOnInit() {
  }

  orderAdvert(advert: AdvertModel) {
    this.advert.ordered = true;
  }
}
