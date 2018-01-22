import {Injectable} from '@angular/core';
import {Http, RequestOptions, Response} from '@angular/http';
import {AdvertService} from '../adverts/advert.service';
import {AdvertModel} from '../adverts/advert/advert.model';
import {Headers} from '@angular/http';

@Injectable()
export class DataStorageService {

  headers: Headers = new Headers({'Content-Type': 'application/json'});
  options: RequestOptions = new RequestOptions({headers: this.headers});

  constructor(private http: Http, private advertService: AdvertService) {
  }

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

  // addAdvert(newAdvert: AdvertModel) {
  //   console.log(newAdvert);
  //   this.http.post('http://localhost:8090/add-advert', JSON.stringify(newAdvert))
  //     .subscribe(
  //       (response: Response) => {
  //         console.log(response);
  //       }
  //     );
  // }

  addNewAdvert(newAdvert: AdvertModel) {
    return this.http.post('http://localhost:8090/add-advert', newAdvert, this.options)
      .subscribe(
        ((response: Response) => console.log(response))
      );
  }
}
