import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  userName = sessionStorage.getItem('userName');
  show!: Boolean;

  constructor(private router: Router) {
    if (sessionStorage.getItem('userName') == null) {
      this.show = false;
    } else {
      this.show = true;
    }
  }

  logout() {
    console.log(this.userName);
    sessionStorage.removeItem('userName');
    this.userName = '';
    this.router.navigateByUrl('/home');
  }

  ngOnInit(): void {}
}
