import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { project } from 'src/config/project';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private _http: HttpClient) { }

  buscarUsuarios(): Observable<any> {
    return this._http.get(project.urlApi + 'users/');
  }

  buscarUsuarioPorId(id: number): Observable<any> {
    return this._http.get(project.urlApi + 'users/' + id);
  }

  editarUsuario(obj: any, id: number): Observable<any> {
    return this._http.put(project.urlApi + 'users/' + id, obj);
  }

  excluirUsuario(id: number): Observable<any> {
    return this._http.delete(project.urlApi + 'users/' + id);
  }
}
