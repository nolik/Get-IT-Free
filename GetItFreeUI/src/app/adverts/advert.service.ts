import {AdvertModel} from './advert/advert.model';
import {Injectable} from '@angular/core';
import {Subject} from 'rxjs/Subject';
import {DataStorageService} from '../shared/data-storage.service';

@Injectable()
export class AdvertService {
  advertsChanged = new Subject<AdvertModel[]>();

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

  setAdverts(adverts: AdvertModel[]) {
  //   this.adverts = adverts;
  //   this.advertsChanged.next(this.adverts.slice());
  //   console.log(adverts);
  }

  getAdverts() {
    // this.dataStorageService.getAdverts();
    return this.adverts.slice();
  }

  getAdvert(id: number) {
    return this.adverts.find(
      (a) => {
        return a.id === id;
      }
    );
  }

  addAdvert(newAdvert: AdvertModel) {
    this.adverts.push(newAdvert);
    this.advertsChanged.next(this.adverts.slice());
  }
}
