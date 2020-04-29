import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CounterService {
  changesActiveToInactive = 0;
  changesInactiveToActive = 0;
  constructor() { }

  changeActiveToInactive() {
    this.changesActiveToInactive++;
    console.log('changesActiveToInactive: ' + this.changesActiveToInactive);
  }

  changeInactiveToActive() {
    this.changesInactiveToActive++;
    console.log('changesInactiveToActive: ' + this.changesInactiveToActive);
  }
}
