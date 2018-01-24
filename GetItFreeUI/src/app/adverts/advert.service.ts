import {AdvertModel} from './advert/advert.model';
import {Injectable} from '@angular/core';
import {Subject} from 'rxjs/Subject';

@Injectable()
export class AdvertService {
  advertsChanged = new Subject<AdvertModel[]>();

  private adverts: AdvertModel[] = [];

  setAdverts(adverts: AdvertModel[]) {
    this.adverts = adverts;
    this.advertsChanged.next(this.adverts.slice());
  }

  getAdverts() {
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
