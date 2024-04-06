import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.development';
import { User } from '../interface/user.interface';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  apiUrl = environment.apiURL

  constructor(private http: HttpClient) { }

  getUser() {
    return this.http.get<User[]>(`${this.apiUrl}users`)
  }
}
