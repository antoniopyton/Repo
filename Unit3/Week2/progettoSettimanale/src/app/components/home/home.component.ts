import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/interface/todo.interface';
import { User } from 'src/app/interface/user.interface';
import { TodoService } from 'src/app/service/todo.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  todos: Todo[] = []
  users: User[] = []
  combinedItems: (Todo | User)[] = [];

  constructor(private todoService: TodoService, private userService: UserService) { }

  ngOnInit(): void {
    this.addToDoList()
    this.addUser()
  }
  async addToDoList() {
    try {
      this.todos = await this.todoService.getTodo();
    } catch (error) {
      console.error('Error fetching todos:', error);
    }
  }

  async addUser() {
    try {
      this.users = await this.userService.getUsers();
    } catch (error) {
      console.error('Error fetching users:', error);
    }
  }

  getName(id: number) {
    let name = ""
    this.users.forEach((value) => {
      if (value.id == id) {
        name = value.firstName + ' ' + value.lastName
      }
    })
    return name
  }
}
