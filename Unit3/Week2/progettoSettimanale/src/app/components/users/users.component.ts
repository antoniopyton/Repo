import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/interface/todo.interface';
import { User } from 'src/app/interface/user.interface';
import { TodoService } from 'src/app/service/todo.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {
  todos: Todo[] = []
  users: User[] = []
  userTasksMap: Map<number, Todo[]> = new Map<number, Todo[]>();

  constructor(private userService: UserService, private todoService: TodoService) { }

  ngOnInit(): void {
    this.showUser();
    this.addToDoList();
  }

  async showUser() {
    try {
      this.users = await this.userService.getUsers();
    } catch (error) {
      console.error('Error fetching Users:', error);
    }
  }
  async addToDoList() {
    try {
      this.todos = await this.todoService.getTodo();
      this.mapUserTasks();
    } catch (error) {
      console.error('Error fetching todos:', error);
    }
  }

  mapUserTasks() {
    this.users.forEach(user => {
      const tasksForUser = this.todos.filter(todo => todo.userId === user.id);
      this.userTasksMap.set(user.id, tasksForUser);
    });
  }
}