import {AdvertModel} from './advert/advert.model';

export class AdvertService {
  private adverts: AdvertModel[] = [
    new AdvertModel(1, 'test header', 'test content', new Date, 'https://thumb9.shutterstock.com/display_pic_with_logo/3521228/391005625/' +
      'stock-photo-glasses-of-light-and-dark-beer-on-a-pub-background-391005625.jpg', false),
    new AdvertModel(2, 'test header2', 'test content', new Date, 'https://thumb9.shutterstock.com/display_pic_with_logo/3521228/391005625/' +
      'stock-photo-glasses-of-light-and-dark-beer-on-a-pub-background-391005625.jpg', false),
    new AdvertModel(3, 'test header3', 'test content', new Date, 'https://thumb9.shutterstock.com/display_pic_with_logo/3521228/391005625/' +
      'stock-photo-glasses-of-light-and-dark-beer-on-a-pub-background-391005625.jpg', false),
    new AdvertModel(4, 'test header4', 'test content', new Date, 'https://thumb9.shutterstock.com/display_pic_with_logo/3521228/391005625/' +
      'stock-photo-glasses-of-light-and-dark-beer-on-a-pub-background-391005625.jpg', false),
    new AdvertModel(5, 'test header5', 'test content', new Date, 'https://thumb9.shutterstock.com/display_pic_with_logo/3521228/391005625/' +
      'stock-photo-glasses-of-light-and-dark-beer-on-a-pub-background-391005625.jpg', false)
  ];

  getAdverts() {
    return this.adverts.slice();
  }
}
