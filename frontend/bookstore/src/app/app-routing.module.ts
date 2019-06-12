import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { BooksComponent } from "./books/books.component";
import { HomeComponent } from "./home/home.component";
import { ClientsComponent } from "./clients/clients.component";

const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "books", component: BooksComponent },
  { path: "clients", component: ClientsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
