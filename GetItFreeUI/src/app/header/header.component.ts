import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  @Output() futureSelected = new EventEmitter<string>();

  title = 'Get It Free portal';

  constructor() {
  }

  ngOnInit() {
  }

  onSelect(feature: string) {
    this.futureSelected.emit(feature);
  }
}
