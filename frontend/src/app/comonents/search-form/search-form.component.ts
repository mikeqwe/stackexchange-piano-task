import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-search-form',
  templateUrl: './search-form.component.html',
  styleUrls: ['./search-form.component.css']
})
export class SearchFormComponent implements OnInit {

  @Output() searchQuery: EventEmitter<string> = new EventEmitter<string>();

  constructor() {
  }

  search(val: string) {
    this.searchQuery.emit(val);
  }

  ngOnInit() {
  }

}
