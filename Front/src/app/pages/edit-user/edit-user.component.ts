import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {

  usuarioId: string = "";

  constructor(private _router: Router, private _route: ActivatedRoute) { }

  ngOnInit(): void {
    if(window.localStorage.getItem("permissao") === "turismo") {
      this._router.navigateByUrl('/inserir-turismo');
    } else if(!window.localStorage.getItem("permissao")) {
      this._router.navigateByUrl('/home');
    }
    window.localStorage.setItem("url", "edit-user");
    this.usuarioId = "" + window.localStorage.getItem("id");
  }

  trocarDados(): void {

  }

  excluirUsuario(): void {

  }
}
