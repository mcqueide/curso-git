import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-first-assignment',
  templateUrl: './first-assignment.component.html',
  styleUrls: ['./first-assignment.component.css']
})
export class FirstAssignmentComponent implements OnInit {
  @ViewChild('form', { static: true }) form: NgForm;
  subscriptions = ['Basic', 'Advanced', 'Pro'];
  defaultSubcription = 'Advanced';
  submittedData = '';

  constructor() { }

  ngOnInit() {
  }

  onSubmit() {
    this.submittedData = JSON.stringify(this.form.value, null, 2 );
    console.log(this.form.value);
  }
}
