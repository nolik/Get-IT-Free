import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AdvertModel} from './advert.model';
import {AdvertService} from '../advert.service';

@Component({
  selector: 'app-advert',
  templateUrl: './advert.component.html',
  styleUrls: ['./advert.component.css']
})
export class AdvertComponent implements OnInit {
  @Input() advert: AdvertModel;

  constructor(private advertService: AdvertService) { }

  ngOnInit() {
  }

  orderAdvert() {
    this.advert.ordered = true;
  }

  onSelected() {
    this.advertService.advertSelected.emit(this.advert);
  }
}
