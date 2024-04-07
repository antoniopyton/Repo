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
  favourites: Movies[] = []; // Initialize the favorites array
 
  constructor(private authsrv: AuthService, private mvSrv: FilmService) {}
 
  ngOnInit(): void {
     this.authsrv.user$.subscribe(async (data) => {
       this.user = data;
       if (data !== null) {
        this.film = []
         let favorites = await this.mvSrv.getFilmsFavorites(Number(data.user.id))
         console.log(favorites)
         for (let i=0; i < favorites.length; i++) {
            let film = await this.mvSrv.getFilm(favorites[i].movieId).toPromise()
            console.log(film)
            if (film !== undefined) {
              this.film.push(film)
            }
         }
       }
     });
  }
  
 }
 
