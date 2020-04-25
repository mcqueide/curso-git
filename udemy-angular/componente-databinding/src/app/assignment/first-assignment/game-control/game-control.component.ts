import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-game-control',
  templateUrl: './game-control.component.html',
  styleUrls: ['./game-control.component.css']
})
export class GameControlComponent implements OnInit {
  @Output() private stopwatch = new EventEmitter<number>();
  private counter = 0;
  private intervalRef;
  constructor() { }

  ngOnInit(): void {
  }

  onStartGame() {
    this.intervalRef = setInterval(() => {
      this.stopwatch.emit(this.counter++);
    }, 1000);
  }

  onStopGame() {
    clearInterval(this.intervalRef);
  }
}
