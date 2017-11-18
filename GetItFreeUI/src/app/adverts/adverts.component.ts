import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {AdvertModel} from './advert/advert.model';

@Component({
  selector: 'app-adverts',
  templateUrl: './adverts.component.html',
  styleUrls: ['./adverts.component.css']
})
export class AdvertsComponent implements OnInit {
  @Output() selectedDetailsAdvert = new EventEmitter<AdvertModel>();

  adverts: AdvertModel[] = [
    new AdvertModel(1, 'test header', 'test content', new Date, 'https://thumb9.shutterstock.com/display_pic_with_logo/3521228/391005625/' +
      'stock-photo-glasses-of-light-and-dark-beer-on-a-pub-background-391005625.jpg', false),
    new AdvertModel(1, 'test header', 'test content', new Date, 'https://thumb9.shutterstock.com/display_pic_with_logo/3521228/391005625/' +
      'stock-photo-glasses-of-light-and-dark-beer-on-a-pub-background-391005625.jpg', false),
    new AdvertModel(1, 'test header', 'test content', new Date, 'https://thumb9.shutterstock.com/display_pic_with_logo/3521228/391005625/' +
      'stock-photo-glasses-of-light-and-dark-beer-on-a-pub-background-391005625.jpg', false),
    new AdvertModel(1, 'test header', 'test content', new Date, 'https://thumb9.shutterstock.com/display_pic_with_logo/3521228/391005625/' +
      'stock-photo-glasses-of-light-and-dark-beer-on-a-pub-background-391005625.jpg', false),
    new AdvertModel(1, 'test header', 'test content', new Date, 'https://thumb9.shutterstock.com/display_pic_with_logo/3521228/391005625/' +
      'stock-photo-glasses-of-light-and-dark-beer-on-a-pub-background-391005625.jpg', false)
  ];

  constructor() {
  }

  ngOnInit() {
  }

  onAdvertSelected(advert: AdvertModel) {
    this.selectedDetailsAdvert.emit(advert);
  }
}
