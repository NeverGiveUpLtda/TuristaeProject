import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {

  id: any = "";
  usuario: any = {};

  email: string = "";
  senha: string = "";

  constructor(private _router: Router, private _route: ActivatedRoute) { }

  ngOnInit(): void {
    if(window.localStorage.getItem("permissao") === "turismo") {
      this._router.navigateByUrl('/inserir-turismo');
    } else if(!window.localStorage.getItem("permissao")) {
      this._router.navigateByUrl('/home');
    }
    window.localStorage.setItem("url", "edit-user");
    this.id = window.localStorage.getItem("id");
    this.buscarDados();
  }

  trocarDados(): void {
    let edit: any = {};
    edit = this.usuario;
    edit.email = this.email;
    edit.senha = this.senha;

  }

  excluirUsuario(): void {
  }

  // trazer informações
  buscarDados(): void {
//    this._usuario.buscarUsuarioPorId(this.id).subscribe((data: any) => {
  //    this.usuario = data;
    //  this.email = this.usuario.email;
      //this.senha = this.usuario.senha;
    //});
  }
}
