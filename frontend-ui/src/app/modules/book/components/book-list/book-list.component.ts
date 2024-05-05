import {Component, OnInit, Input } from '@angular/core';
import {Router} from "@angular/router";

// @ts-ignore
import {BookService} from '../../../../services/services/book-controller.service';
import {PageResponseBookResponse} from "../../../../services/models/page-response-book-response";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})

export class BookListComponent  {
  page = 0;
  size = 5;
  pages: any = [];
  message = '';
  level: 'success' |'error' = 'success';
  bookResponse: PageResponseBookResponse = {};


  constructor(
    private  bookService: BookService,
    private router: Router
  ) {  }

  ngOnInit(): void {
    this.findAllBooks();
  }

  private findAllBooks() {
    this.bookService.findAllBook ({
      page: this.page,
      size: this.size
    }).subscribe({
      next: (books: PageResponseBookResponse) => {
        this.bookResponse = books;
        this.pages = Array(this.bookResponse.totalPages)
          .fill(0)
          .map((x, i) => i);
      }
    });
  }
}
