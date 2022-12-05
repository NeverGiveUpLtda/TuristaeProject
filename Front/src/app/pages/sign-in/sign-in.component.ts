import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TurismoService } from '../../services/turismo.service';
import { VisitanteService } from '../../services/visitante.service';

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
  turismos: any;
  visitantes: any;

  //  injeção de dependência
  constructor(private _turismo: TurismoService, private _visitante: VisitanteService, private _router: Router) { }

  ngOnInit(): void {
    if(window.localStorage.getItem("usuario")) {
      this._router.navigateByUrl('/home');
    }
    window.localStorage.setItem("url", "sign-in");

    //  Set da lista de usuários
    this.buscarUsuarios();
  }

  //login(): void {
    //this.turismos.forEach((turismo: any) => {
      //if(this.usuario === turismo.email && this.senha === turismo.senha) {
        //window.localStorage.setItem("usuario", turismo.email);
        //window.localStorage.setItem("permissao", turismo.permissao);
        //window.localStorage.setItem("id", turismo.id_Usuario)
        //this._router.navigateByUrl('/home');
        //console.log(usuario);
      //}
    //});
    //console.log(this.turismos);
  //}

  login(): void {
    this.visitantes.forEach((visitante: any) => {
      if(this.usuario === visitante.email && this.senha === visitante.senha) {
        window.localStorage.setItem("usuario", visitante.email);
        window.localStorage.setItem("permissao", visitante.permissao);
        window.localStorage.setItem("id", visitante.id_Turismo);
        this._router.navigateByUrl('/home');
      }
    });

    this.turismos.forEach((turismo: any) => {
      if(this.usuario === turismo.email && this.senha === turismo.senha) {
        window.localStorage.setItem("usuario", turismo.email);
        window.localStorage.setItem("permissao", turismo.permissao);
        window.localStorage.setItem("id", turismo.id_Turismo);
        this._router.navigateByUrl('/home');
      }
    });
  }

  buscarUsuarios(): void {
    this._turismo.buscarTurismos().subscribe((data: any) => {
      this.turismos = data;
      console.log("Turismos: ", data);
    });

    this._visitante.buscarVisitantes().subscribe((data: any) => {
      this.visitantes = data;
      console.log("Visitantes: ", data);
    });
  }
}
