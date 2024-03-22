import { Component } from '@angular/core';
import { Auto } from 'src/app/models/auto.interface';

@Component({
  selector: 'app-audi',
  templateUrl: './audi.component.html',
  styleUrls: ['./audi.component.scss']
})
export class AudiComponent {
  auto!: Auto[];
  related: Auto[] = [];
  included: number[] = [];
  isLoaded = false;

  ngOnInit() {
    this.getAuto()
  }

  constructor() {
    this.getAuto().then((data) => {
      this.auto = data.filter((value:Auto) => value.brand == 'Audi')
    })
  }

  async getAuto() {
    let risposta = await fetch('assets/db.json')
    let dati = await risposta.json();
    return dati

  }
}
