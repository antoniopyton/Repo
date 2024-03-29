import { Injectable, OnInit } from '@angular/core';
import { User } from '../interface/user.interface';

@Injectable({
  providedIn: 'root'
})
export class UserService implements OnInit {

  users: User[] = []

  constructor() { }

  ngOnInit() {
    this.getUsers()
  }

  async getUsers(): Promise<User[]> {
    let response = await fetch('assets/data/users.json');
    let data = await response.json();
    return data as User[];
  }
}
