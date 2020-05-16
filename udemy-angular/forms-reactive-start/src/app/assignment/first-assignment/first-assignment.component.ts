import { Component, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-first-assignment',
  templateUrl: './first-assignment.component.html',
  styleUrls: ['./first-assignment.component.css']
})
export class FirstAssignmentComponent implements OnInit {
  form: FormGroup;
  statusOptions = ['Stable', 'Critical', 'Finished'];

  constructor() { }

  ngOnInit() {
    this.form = new FormGroup({
      // 'name': new FormControl(null, [Validators.required, this.forbiddenName]),
      'name': new FormControl(null, [Validators.required], this.forbiddenNameAsync.bind(this)),
      'email': new FormControl(null, [Validators.required, Validators.email]),
      'status': new FormControl(null)
    });
  }

  onSubmit() {
    console.log(this.form.value);
  }

  forbiddenName(control: FormControl): {[s: string]: boolean} {
    if (control.value === 'Test') {
      return {'nameIsForbidden' : true};
    } else {
      return null;
    }
  }

  forbiddenNameAsync(control: FormControl): Promise<any> | Observable<any> {
    const promise = new Promise((resolve, reject) => {
      setTimeout(() => {
        resolve(this.forbiddenName(control));
      }, 1500);
    });

    return promise;
  }

}
