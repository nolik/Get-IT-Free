import {Component, Input, OnInit} frombehaviourar/core';
import {AdvertModel} from '../advert/advert.model';
import {AdvertService} from '../advert.service';
import {ActivatedRoute, Params} from '@angular/router';

@Component({
  selector: 'app-advert-detail',
  templateUrl: './advert-detail.component.html',
  styleUrls: ['./advert-detail.component.css']
})
export class AdvertDetailComponent implements OnInit {
  detailAdvert: AdvertModel;

  constructor(private advertService: AdvertService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    const id = +this.route.snapshot.params['id'];
    this.detailAdvert = this.advertService.getAdvert(+id);
    this.route.params
      .subscribe(
        (params: Params) => {
          this.detailAdvert = this.advertService.getAdvert(+params['id']);
        }
      );
  }

}
