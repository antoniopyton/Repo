import { Component, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Route, RouterModule } from '@angular/router';


import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { ToDoComponent } from './components/to-do/to-do.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { Error404Component } from './components/error404/error404.component';
import { DoneComponent } from './components/done/done.component';
import { UsersComponent } from './components/users/users.component';

const routes: Route[] = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "todo",
    component: ToDoComponent
  },
  {
    path: "done",
    component: DoneComponent
  },
  {
    path: "users",
    component: UsersComponent
  },
  {
    path: "error404",
    component: Error404Component
  },
  {
    path: "**",
    redirectTo: "error404"
  }

]


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ToDoComponent,
    NavbarComponent,
    Error404Component,
    DoneComponent,
    UsersComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
