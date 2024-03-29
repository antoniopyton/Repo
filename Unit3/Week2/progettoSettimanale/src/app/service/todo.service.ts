import { Injectable, OnInit } from '@angular/core';
import { Todo } from '../interface/todo.interface';

@Injectable({
  providedIn: 'root'
})
export class TodoService implements OnInit {

  todo: Todo[] = [];

  constructor() { }

  ngOnInit() {
    this.getTodo()
  }

  async getTodo(): Promise<Todo[]> {
    let response = await fetch('assets/data/todos.json');
    let data = await response.json();
    return data as Todo[];
  }

  getCompletedToDo(): Todo[] {
    return this.todo.filter(todo => todo.completed);
  }
}