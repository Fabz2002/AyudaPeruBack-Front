import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Pais } from '../voluntario';

@Injectable({
  providedIn: 'root'
})
export class PaisService {
  
  constructor(private httpClient: HttpClient) { }
  //Este metodo nos sirve para obtener los empleados
  obtenerListaPaises():Observable<Pais[]>{
    return this.httpClient.get<Pais[]>(`${environment.urlApi}paises`);
  }
}
