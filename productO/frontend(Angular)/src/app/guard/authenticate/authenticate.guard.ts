import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthenticateGuard implements CanActivate {
  constructor(private router: Router) {}
  canActivate(): boolean {
    if (sessionStorage.getItem('userName') == null) {
      this.router.navigate(['/user/login']);
      return false;
    }
    return true;
  }
}
