import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { project } from 'src/config/project';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VisitanteService {

  constructor(private _http: HttpClient) { }

  buscarVisitantes(): Observable<any> {
    return this._http.get(project.urlApi + 'visitantes/');
  }

  buscarVisitantePorId(id: number): Observable<any> {
    return this._http.get(project.urlApi + 'visitantes/' + id);
  }

  editarVisitante(obj: any, id: number): Observable<any> {
    return this._http.put(project.urlApi + 'visitantes/' + id, obj);
  }

  excluirVisitante(id: number): Observable<any> {
    return this._http.delete(project.urlApi + 'visitantes/' + id);
  }
}
