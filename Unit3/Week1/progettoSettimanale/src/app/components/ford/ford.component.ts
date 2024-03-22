import { Component } from '@angular/core';
import { Auto } from 'src/app/models/auto.interface';


@Component({
  selector: 'app-ford',
  templateUrl: './ford.component.html',
  styleUrls: ['./ford.component.scss']
})
export class FordComponent {
  auto!: Auto[];
  related: Auto[] = [];
  included: number[] = [];
  isLoaded = false;

  ngOnInit(): void {
    this.getAuto()
  }

  constructor() {
    this.getAuto().then((data) => {
      this.auto = data.filter((value:Auto) => value.brand == 'Ford')
    })
  }

  async getAuto() {
    let risposta = await fetch('assets/db.json')
    let dati = await risposta.json();
    return dati

  }
}
