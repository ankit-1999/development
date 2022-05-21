import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { ProductSearchComponent } from './product-search/product-search.component';
import { ProductResultComponent } from './product-result/product-result.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { HeaderComponent } from './header/header.component';
import { ProductRoutingModule } from './product-routing.module';

@NgModule({
  declarations: [
    ProductSearchComponent,
    ProductResultComponent,
    ProductDetailComponent,
    HeaderComponent,
  ],
  imports: [CommonModule, RouterModule, FormsModule, ProductRoutingModule],
})
export class ProductModule {}
