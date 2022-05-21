import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-product-search',
  templateUrl: './product-search.component.html',
  styleUrls: ['./product-search.component.css'],
})
export class ProductSearchComponent implements OnInit {
  constructor(
    private router: Router,
    private toastr: ToastrService,
    private productService: ProductService
  ) {}

  validate(data: any) {
    if (
      data.productId == '' &&
      data.productName == '' &&
      data.productBrand == ''
    ) {
      if (data.minPrice == '' && data.maxPrice == '') {
        this.toastr.warning('please fill atleast one input fields');
        return false;
      } else if (
        (data.minPrice == null && data.maxPrice == null) ||
        (data.minPrice == null && data.maxPrice == '') ||
        (data.minPrice == '' && data.maxPrice == null)
      ) {
        this.toastr.warning('please fill atleast one input fields');
        return false;
      }
    }

    return true;
  }

  getData(data: any) {
    console.log(data);
    if (this.validate(data) == true) {
      this.productService.getProducts(data).subscribe(
        (result) => {
          this.productService.products = result;
          this.router.navigateByUrl('/product/productResult');
        },
        (error) => {
          if (error.status != 200) {
            this.router.navigateByUrl('/internalServerError');
          }
        }
      );

      return;
    }
  }

  ngOnInit(): void {}
}
