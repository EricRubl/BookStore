import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/types';
import { Router } from '@angular/router';
import { BooksService } from 'src/app/service/books.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {
  book: Book

  constructor(private service: BooksService, private router: Router) { }

  ngOnInit() {
    this.book = new Book();
  }

  handleSave() {
    if (!this.book.title) {
      return;
    }
    this.service.addBook(this.book).subscribe(res => {
      this.router.navigate(['/books']);
    })
  }

  handleCancel() {
    this.router.navigate(['/books']);
  }
}
