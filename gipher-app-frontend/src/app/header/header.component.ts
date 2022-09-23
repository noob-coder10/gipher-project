import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../services/data.service';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  isLoggedIn = false;
  user = null;

  constructor(
    private dataService: DataService,
    public login: LoginService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.isLoggedIn = this.login.isLoggedIn();
    this.user = this.login.getUser();
    this.login.loginStatusSubject.asObservable().subscribe((data) => {
      this.isLoggedIn = this.login.isLoggedIn();
      this.user = this.login.getUser();
    });
  }

  search(searchTerm: string) {
    if (searchTerm !== '') {
      this.router.navigate(['gif']);
      this.dataService.searchGifs(searchTerm);
    } else {
      this.router.navigate(['gif']);
    }
  }
  trendingGifs() {
    this.router.navigate(['gif']);
    this.dataService.getTrendingGifs();
  }

  public logout() {
    this.login.logout();
    window.location.reload();
  }

  displayStyle = 'none';

  openPopup() {
    this.displayStyle = 'block';
  }
  closePopup() {
    this.displayStyle = 'none';
  }
}
