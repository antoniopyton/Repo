import { Component, OnInit } from '@angular/core';
import { PostService } from 'src/app/services/post.service';
import { PostInterface } from 'src/interfaces/post.interface';

@Component({
  selector: 'app-active-posts',
  templateUrl: './active-posts.component.html',
  styleUrls: ['./active-posts.component.scss'],
})
export class ActivePostsComponent {
  posts: PostInterface[] = []

  constructor(private postSrv: PostService) {}

  ngOnInit(): void {
    this.posts = this.postSrv.getPost().filter((post) => post.active)
  }
}
