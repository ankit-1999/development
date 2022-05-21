import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class HomepageService {
  constructor(private http: HttpClient) {}

  getProducts() {
    return this.http.get('http://localhost:9000/Products');
  }

  getproducts(data: any) {
    return this.http.get('http://localhost:9000/Products/' + data);
  }
}
