import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { DataService } from '../services/data.service';
import { FavouritesService } from '../services/favourites.service';
import Swal from 'sweetalert2';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from '../services/login.service';
@Component({
  selector: 'app-gifs',
  templateUrl: './gifs.component.html',
  styleUrls: ['./gifs.component.css'],
})
export class GifsComponent implements OnInit, OnDestroy {
  gifs: any[] = [];
  gifsNew: any[] = [];
  subscription: Subscription;

  public gif = {
    favId: '',
    username: '',
    emailId: '',
    title: '',
    imageURL: '',
    isSticker: '',
  };
  constructor(
    private dataService: DataService,
    private favouriteService: FavouritesService,
    private snack: MatSnackBar,
    public loginService: LoginService
  ) {}

  ngOnInit(): void {
    this.dataService.getTrendingGifs();
    this.subscription = this.dataService
      .getGifs()
      .subscribe((response: any) => {
        this.gifs = response;
      });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  onClickFavourite(data: any) {
    if (this.onCheckFavourites(data)) {
      this.snack.open('Already added to Wishlist', 'dismiss', {
        duration: 3000,
      });
    } else {
      let user = this.loginService.getUser();
      this.gif.favId = data.id;
      this.gif.username = data.username;
      this.gif.emailId = user.email;
      this.gif.title = data.title;
      this.gif.imageURL = data.url;
      this.gif.isSticker = data.isSticker;
      this.favouriteService.addFavourites(this.gif).subscribe(
        (data1: any) => {
          this.snack.open('Added to Wishlist', 'dismiss', {
            duration: 3000,
          });
        },
        (error) => {
          this.snack.open('Something went wrong', 'dismiss', {
            duration: 3000,
          });
        }
      );
    }
  }
  onClickUnfavourites(data: any) {
    if (!this.onCheckFavourites(data)) {
      this.snack.open('Does not exist in Wishlist', 'dismiss', {
        duration: 3000,
      });
    } else {
      this.favouriteService.deleteFavourites(data.id).subscribe(
        (data1: any) => {
          this.snack.open('Removed from Wishlist', 'dismiss', {
            duration: 3000,
          });
        },
        (error) => {
          this.snack.open('Something went wrong', 'dismiss', {
            duration: 3000,
          });
        }
      );
    }
  }
  onCheckFavourites(data: any) {
    let user = this.loginService.getUser();
    this.subscription = this.favouriteService
      .getFavourites(user.email)
      .subscribe((response: any) => {
        this.gifsNew = response;
      });
    if (this.gifsNew.find((o) => o.favId === data.id) != null) {
      return true;
    }
    return false;
  }
}
