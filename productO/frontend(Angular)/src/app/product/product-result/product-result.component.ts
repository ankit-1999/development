import { Component, OnInit } from '@angular/core';
import { ProductService } from '../service/product.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-product-result',
  templateUrl: './product-result.component.html',
  styleUrls: ['./product-result.component.css'],
})
export class ProductResultComponent implements OnInit {
  logedIn!: boolean;
  products: any;
  tmpProducts: any;
  noProduct!: boolean;
  brand: any;
  displayFilter!: boolean;

  constructor(
    private productService: ProductService,
    private toastr: ToastrService
  ) {
    if (sessionStorage.getItem('userName') != null) {
      this.logedIn = false;
      this.displayFilter = true;
    } else {
      this.logedIn = true;
      this.displayFilter = false;
    }
    this.products = this.productService.products;
    this.tmpProducts = this.productService.products;
    if (this.tmpProducts.length == 0) {
      this.noProduct = true;
    } else {
      this.noProduct = false;
      let mySet = new Set();
      for (let i = 0; i < this.products.length; i++) {
        mySet.add(this.products[i].productBrand);
      }
      this.brand = mySet;
    }
  }

  getValue(min: any, max: any) {
    if (min == '' && max == '') {
      this.toastr.warning(
        'Please select atleast one input price field i.e min Price or max Price'
      );
    } else {
      if (min == '') {
        min = 0;
      }
      if (max == '') {
        max = 999999999;
      }
      let mySet = new Set();
      for (let i = 0; i < this.tmpProducts.length; i++) {
        if (
          this.tmpProducts[i].productPrice > min &&
          this.tmpProducts[i].productPrice < max
        ) {
          mySet.add(this.tmpProducts[i]);
        }
      }
      this.products = mySet;
      if (this.products.length == 0) {
        this.noProduct = true;
      }
    }
  }

  filterByBrand(e: any) {
    if (e.target.value == 'Brand') {
      return;
    } else if (e.target.value == '--none--') {
      this.products = this.tmpProducts;
    } else {
      let mySet = new Set();
      for (let i = 0; i < this.tmpProducts.length; i++) {
        if (this.tmpProducts[i].productBrand == e.target.value) {
          mySet.add(this.tmpProducts[i]);
        }
      }
      this.products = mySet;
    }
  }

  ngOnInit(): void {}
}
