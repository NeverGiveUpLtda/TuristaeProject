import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioService } from 'src/app/services/usuario.service';

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
  usuarios: any;

  //  injeção de dependência
  constructor(private _users: UsuarioService, private _router: Router) { }

  ngOnInit(): void {
    if(window.localStorage.getItem("usuario")) {
      this._router.navigateByUrl('/home');
    }
    window.localStorage.setItem("url", "sign-in");

    //  Set da lista de usuários
    this.buscarUsuarios();
  }

  login(): void {
    this.usuarios.forEach((usuario: any) => {
      if(this.usuario === usuario.email && this.senha === usuario.senha) {
        window.localStorage.setItem("usuario", usuario.email);
        window.localStorage.setItem("permissao", usuario.permissao);
        window.localStorage.setItem("id", usuario.id_Usuario)
        this._router.navigateByUrl('/home');
        console.log(usuario);
      }
    });
    console.log(this.usuarios);
  }

  buscarUsuarios(): void {
    this._users.buscarUsuarios().subscribe((data: any) => {
      this.usuarios = data;
    });
  }
}
