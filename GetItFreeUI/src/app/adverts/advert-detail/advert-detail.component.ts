import {Component, Input, OnInit} from '@angular/core';
import {AdvertModel} from '../advert/advert.model';

@Component({
  selector: 'app-advert-detail',
  templateUrl: './advert-detail.component.html',
  styleUrls: ['./advert-detail.component.css']
})
export class AdvertDetailComponent implements OnInit {
  @Input() advertDetails: AdvertModel;

  constructor() { }

  ngOnInit() {
  }

}
