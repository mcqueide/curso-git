import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-first-assignment',
  templateUrl: './first-assignment.component.html',
  styleUrls: ['./first-assignment.component.css']
})
export class FirstAssignmentComponent implements OnInit {
  private numbers = [];

  constructor() { }

  ngOnInit(): void {
  }

  onEventEmitted(number) {
    this.numbers.push(number);
  }

}
