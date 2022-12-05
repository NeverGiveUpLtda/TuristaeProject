import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TurismoService } from '../../services/turismo.service';
import { ConteudoService } from '../../services/conteudo.service';

@Component({
  selector: 'app-inserir-turismo',
  templateUrl: './inserir-turismo.component.html',
  styleUrls: ['./inserir-turismo.component.css']
})
export class InserirTurismoComponent implements OnInit {

  descricao: string = "";
  turismo: any = {};
  banner: File | null = null;
  id: any = "";
  idConteudo: any = "";

  constructor(private _router: Router, private _turismo: TurismoService, private _conteudo: ConteudoService) { }

  ngOnInit(): void {
    if(window.localStorage.getItem("permissao") === "visitante") {
      this._router.navigateByUrl('/edit-user');
    } else if(!window.localStorage.getItem("permissao")) {
      this._router.navigateByUrl('/home');
    }
    window.localStorage.setItem("url", "inserir-turismo");
    this.id = window.localStorage.getItem("id")
    this.buscarDados();
  }

  cadastrar(): void {
    let edit: any = {};
    edit.descricao = this.turismo.iD_Conteudo.descricao;
    edit.anexo = this.banner;
    if(edit.anexo === null)
      edit.anexo = "";
    edit.id_Post = this.idConteudo;
    this._conteudo.editarConteudo(edit).subscribe();
  }

  // On file Select
  onChange(event: any) {
    this.banner = event.target.files[0];
    if(this.banner?.type === "image/jpeg" || this.banner?.type === "image/png")
    {
    } else
    {
      this.banner = null;
    }
  }

    // trazer informações
    buscarDados(): void {
      this._turismo.buscarTurismoPorId(this.id).subscribe((data: any) => {
        this.turismo = data;
        this.idConteudo = data.iD_Conteudo.id_Post;
        this.descricao = data.iD_Conteudo.descricao;
      });
    }
}
