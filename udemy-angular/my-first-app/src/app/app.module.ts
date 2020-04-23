import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ServerComponent } from './server/server.component';
import { ServersComponent } from './servers/servers.component';
import { SuccessAlertComponent } from './assignment/first-assignment/success-alert/success-alert.component';
import { WarningAlertComponent } from './assignment/first-assignment/warning-alert/warning-alert.component';
import { SecondAssignmentComponent } from './assignment/second-assignment/second-assignment.component';
import { FormsModule } from '@angular/forms';
import { FirstAssignmentComponent } from './assignment/first-assignment/first-assignment.component';

@NgModule({
  declarations: [
    AppComponent,
    ServerComponent,
    ServersComponent,
    SuccessAlertComponent,
    WarningAlertComponent,
    FirstAssignmentComponent,
    SecondAssignmentComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
