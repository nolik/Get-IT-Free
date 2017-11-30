import {Component, Input, OnInit} from '@angular/core';
import {AdvertModel} from '../advert/advert.model';
import {AdvertService} from '../advert.service';

@Component({
  selector: 'app-advert-detail',
  templateUrl: './advert-detail.component.html',
  styleUrls: ['./advert-detail.component.css']
})
export class AdvertDetailComponent implements OnInit {
  advertDetails: AdvertModel;

  constructor(private advertService: AdvertService) {
  }

  ngOnInit() {
    this.advertDetails = this.advertService.selectedAdvert;
  }

}
