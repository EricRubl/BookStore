import { Component, OnInit } from "@angular/core";
import { BooksService } from "../service/books.service";
import { Book } from "../types";
import { MatDialog, MAT_DIALOG_DATA } from "@angular/material";
import { BookModalComponent } from "./book-modal/book-modal.component";
import { Router } from "@angular/router";

@Component({
  selector: "app-books",
  templateUrl: "./books.component.html",
  styleUrls: ["./books.component.css"]
})
export class BooksComponent implements OnInit {
  books: Book[];
  displayedColumns = ["id", "title", "deleteColumn", "updateColumn"];

  constructor(
    public dialog: MatDialog,
    private service: BooksService,
    private router: Router
  ) {}

  ngOnInit() {
    this.loadData();
  }

  loadData() {
    this.service.getBooks().subscribe(resp => {
      this.books = resp.sort((b1: Book, b2: Book) => b1.id - b2.id);
    });
  }

  handleAdd() {
    const dialogRef = this.dialog.open(BookModalComponent, {
      width: "300px",
      data: JSON.parse(JSON.stringify({}))
    });

    dialogRef.afterClosed().subscribe((result: Book) => {
      if (result) {
        this.service.addBook(result).subscribe(_ => {
          this.loadData();
        });
      }
    });
  }

  handleDelete(id: number) {
    this.service.deleteBook(id).subscribe(_ => {
      this.loadData();
    });
  }

  handleUpdate(book: Book) {
    const dialogRef = this.dialog.open(BookModalComponent, {
      width: "300px",
      data: JSON.parse(JSON.stringify(book))
    });

    dialogRef.afterClosed().subscribe((result: Book) => {
      if (result && result.id) {
        this.service.updateBook(result).subscribe(_ => {
          this.loadData();
        });
      }
    });
  }
}
