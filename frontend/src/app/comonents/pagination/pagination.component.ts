import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Page} from '../../entity/page';

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.css']
})
export class PaginationComponent implements OnInit {

  @Input() page: Page<any>;

  @Output() selectedPage: EventEmitter<number> = new EventEmitter<number>();

  constructor() {
  }

  ngOnInit() {
  }

  select(page: number) {
    this.selectedPage.emit(page);
  }
}
