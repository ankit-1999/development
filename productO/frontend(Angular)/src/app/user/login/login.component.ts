import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  constructor(
    private router: Router,
    private toastr: ToastrService,
    private userService: UserService
  ) {
    if (sessionStorage.getItem('userName') != null) {
      this.toastr.info('you are already logged in!');
      this.router.navigateByUrl('/home');
    }
  }

  user: any;

  validate(data: any) {
    if (data.email == '' || data.password == '') {
      return false;
    }
    return true;
  }

  getData(data: any) {
    if (this.validate(data) == false) {
      this.toastr.warning('please fill all input fields');
      return;
    }
    this.userService.getUser(data.email)?.subscribe(
      (result) => {
        this.user = result;
        if (this.user.password == data.password) {
          this.toastr.success(
            'Welcome  ' + this.user.firstName + ' ' + this.user.lastName
          );
          sessionStorage.setItem(
            'userName',
            this.user.firstName + ' ' + this.user.lastName
          );
          this.router.navigateByUrl('/product/productSearch');
        } else {
          this.toastr.error('invalid username or password');
        }
      },
      (error) => {
        if (error.status != 200) {
          this.router.navigateByUrl('/internalServerError');
        }
      }
    );
    //console.warn(data);
  }

  ngOnInit(): void {}
}
