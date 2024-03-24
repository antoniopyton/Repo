import { Component, OnInit } from '@angular/core';
import { Auto } from 'src/app/models/auto.interface';

@Component({
  selector: 'app-home-uno',
  templateUrl: './home-uno.component.html',
  styleUrls: ['./home-uno.component.scss']
})
export class HomeUnoComponent {
  auto!: Auto[];
  fiat: Auto[] = [];
  ford: Auto[] = [];
  audi: Auto[] = [];
  tesla: Auto[] = [];

  ngOnInit(): void {
    this.getLogo()
  }

  async getLogo() {
    let risposta = await fetch ('assets/db.json')
    let dati = await risposta.json();
    this.auto = dati;
    this.fiat = this.auto.slice(0, 1)
    this.ford = this.auto.slice(2, 3)
    this.audi = this.auto.slice(1, 2)
    this.tesla = this.auto.slice(3, 4)

  }
}
