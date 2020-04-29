import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { AccountComponent } from './account/account.component';
import { NewAccountComponent } from './new-account/new-account.component';
import { AccountsService } from './accounts.service';
import {LoggingService} from './logging.service';
import { FirstAssignmentComponent } from './assignment/first-assignment/first-assignment/first-assignment.component';
import {ActiveUsersComponent} from './assignment/first-assignment/active-users/active-users.component';
import {InactiveUsersComponent} from './assignment/first-assignment/inactive-users/inactive-users.component';

@NgModule({
  declarations: [
    AppComponent,
    AccountComponent,
    NewAccountComponent,
    FirstAssignmentComponent,
    ActiveUsersComponent,
    InactiveUsersComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
  ],
  // providers: [AccountsService, LoggingService],
  bootstrap: [FirstAssignmentComponent]
})
export class AppModule { }
