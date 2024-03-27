import { Component } from '@angular/core';
import { PostInterface } from 'src/interfaces/post.interface';

@Component({
  selector: 'app-inactive-posts',
  templateUrl: './inactive-posts.component.html',
  styleUrls: ['./inactive-posts.component.scss']
})
export class InactivePostsComponent {
  posts: PostInterface[] = []


  inactive!: PostInterface[]
  constructor() {
    this.inactive = this.inactivePosts
  }
  get inactivePosts(): PostInterface[] {
    return this.posts.filter((post) => !post.active);
  }
}
