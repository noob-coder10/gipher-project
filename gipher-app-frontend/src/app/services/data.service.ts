import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { apiUrl } from './helper';
@Injectable({
  providedIn: 'root',
})
export class DataService {
  gifs = new BehaviorSubject<any>([]);
  constructor(private http: HttpClient) {}

  getTrendingGifs() {
    return this.http.get(`${apiUrl}/`).subscribe((response: any) => {
      this.gifs.next(response);
    });
  }

  searchGifs(gifName: string) {
    return this.http.get(`${apiUrl}/${gifName}`).subscribe((response: any) => {
      this.gifs.next(response);
    });
  }

  getGifs() {
    return this.gifs.asObservable();
  }
}
