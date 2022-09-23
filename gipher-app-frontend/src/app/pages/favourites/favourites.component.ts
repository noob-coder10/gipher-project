import { Component, OnInit } from '@angular/core';
import { FavouritesService } from 'src/app/services/favourites.service';
import { LoginService } from 'src/app/services/login.service';
import { Subscription } from 'rxjs';
import Swal from 'sweetalert2';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
@Component({
  selector: 'app-favourites',
  templateUrl: './favourites.component.html',
  styleUrls: ['./favourites.component.css'],
})
export class FavouritesComponent implements OnInit {
  gifs: any[] = [];
  subscription: Subscription;
  constructor(
    private favouriteService: FavouritesService,
    private loginService: LoginService,
    private snack: MatSnackBar,
    private router: Router
  ) {}

  ngOnInit(): void {
    let user = this.loginService.getUser();
    this.subscription = this.favouriteService
      .getFavourites(user.email)
      .subscribe((response: any) => {
        this.gifs = response;
      });
  }

  onClickUnfavourites(data: any) {
    this.favouriteService.deleteFavourites(data.favId).subscribe(
      (data1: any) => {
        window.location.href = '/favourites';
      },
      (error) => {
        this.snack.open('Something went wrong', 'dismiss', {
          duration: 3000,
        });
      }
    );
  }
}
