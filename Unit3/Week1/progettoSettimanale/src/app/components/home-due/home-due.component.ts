import { Component } from '@angular/core';
import { Auto } from 'src/app/models/auto.interface';

@Component({
  selector: 'app-home-due',
  templateUrl: './home-due.component.html',
  styleUrls: ['./home-due.component.scss']
})
export class HomeDueComponent {
  auto!: Auto[];
  related: Auto[] = [];
  included: number[] = [];
  isLoaded = false;

  ngOnInit() {
    this.getAuto()
  }

  async getAuto() {
    let risposta = await fetch('assets/db.json')
    let dati = await risposta.json();
    this.auto = dati;
    this.relatedCars();
  }

  relatedCars() {
    for (let i = 0; i < 2; i++) {
      let index = Math.floor(Math.random() * this.auto.length);
      if (this.included.includes(index)) {
        index = Math.floor(Math.random() * this.auto.length);
      }
      this.included.push(index)
    }
    for (let i = 0; i < this.included.length; i++) {
      let postIndex = this.included[i];
      this.related.push(this.auto[postIndex])
    }
    this.isLoaded = true;
  }
}
