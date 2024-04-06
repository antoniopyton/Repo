import { Component, OnInit } from '@angular/core';
import { FormArray, Validator, FormBuilder, FormGroup, AbstractControl, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  homeform: FormGroup = new FormGroup({
    name: new FormControl('', [Validators.required]),
    surname: new FormControl('', [Validators.required]),
    username: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required]),
    passconfirm: new FormControl('', [Validators.required]),
    propic: new FormControl('', [Validators.required]),
    gender: new FormControl('', [Validators.required]),
    biography: new FormControl('', [Validators.required])
  })



  constructor(private fb: FormBuilder) {}
  // validUsername = (formC: AbstractControl) => {

  ngOnInit(): void {
    
  }

  submit() {
    console.log(this.homeform.value)
    this.homeform.reset();
    
  }

}
