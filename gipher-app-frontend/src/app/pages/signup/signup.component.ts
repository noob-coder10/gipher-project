import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent implements OnInit {
  constructor(
    private userService: UserService,
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

  public confirm_password: any;
  ngOnInit(): void {}

  formSubmit() {
    if (this.user.firstname == '') {
      this.snack.open('Firstname is required', 'dismiss', {
        duration: 3000,
      });
      return;
    }
    if (this.user.lastname == '') {
      this.snack.open('Lastname is required', 'dismiss', {
        duration: 3000,
      });
      return;
    }
    if (this.user.email == '') {
      this.snack.open('email is required', 'dismiss', {
        duration: 3000,
      });
      return;
    }
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (!this.user.email.match(mailformat)) {
      this.snack.open('Invalid email address', 'dismiss', {
        duration: 3000,
      });
      return;
    }
    if (this.user.password == '') {
      this.snack.open('Password is required', 'dismiss', {
        duration: 3000,
      });
      return;
    }
    if (this.user.password.length <5) {
      this.snack.open('Password length must be atleast 5 characters', 'dismiss', {
        duration: 3000,
      });
      return;
    }
    if (this.user.password != this.confirm_password) {
      this.snack.open('Passwords do not match', 'dismiss', {
        duration: 3000,
      });
      return;
    }
    if (this.user.phone == '') {
      this.snack.open('Phone number is required', 'dismiss', {
        duration: 3000,
      });
      return;
    }
    var phoneno = /^\d{10}$/;
    if (!this.user.phone.match(phoneno)) {
      this.snack.open('Invalid phone number', 'dismiss', {
        duration: 3000,
      });
      return;
    }
    this.userService.addUser(this.user).subscribe(
      (data: any) => {
        console.log(data);
        Swal.fire('Success', 'Registration Successful', 'success');
        this.router.navigate(['gif']);
      },
      (error) => {
        let errorMessage = error.error.message;
        this.snack.open(errorMessage, 'dismiss', {
          duration: 3000,
        });
      }
    );
  }
}
