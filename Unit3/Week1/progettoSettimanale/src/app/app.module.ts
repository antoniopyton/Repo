import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Route } from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeUnoComponent } from './components/home-uno/home-uno.component';
import { HomeDueComponent } from './components/home-due/home-due.component';
import { HomeTreComponent } from './components/home-tre/home-tre.component';
import { FiatComponent } from './components/fiat/fiat.component';
import { FordComponent } from './components/ford/ford.component';
import { AudiComponent } from './components/audi/audi.component';
import { PostDetailComponent } from './components/post-detail/post-detail.component';
import { Error404Component } from './components/error404/error404.component';
import { TeslaComponent } from './components/tesla/tesla.component';


const routes: Route[] = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "fiat",
    component: FiatComponent
  },
  {
    path: "ford",
    component: FordComponent
  },
  {
    path: "audi",
    component: AudiComponent
  },
  {
    path: "tesla",
    component: TeslaComponent
  },
  {
    path: "postDetail",
    component: PostDetailComponent
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
    NavbarComponent,
    FooterComponent,
    HomeUnoComponent,
    HomeDueComponent,
    HomeTreComponent,
    FiatComponent,
    FordComponent,
    AudiComponent,
    PostDetailComponent,
    Error404Component,
    TeslaComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
  
})
export class AppModule { }
