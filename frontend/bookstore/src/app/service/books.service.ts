import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../types';
import { BookURL } from '../urls';

@Injectable()
export class BooksService {

  constructor(private httpClient: HttpClient) {}

  getBooks() : Observable<Book[]> {
    return this.httpClient.get<Array<Book> > (BookURL.get);
  }

  addBook(book: Book) : Observable<Book> {
    return this.httpClient.post<Book> (BookURL.post, book);
  }

  deleteBook(id: number) : Observable<Book> {
    return this.httpClient.delete<Book> (BookURL.delete + `/${id}`);
  }

  updateBook(book: Book) : Observable<Book> {
    return this.httpClient.put<Book> (BookURL.put  + `/${book.id}`, book);
  }
}
