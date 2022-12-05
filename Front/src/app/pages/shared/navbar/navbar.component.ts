import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router'

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  logado: boolean = false;
  hideLogo: boolean = true;
  url: string | null = "";

  constructor(private _router: Router) { }

  ngOnInit(): void {
    this.logado = false;
    if(window.localStorage.getItem("usuario"))
    {
      this.logado = true;
    }

    this.url = window.localStorage.getItem("url");
    if(this.url === '/home' || this.url === '/saiba-mais')
      this.hideLogo = false;
  }

  logout(): void {
    window.localStorage.clear();
    window.location.reload();
  }
}
