import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { FirstAssignmentComponent } from './assignment/first-assignment/first-assignment.component';

@NgModule({
  declarations: [
    AppComponent,
    FirstAssignmentComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [FirstAssignmentComponent]
})
export class AppModule { }
