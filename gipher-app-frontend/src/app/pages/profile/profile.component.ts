import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
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
  public user1 = {
    password: '',
    firstname: '',
    lastname: '',
    email: '',
    phone: '',
  };
  ngOnInit(): void {
    this.user = this.login.getUser();
    this.user1 = this.login.getUser();
  }

  formSubmit() {
    if (
      this.user.firstname == this.user1.firstname &&
      this.user.lastname == this.user1.lastname &&
      this.user.phone == this.user1.phone
    ) {
      this.snack.open('There has to be some changes!', 'dismiss', {
        duration: 3000,
      });
      return;
    }
    if (
      this.user.firstname == '' ||
      this.user.lastname == '' ||
      this.user.phone == ''
    ) {
      this.snack.open('Fields can not be empty!', 'dismiss', {
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
    this.userService.updateUser(this.user).subscribe(
      (data: any) => {
        this.login.getCurrentUser().subscribe((user: any) => {
          this.login.setUser(user);
        });
        Swal.fire('Success', 'Profile Updated', 'success');
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
