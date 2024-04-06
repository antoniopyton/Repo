import { Component, OnInit } from '@angular/core';
import { Movies } from 'src/app/interface/movies.interface';
import { FilmService } from 'src/app/service/film.service';

@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrls: ['./film.component.scss']
})
export class FilmComponent implements OnInit {

  constructor( private mvSrv: FilmService) {}

  film!: Movies[]

  ngOnInit(): void {
    this.mvSrv.getFilms().subscribe((data) => {
      this.film = data
    })
    
  }
}

