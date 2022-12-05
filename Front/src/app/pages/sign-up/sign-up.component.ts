import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VisitanteService } from '../../services/visitante.service';
import { TurismoService } from '../../services/turismo.service';
import { ConteudoService } from '../../services/conteudo.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  // fisica
  tipoCadastro: string = "1";
  nome: string = "";
  email: string = "";
  senha: string = "";

  //  cnpj
  cnpj: string = "";
  telefone: string = "";
  email2: string = "";
  senha2: string = "";
  razaoSocial: string = "";
  cep: string = "";
  numero: string = "";
  logradouro: string = "";
  bairro: string = "";
  nomeFantasia: string = "";
  cidade: string = "";
  uf: string = "";

  constructor(private _router: Router, private _visitante: VisitanteService, private _turismo: TurismoService, private _conteudo: ConteudoService) { }

  ngOnInit(): void {
    if(window.localStorage.getItem("usuario")) {
      this._router.navigateByUrl('/home');
    }
    window.localStorage.setItem("url", "sign-up");
  }

  cadastrar(): void {
    let usuario: any = {};
    console.log(this.tipoCadastro);
    if(this.tipoCadastro === "1") {
      usuario.permissao = "visitante";
      usuario.email = this.email;
      usuario.senha = this.senha;
      usuario.nome = this.nome;
      this._visitante.editarVisitante(usuario).subscribe();
    } else {
      usuario.permissao = "turismo";
      usuario.nomefantasia = this.nomeFantasia;
      usuario.razaosocial = this.razaoSocial;
      usuario.bairro = this.bairro;
      usuario.celular = this.telefone;
      usuario.numero = this.numero;
      usuario.logradouro = this.logradouro;
      usuario.cep = this.cep;
      usuario.uf = this.uf;
      usuario.cnpj = this.cnpj;
      usuario.cidade = this.cidade;
      usuario.email = this.email2;
      usuario.senha = this.senha2;
      usuario.imagem = "";
      usuario.descricao = "";
      usuario.id_Turismo = "";
      usuario.email = this.email2;
      this._turismo.cadastrarTurismo(usuario).subscribe();
    }
  }

}
