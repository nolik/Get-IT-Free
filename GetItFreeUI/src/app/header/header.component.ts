import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {DataStorageService} from '../shared/data-storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  @Output() futureSelected = new EventEmitter<string>();

  title = 'Get It Free portal';

  constructor(private dataService: DataStorageService) {
  }

  ngOnInit() {
  }

  onSelect(feature: string) {
    this.futureSelected.emit(feature);
  }

  getLastAdverts() {
    this.dataService.getAdverts();
  }
}
