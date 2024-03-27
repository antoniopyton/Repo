import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { PostDetailComponent } from './components/post-detail/post-detail.component';
import { SinglePostComponent } from './components/single-post/single-post.component';
import { ActivePostsComponent } from './components/active-posts/active-posts.component';
import { InactivePostsComponent } from './components/inactive-posts/inactive-posts.component';
import { Route, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { RandomColorDirective } from './directive/random-color.directive';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ActivePostsComponent,
    InactivePostsComponent,
    HomepageComponent,
    PostDetailComponent,
    SinglePostComponent,
    RandomColorDirective,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
