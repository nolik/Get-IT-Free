import {Injectable} from '@angular/core';
import {AdvertModel} from '../adverts/advert/advert.model';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {catchError, tap} from 'rxjs/operators';
import {of} from 'rxjs/observable/of';
import {ConfigService} from './config.service';

@Injectable()
export class DataStorageService {

  // headers: Headers = new Headers({'Content-Type': 'application/json'});
  // options: RequestOptions = new RequestOptions({headers: this.headers});

  constructor(private http: HttpClient,
              private config: ConfigService) {
  }

  getAdverts(): Observable<AdvertModel[]> {
    console.log('call DataStorageService');
    return this.http.get<AdvertModel[]>(this.config.adverts_url)
      .pipe(
        tap(adverts => console.log(`dataService-getAdverts` + adverts)),
        catchError(this.handleError('getAdverts', []))
      );
    // .subscribe(
    //   (response: Response) => {
    //     const adverts: AdvertModel[] = response.json();
    //     console.log(adverts);
    //     this.advertService.setAdverts(adverts);
    //   }
    // );
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
    return this.http.post(this.config.add_advert_url, newAdvert);
    // .subscribe(
    //   ((response: Response) => console.log(response))
    // );
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
