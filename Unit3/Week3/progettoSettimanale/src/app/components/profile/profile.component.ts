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
  
  user!: AuthData | null 
  film!: Movies[]
  favourites!: Partial<Movies[]>

  constructor(private authsrv: AuthService,  private mvSrv: FilmService) {}

  ngOnInit(): void {
    this.authsrv.user$.subscribe((data) => {
      this.user = data
      console.log(data)
    })
     this.mvSrv.getFilms().subscribe((data) => {
      this.film = data
    })
  }
}
