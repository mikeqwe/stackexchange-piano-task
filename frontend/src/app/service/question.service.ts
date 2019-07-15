import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams, HttpUrlEncodingCodec} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Page} from '../entity/page';
import {Question} from '../entity/question';
import {environment} from '../../environments/environment';

@Injectable()
export class QuestionService {

  constructor(private httpClient: HttpClient) {
  }


  public getPage(intitle: string, page: number, pageSize: number): Observable<any> {

    const url = environment.questionsUrl;

    const params: HttpParams = new HttpParams({encoder: new CustomQueryEncoderHelper()})
      .set('page', page.toString())
      .set('size', pageSize.toString())
      .set('intitle', intitle);

    const headers: HttpHeaders = new HttpHeaders()
      .append('Content-Type', 'application/x-www-form-urlencoded');


    const options = {
      params,
      headers
    };

    return this.httpClient.get<Page<Question>>(url, options).pipe();

  }
}

class CustomQueryEncoderHelper extends HttpUrlEncodingCodec {
  encodeKey(k: string): string {
    k = super.encodeKey(k);
    return k.replace(/\+/gi, '%2B');
  }

  encodeValue(v: string): string {
    v = super.encodeValue(v);
    return v.replace(/\+/gi, '%2B');
  }
}
