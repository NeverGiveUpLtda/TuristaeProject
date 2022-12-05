import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { project } from 'src/config/project';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ConteudoService {

  constructor(private _http: HttpClient) { }

  buscarConteudos(): Observable<any> {
    return this._http.get(project.urlApi + 'conteudo/');
  }

  buscarConteudoPorId(id: number): Observable<any> {
    return this._http.get(project.urlApi + 'conteudo/' + id);
  }

  editarConteudo(obj: any): Observable<any> {
    return this._http.post(project.urlApi + 'conteudo/', obj);
  }

  excluirConteudo(id: number): Observable<any> {
    return this._http.delete(project.urlApi + 'conteudo/' + id);
  }
}
