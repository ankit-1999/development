import { Component, OnInit } from '@angular/core';
import { ProductService } from '../service/product.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css'],
})
export class ProductDetailComponent implements OnInit {
  productCode: any;

  image: any;
  pinCodes: any;
  product: any;

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router,
    private toastr: ToastrService
  ) {
    if (sessionStorage.getItem('userName') == null) {
      this.router.navigateByUrl('/user/login');
      this.toastr.warning('Please login first');
    }
  }
  check(pinCode: any) {
    if (pinCode.length == 6) {
      for (let i = 0; i < this.pinCodes.length; i++) {
        if (this.pinCodes[i].pinCode == pinCode) {
          this.toastr.success(
            'delivery of product is available at your pin code!'
          );
          return;
        }
      }
      this.toastr.warning('Sorry product is not available at your pin code!');
    } else {
      this.toastr.error('invalid pin code!');
    }
  }

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.productCode = params['id'];
      this.productService.getProduct(params['id']).subscribe(
        (result) => {
          this.product = result;
        },
        (error) => {
          if (error.status != 200) {
            this.router.navigateByUrl('/internalServerError');
          }
        }
      );
    });

    this.productService.getPinCode(this.productCode).subscribe((result) => {
      this.pinCodes = result;
    });
  }
}
