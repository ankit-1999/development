import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomepageComponent } from './homepage/homepage.component';
import { PageNotFoundComponent } from './error/page-not-found/page-not-found.component';
import { InternalServerErrorComponent } from './error/internal-server-error/internal-server-error.component';

const routes: Routes = [
  { path: 'home', component: HomepageComponent },
  {
    path: 'user',
    loadChildren: () =>
      import('./user/user.module').then((mod) => mod.UserModule),
  },
  {
    path: 'product',
    loadChildren: () =>
      import('./product/product.module').then((mod) => mod.ProductModule),
  },
  { path: 'internalServerError', component: InternalServerErrorComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
