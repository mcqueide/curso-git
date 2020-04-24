import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-third-assignment',
  templateUrl: './third-assignment.component.html',
  styleUrls: ['./third-assignment.component.css']
})
export class ThirdAssignmentComponent implements OnInit {
  showSecret = false;
  log = [];

  constructor() { }

  ngOnInit(): void {
  }

  onToggleDetails() {
    this.showSecret = !this.showSecret;
    this.log.push(`Button was clicked ${this.log.length + 1} time(s).`);
  }
}
