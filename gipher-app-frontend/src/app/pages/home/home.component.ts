import { Component, OnInit } from '@angular/core';
import { HeaderComponent } from 'src/app/header/header.component';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  isLoggedIn = false;
  constructor(private login: LoginService) {}

  ngOnInit(): void {
    this.isLoggedIn = this.login.isLoggedIn();
  }
}
