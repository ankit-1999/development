import { Component, OnInit } from '@angular/core';
import { HomepageService } from '../homepage/service/homepage.service';
import { ToastrService } from 'ngx-toastr';
import { ProductService } from '../product/service/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css'],
})
export class HomepageComponent implements OnInit {
  products: any;
  login!: boolean;

  constructor(
    private homepageService: HomepageService,
    private toastr: ToastrService,
    private productService: ProductService,
    private router: Router
  ) {
    if(sessionStorage.getItem('userName')!=null){
      this.login = true;
    }
    else{
      this.login = false;
    }
    homepageService.getProducts().subscribe(
      (data) => {
        this.products = data;
      },
      (error) => {
        if (error.status != 200) {
          this.router.navigateByUrl('/internalServerError');
        }
      }
    );
  }


  logOut(){
    
    sessionStorage.removeItem("userName");
    this.login=false;
    
  }

  getValue(data: any) {
    if (data == '') {
      this.toastr.warning('please fill input field ');
    } else {
      this.homepageService.getproducts(data).subscribe(
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
    }
  }

 

  ngOnInit(): void {}
}
