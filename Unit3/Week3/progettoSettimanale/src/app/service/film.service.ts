import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.development';
import { Movies } from '../interface/movies.interface';

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
}
