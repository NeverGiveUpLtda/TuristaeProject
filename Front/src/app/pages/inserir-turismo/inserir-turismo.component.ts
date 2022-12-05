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

  constructor(private _router: Router, private _turismo: TurismoService) { }

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
    this.turismo.descricao = this.descricao;
    if(this.banner === null || this.banner === undefined){
      this._turismo.editarTurismo(this.turismo, this.id).subscribe();
    } else {
      this._turismo.editarTurismo(this.turismo, this.id).subscribe();
      console.log(this.banner);
      this._turismo.editarImagem(this.id, this.banner).subscribe();
    }
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
        this.descricao = data.descricao;
        console.log(data);
      });
    }
}
