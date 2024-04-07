import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth/auth.service';
import { AuthData } from 'src/app/interface/auth-data.interface';
import { Movies } from 'src/app/interface/movies.interface';
import { User } from 'src/app/interface/user.interface';
import { FilmService } from 'src/app/service/film.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  user!: AuthData | null;
  film!: Movies[];
  favourites: Movies[] = []; 
 
  constructor(private authsrv: AuthService, private mvSrv: FilmService) {
    this.authsrv.user$.subscribe((value) => {
      this.user = value;
    })
  }
 
  ngOnInit(): void {
    this.authsrv.user$.subscribe(async (data) => {
      this.user = data;
      if (data !== null) {
        this.loadFavorites(data.user.id);
      }
    });
  }

  async loadFavorites(userId: number) {
    this.film = [];
    let favorites = await this.mvSrv.getFilmsFavorites(userId);
    console.log(favorites);
    for (let i=0; i < favorites.length; i++) {
      let film = await this.mvSrv.getFilm(favorites[i].movieId).toPromise();
      console.log(film);
      if (film !== undefined) {
        film.video = true; 
        this.film.push(film);
      }
    }
  }
  async favourite(fav: Movies) {
    if (this.user) {
      let index = this.film.findIndex((value) => value.id === fav.id);
      if (index !== -1) {
        this.film[index].video = !this.film[index].video;
        if (!this.film[index].video) {
          
          this.film.splice(index, 1);
        }
       
        await this.mvSrv.toggle(fav.id, Number(this.user.user.id));
      }
    }
  }
}