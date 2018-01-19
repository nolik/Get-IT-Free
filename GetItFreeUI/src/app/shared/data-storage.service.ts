import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import {AdvertService} from '../adverts/advert.service';
import {AdvertModel} from '../adverts/advert/advert.model';

@Injectable()
export class DataStorageService {
  constructor(private http: Http, private advertService: AdvertService) {}

  getAdverts() {
    this.http.get('http://localhost:8090/adverts')
      .subscribe(
        (response: Response) => {
          const adverts: AdvertModel[] = response.json();
          console.log(adverts);
          this.advertService.setAdverts(adverts);
        }
      );
  }
}
