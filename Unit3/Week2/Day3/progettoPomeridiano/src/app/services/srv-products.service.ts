import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { ProductsResult } from '../models/products-result.interface';

@Injectable({
  providedIn: 'root'
})
export class SrvProductsService {
  private apiURL = 'https://dummyjson.com/products';
  favouritesSub = new Subject<number>();
  favouriteCounter = 0;

  constructor(private http: HttpClient) { }

  getProducts() {
    return this.http.get<ProductsResult>(this.apiURL).pipe(
      catchError((err) => {
        return throwError(this.getErrorMessage(err.status));
      })
    )
  }
  
  addFavourites() {
    this.favouriteCounter++;
    this.favouritesSub.next(this.favouriteCounter);
  }


  getErrorMessage(status: number) {
  let message = '';
  switch (status) {
    case 404:
      message = 'Elementi non trovati';
      break;
    default:
      message = 'Qualcosa non ha funzionato nella chiamata';
      break;
  }
  return message;

}
}


