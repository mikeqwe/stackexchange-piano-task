import {Component, OnInit} from '@angular/core';
import {QuestionService} from '../../service/question.service';
import {Question} from '../../entity/question';
import {Page} from '../../entity/page';

@Component({
  selector: 'app-questions-view',
  templateUrl: './questions-view.component.html',
  styleUrls: ['./questions-view.component.css']
})
export class QuestionsViewComponent implements OnInit {

  pageNumber: number;
  pageSize: number;
  searchQuery: string;
  questions: Page<Question>;

  constructor(private questionService: QuestionService) {
    this.pageNumber = 0;
    this.pageSize = 10;
  }

  ngOnInit(): void {
  }

  search(searchQuery: string) {
    this.clear();
    this.questionService.getPage(searchQuery, this.pageNumber, this.pageSize)
      .subscribe((data: Page<Question>) => {
        this.questions = data;
        this.searchQuery = searchQuery;
      });
  }

  toPage(pageNumber: number) {
    this.questionService.getPage(this.searchQuery, pageNumber, this.pageSize)
      .subscribe((data: Page<Question>) => {
        this.questions = data;
        this.pageNumber = pageNumber;
      });
  }

  private clear() {
    this.pageNumber = 0;
    this.pageSize = 10;
    this.questions = null;
  }
}
