import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css'],
})
export class ChangePasswordComponent implements OnInit {
  constructor(
    private login: LoginService,
    public userService: UserService,
    private snack: MatSnackBar,
    private router: Router
  ) {}

  public user = {
    password: '',
    firstname: '',
    lastname: '',
    email: '',
    phone: '',
  };
  public data = {
    newPassword: '',
    confirmPassword: '',
  };
  ngOnInit(): void {
    this.user = this.login.getUser();
  }

  formSubmit() {
    if (this.data.newPassword == '' || this.data.newPassword == null) {
      this.snack.open('Password cannot be empty', '', {
        duration: 3000,
      });
      return;
    }
    if (this.data.newPassword.length <5) {
      this.snack.open('Password length must be atleast 5 characters', 'dismiss', {
        duration: 3000,
      });
      return;
    }
    if (this.data.newPassword != this.data.confirmPassword) {
      this.snack.open('Passwords do not match', '', {
        duration: 3000,
      });
      return;
    }
    this.user.password = this.data.newPassword;
    this.userService.updatePassword(this.user).subscribe(
      (data: any) => {
        localStorage.setItem('user', JSON.stringify(this.user));
        Swal.fire('Success', 'Password Changed', 'success');
        this.router.navigate(['gif']);
      },
      (error) => {
        this.snack.open('Something went wrong', 'dismiss', {
          duration: 3000,
        });
      }
    );
  }
}
