import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'homepage',
  templateUrl: './homepage.component.html'
})

export class HomePageComponent implements OnInit {

  constructor(private router: Router) { }
  ngOnInit(): void {
  }


  redirect() {
    this.router.navigate(["/homepage"]);
  }

}