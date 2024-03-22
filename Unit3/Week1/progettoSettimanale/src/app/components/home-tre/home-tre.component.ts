import { Component } from '@angular/core';
import { Auto } from 'src/app/models/auto.interface';

@Component({
  selector: 'app-home-tre',
  templateUrl: './home-tre.component.html',
  styleUrls: ['./home-tre.component.scss']
})
export class HomeTreComponent {
  auto!: Auto[];
}
