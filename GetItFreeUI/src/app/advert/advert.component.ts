import { Component } from '@angular/core';

@Component({
  selector: 'app-advert',
  templateUrl: './advert.component.html'
})

export class AdvertComponent {
   id = 1;
   head = 'header of advert';
   content = 'content of advert';
   date: object = new Date();
   imageUrl = 'https://thumb9.shutterstock.com/display_pic_with_logo/3521228/391005625/stock-photo-glasses-of-light-and-dark-beer-on-a-pub-background-391005625.jpg';
}
