import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ProductDetailComponent } from './product-detail/product-detail.component';
import { ProductResultComponent } from './product-result/product-result.component';
import { ProductSearchComponent } from './product-search/product-search.component';
import { AuthenticateGuard } from '../guard/authenticate/authenticate.guard';

const routes: Routes = [
  {
    path: 'productDetail/:id',
    component: ProductDetailComponent,
    canActivate: [AuthenticateGuard],
  },
  {
    path: 'productSearch',
    component: ProductSearchComponent,
    canActivate: [AuthenticateGuard],
  },
  { path: 'productResult', component: ProductResultComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProductRoutingModule {}
