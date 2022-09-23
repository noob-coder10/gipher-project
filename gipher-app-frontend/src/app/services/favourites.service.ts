import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { favouriteUrl } from './helper';
@Injectable({
  providedIn: 'root',
})
export class FavouritesService {
  constructor(private http: HttpClient) {}

  public getFavourites(email: String) {
    return this.http.get(
      `${favouriteUrl}/favourites/getAllFavouritesByEmailId/${email}`
    );
  }

  public addFavourites(gif: any) {
    return this.http.post(`${favouriteUrl}/favourites/addToFavourites`, gif);
  }

  public deleteFavourites(id: String) {
    return this.http.delete(
      `${favouriteUrl}/favourites/deleteFromFavourites/${id}`
    );
  }
}
