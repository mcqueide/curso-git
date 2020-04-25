import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { CockpitComponent } from './cockpit/cockpit.component';
import { ServerElementComponent } from './server-element/server-element.component';
import { FirstAssignmentComponent } from './assignment/first-assignment/first-assignment.component';
import { GameControlComponent } from './assignment/first-assignment/game-control/game-control.component';
import { OddComponent } from './assignment/first-assignment/odd/odd.component';
import { EvenComponent } from './assignment/first-assignment/even/even.component';

@NgModule({
  declarations: [
    AppComponent,
    CockpitComponent,
    ServerElementComponent,
    FirstAssignmentComponent,
    GameControlComponent,
    OddComponent,
    EvenComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [FirstAssignmentComponent]
})
export class AppModule { }
