import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule, MatCheckboxModule, MatToolbarModule, MatSidenavModule, MatIconModule, MatListModule, MatTableModule, MatDialogModule, MatInputModule } from '@angular/material';
import { NavComponent } from './nav/nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { BooksComponent } from './books/books.component';
import { ClientsComponent } from './clients/clients.component';
import { HomeComponent } from './home/home.component';
import { BooksService } from './service/books.service';
import { HttpClientModule } from '@angular/common/http';
import { ClientsService } from './service/clients.service';
import { BookModalComponent } from './books/book-modal/book-modal.component';
import { FormsModule } from '@angular/forms';
import { AddBookComponent } from './books/add-book/add-book.component';
import { EditBookComponent } from './edit-book/edit-book.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    BooksComponent,
    ClientsComponent,
    HomeComponent,
    BookModalComponent,
    AddBookComponent,
    EditBookComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    BrowserAnimationsModule,
    FormsModule,
    MatButtonModule, 
    HttpClientModule,
    MatCheckboxModule, LayoutModule, MatToolbarModule, MatSidenavModule, MatIconModule, MatListModule, MatTableModule, MatDialogModule, MatInputModule
  ],
  providers: [BooksService, ClientsService],
  bootstrap: [AppComponent],
  entryComponents: [BookModalComponent]
})
export class AppModule { }
