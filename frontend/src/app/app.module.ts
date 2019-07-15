import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { SearchFormComponent } from './comonents/search-form/search-form.component';
import { QuestionCardComponent } from './comonents/question-card/question-card.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {QuestionService} from './service/question.service';
import { QuestionsViewComponent } from './comonents/questions-view/questions-view.component';
import { PaginationComponent } from './comonents/pagination/pagination.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchFormComponent,
    QuestionCardComponent,
    QuestionsViewComponent,
    PaginationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    CommonModule
  ],
  providers: [QuestionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
