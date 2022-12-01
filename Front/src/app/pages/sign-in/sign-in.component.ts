import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  //  Variáveis dos inputs
  usuario: string = "";
  senha: string = "";

  //  Listas do backend
  visitantes: any;
  turistas: any;

  //  injeção de dependência
  constructor(private _http: HttpClient, private _router: Router) { }

  ngOnInit(): void {
    if(window.localStorage.getItem("usuario")) {
      this._router.navigateByUrl('/home');
    }
    window.localStorage.setItem("url", "sign-in");


    //  Set da lista de usuários
    this._http.get("http://localhost:8080/users").subscribe((data: any) => {
      this.turistas = data;
      console.log(this.turistas);
    });
  }

  login(): void {
    this.turistas.forEach((visitante: any) => {
      if(this.usuario === visitante.email && this.senha === visitante.senha) {
        window.localStorage.setItem("usuario", visitante.email);
        window.localStorage.setItem("permissao", visitante.permissao);
        window.localStorage.setItem("id", visitante.id_usuario)
        this._router.navigateByUrl('/home');
      }
    });
  }
}
