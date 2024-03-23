import { Component } from '@angular/core';
import { Auto } from 'src/app/models/auto.interface';

@Component({
  selector: 'app-tesla',
  templateUrl: './tesla.component.html',
  styleUrls: ['./tesla.component.scss']
})
export class TeslaComponent {
  auto!: Auto[];
  related: Auto[] = [];
  included: number[] = [];
  isLoaded = false;

  ngOnInit(): void {
    this.getAuto()
  }

  constructor() {
    this.getAuto().then((data) => {
      this.auto = data.filter((value:Auto) => value.brand == 'Tesla')
    })
  }

  async getAuto() {
    let risposta = await fetch('assets/db.json')
    let dati = await risposta.json();
    return dati
  }

}
