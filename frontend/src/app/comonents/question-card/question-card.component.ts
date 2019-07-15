import {Component, Input, OnInit} from '@angular/core';
import {Question} from '../../entity/question';
import * as moment from 'moment';

@Component({
  selector: 'app-question-card',
  templateUrl: './question-card.component.html',
  styleUrls: ['./question-card.component.css']
})
export class QuestionCardComponent implements OnInit {

  @Input() question: Question;

  constructor() {
  }

  ngOnInit() {
  }

  beautifyDate(date: Date): string {
    return moment(date).fromNow();
  }
}
