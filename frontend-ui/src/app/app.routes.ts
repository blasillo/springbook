import { Routes } from '@angular/router';

export const routes: Routes = [




  {
    path: 'books',
    loadChildren: () => import('./modules/book/book.module').then(m => m.BookModule)
  }


];
