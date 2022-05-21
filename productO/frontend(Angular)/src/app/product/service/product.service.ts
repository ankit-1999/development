import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  products: any; // to store products

  constructor(private http: HttpClient, private router: Router) {}

  getProduct(id: any) {
    return this.http.get('http://localhost:9000/Product/' + id);
  }

  getProducts(data: any) {
    return this.http.post('http://localhost:9000/searchProduct', data);
  }

  getPinCode(id: any) {
    return this.http.get('http://localhost:9000/getPinCode/' + id);
  }
}
