import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Book } from 'src/app/types';

@Component({
  selector: 'app-book-modal',
  templateUrl: './book-modal.component.html',
  styleUrls: ['./book-modal.component.css']
})
export class BookModalComponent implements OnInit {

  modalName: string;
  okButtonName: string;

  constructor(public dialogRef: MatDialogRef<BookModalComponent>, @Inject(MAT_DIALOG_DATA) public book: Book) { }

  ngOnInit() {
    this.modalName = this.book.id ? 'Edit book' : 'Add book'; 
    this.okButtonName = 'Save';
  }

  onCancelClick() : void {
    this.dialogRef.close();
  }
}
