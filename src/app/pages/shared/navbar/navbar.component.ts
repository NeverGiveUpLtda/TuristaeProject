import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router'

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  hideLogo: boolean = true;
  url: string | null = "";

  constructor() { }

  ngOnInit(): void {
    this.url = window.localStorage.getItem("url");
    console.log(this.url);
    if(this.url === '/home' || this.url === '/saiba-mais')
      this.hideLogo = false;
  }
}
