import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ComponentUnoComponent } from './components/component-uno/component-uno.component';
import { ComponentDueComponent } from './components/component-due/component-due.component';
import { ComponentTreComponent } from './components/component-tre/component-tre.component';

@NgModule({
  declarations: [
    AppComponent,
    ComponentUnoComponent,
    ComponentDueComponent,
    ComponentTreComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
