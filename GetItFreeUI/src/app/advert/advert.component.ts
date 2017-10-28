import {Component, OnInit} from '@angular/core';
import {AdvertModel} from './advert.model';

@Component({
  selector: 'app-advert',
  templateUrl: './advert.component.html',
  styleUrls: ['./advert.component.css']
})
export class AdvertComponent implements OnInit {
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

  orderAdvert(advert: AdvertModel) {
    advert.ordered = true;
  }

}
