import { Component, OnInit } from '@angular/core';
import { Auto } from 'src/app/models/auto.interface';

@Component({
  selector: 'app-home-uno',
  templateUrl: './home-uno.component.html',
  styleUrls: ['./home-uno.component.scss']
})
export class HomeUnoComponent {
  auto!: Auto[];
  loghi: Auto[] = [];

  ngOnInit(): void {
    this.getAuto()
  }

  async getAuto() {
    let risposta = await fetch ('assets/db.json')
    let dati = await risposta.json();
    this.auto = dati;
    this.loghi = this.auto.slice(0, 4)

  }
}
