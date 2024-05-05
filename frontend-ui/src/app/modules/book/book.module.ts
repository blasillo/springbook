import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule} from "@angular/forms";

import { BookRoutingModule } from './book-routing.module';
import { MainComponent } from './pages/main/main.component';
import { MenuComponent } from './components/menu/menu.component';
import {BookListComponent} from "./components/book-list/book-list.component";


@NgModule({
  declarations: [
    MainComponent,
    MenuComponent,
    BookListComponent
  ],
  imports: [
    CommonModule,
    BookRoutingModule,
    FormsModule
  ]
})
export class BookModule { }
