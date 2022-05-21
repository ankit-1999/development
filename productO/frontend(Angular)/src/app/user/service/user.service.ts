import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient, private router: Router) {}

  getUser(id: string) {
    return this.http.get('http://localhost:9000/User/' + id);
  }

  saveUser(data: any) {
    return this.http.post('http://localhost:9000/User', data);
  }
}
