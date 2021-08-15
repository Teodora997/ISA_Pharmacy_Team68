import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'all-medicines',
  templateUrl: './all-medicines.component.html'
})

export class AllMedicinesComponent implements OnInit {

  constructor(private router: Router) { }
  ngOnInit(): void {
  }

}