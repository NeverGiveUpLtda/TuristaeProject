import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-inserir-turismo',
  templateUrl: './inserir-turismo.component.html',
  styleUrls: ['./inserir-turismo.component.css']
})
export class InserirTurismoComponent implements OnInit {

  constructor(private _router: Router) { }

  ngOnInit(): void {
    if(window.localStorage.getItem("usuario") != "turismo") {
      this._router.navigateByUrl('/home');
    }
    window.localStorage.setItem("url", "inserir-turismo");
  }

}
