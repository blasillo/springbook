/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { bookById } from '../fn/book-controller/book-by-id';
import { BookById$Params } from '../fn/book-controller/book-by-id';
import { BookResponse } from '../models/book-response';
import { findAllBook } from '../fn/book-controller/find-all-book';
import { FindAllBook$Params } from '../fn/book-controller/find-all-book';
import { PageResponseBookResponse } from '../models/page-response-book-response';
import { saveBook } from '../fn/book-controller/save-book';
import { SaveBook$Params } from '../fn/book-controller/save-book';

@Injectable({ providedIn: 'root' })
export class BookControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `findAllBook()` */
  static readonly FindAllBookPath = '/books';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAllBook()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllBook$Response(params?: FindAllBook$Params, context?: HttpContext): Observable<StrictHttpResponse<PageResponseBookResponse>> {
    return findAllBook(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAllBook$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllBook(params?: FindAllBook$Params, context?: HttpContext): Observable<PageResponseBookResponse> {
    return this.findAllBook$Response(params, context).pipe(
      map((r: StrictHttpResponse<PageResponseBookResponse>): PageResponseBookResponse => r.body)
    );
  }

  /** Path part for operation `saveBook()` */
  static readonly SaveBookPath = '/books';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `saveBook()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  saveBook$Response(params: SaveBook$Params, context?: HttpContext): Observable<StrictHttpResponse<number>> {
    return saveBook(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `saveBook$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  saveBook(params: SaveBook$Params, context?: HttpContext): Observable<number> {
    return this.saveBook$Response(params, context).pipe(
      map((r: StrictHttpResponse<number>): number => r.body)
    );
  }

  /** Path part for operation `bookById()` */
  static readonly BookByIdPath = '/books/{book_id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `bookById()` instead.
   *
   * This method doesn't expect any request body.
   */
  bookById$Response(params: BookById$Params, context?: HttpContext): Observable<StrictHttpResponse<BookResponse>> {
    return bookById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `bookById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  bookById(params: BookById$Params, context?: HttpContext): Observable<BookResponse> {
    return this.bookById$Response(params, context).pipe(
      map((r: StrictHttpResponse<BookResponse>): BookResponse => r.body)
    );
  }

}
