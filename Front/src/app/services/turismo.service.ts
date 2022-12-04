import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { project } from 'src/config/project';

@Injectable({
  providedIn: 'root'
})
export class TurismoService {

  constructor(private _http: HttpClient) { }

  buscarTurismos(): Observable<any> {
    return this._http.get(project.urlApi + 'turismo/');
  }

  buscarTurismoPorId(id: number): Observable<any> {
    return this._http.get(project.urlApi + 'turismo/' + id);
  }

  editarTurismo(obj: any, id: number): Observable<any> {
    return this._http.put(project.urlApi + 'turismo/' + id, obj);
  }

  excluirTurismo(id: number): Observable<any> {
    return this._http.delete(project.urlApi + 'turismo/' + id);
  }
}