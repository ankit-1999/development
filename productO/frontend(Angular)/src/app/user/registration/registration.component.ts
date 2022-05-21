import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})
export class RegistrationComponent implements OnInit {
  // regular expresion to validate email
  validRegex =
    /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

  constructor(
    private router: Router,
    private toastr: ToastrService,
    private userService: UserService
  ) {
    if (sessionStorage.getItem('userName') != null) {
      this.toastr.info('please logout first!');
      this.router.navigateByUrl('/home');
    }
  }

  validate(data: any) {
    if (
      data.email == '' ||
      data.password == '' ||
      data.firstName == '' ||
      data.lastName == '' ||
      data.confirmPassword == ''
    ) {
      this.toastr.warning('please fill all input fields');
      return false;
    } else if (!data.email.match(this.validRegex)) {
      this.toastr.warning('invalid email!');
      return false;
    } else if (data.password.length < 4) {
      this.toastr.warning('length of password must be atleast 4 characters');
      return false;
    } else if (data.password != data.confirmPassword) {
      this.toastr.error('password and confirm password are not same');
      return false;
    } else if (this.validEmail == false) {
      this.toastr.error('email already exist please use some other email');
      return false;
    }
    return true;
  }

  validEmail: boolean = true;

  validateEmail(data: any): boolean {
    this.userService.getUser(data).subscribe((result) => {
      let tmp: any = result;
      if (data == tmp.email) {
        this.toastr.error('email already exist please use some other email');
        this.validEmail = false;
      }
    });
    this.validEmail = true;
    return true;
  }

  getData(data: any) {
    if (this.validate(data) == true) {
      this.userService.saveUser(data).subscribe(
        (result) => {
          this.toastr.success('Welcome to ProDuctO');
          this.toastr.info('Please Login to Explore our Products');
          this.router.navigateByUrl('/user/login');
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
