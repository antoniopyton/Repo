import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { Error404Component } from './components/error404/error404.component';
import { UsersComponent } from './components/users/users.component';
import { ProfileComponent } from './components/profile/profile.component';
import { FilmComponent } from './components/film/film.component';
import { AuthGuard } from './auth/auth.guard';
import { DetailsComponent } from './components/details/details.component';

const routes: Routes = [
  {
    path:"",
    component: HomeComponent
  },
  {
    path:"login",
    component: LoginComponent
  },
  {
    path:"register",
    component: RegisterComponent
  },
  {
    path:"users",
    component: UsersComponent,
    canActivate: [AuthGuard]
  },
  {
    path:"details/:id",
    component: DetailsComponent,
    canActivate: [AuthGuard]
  },
  {
    path:"film",
    component: FilmComponent,
    canActivate: [AuthGuard]
  },
  {
    path:"profile",
    component: ProfileComponent,
    canActivate: [AuthGuard]
  },
  {
    path:"error404",
    component: Error404Component
  },
  {
    path:"**",
    redirectTo: "error404"
  },
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
