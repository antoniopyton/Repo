import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.development';
import { Movies } from '../interface/movies.interface';
import { BehaviorSubject, Observable, map } from 'rxjs';
import { Favorite } from '../interface/favorite.interface';

@Injectable({
  providedIn: 'root'
})
export class FilmService {
  
  apiUrl = environment.apiURL

  constructor(private http: HttpClient) { }

  getFilms() {
    return this.http.get<Movies[]>(`${this.apiUrl}movies-popular`)
  }

  getFilm(id: number) {
    return this.http.get<Movies>(`${this.apiUrl}movies-popular/${id}`)
  }

  async getFilmsFavorites(userId:number) {
    let favoritesP = await this.http.get<Favorite[]>(`${this.apiUrl}favorites`).toPromise()
    let favorites: Favorite[] = []
    let myFavorites: Favorite[] = []
    if (favoritesP !== undefined) {
      favorites = [...favoritesP]
      for (let i = 0; i < favorites.length; i++) {
        if (favorites[i].userId === userId) {
          myFavorites.push(favorites[i])
        }
      }
    }
    return myFavorites
  }

  async toggle(id: number, userId: number) {
    let favouritesP = await this.http.get<Favorite[]>(`${this.apiUrl}favorites`).toPromise()
    if (favouritesP !== undefined) {
      let favorites: Favorite[] = [...favouritesP]
      let found = false
      for (const element of favorites) {
        if (element.movieId === id && element.userId === userId) {
          found = true
          this.http.delete(`${this.apiUrl}favorites/${element.id}`).subscribe()
        }
      }
      if (!found) {
        this.http.post(`${this.apiUrl}favorites`, {userId: userId, movieId: id}).subscribe()
      }
    }
  }
}
