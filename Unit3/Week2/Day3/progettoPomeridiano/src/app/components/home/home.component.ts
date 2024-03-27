import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { SrvProductsService } from 'src/app/services/srv-products.service';
import { Products } from 'src/app/models/products.interface';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit, OnDestroy {

  sub!: Subscription;
  products: Products[] | undefined;

  constructor(private service: SrvProductsService ) {}

  ngOnInit(): void {
    this.recoveryProducts();
    
  }

  recoveryProducts() {
    this.service.getProducts().subscribe((results) => {
      this.products = results.products;
      console.log(this.products);
    })
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
    
  }
}
