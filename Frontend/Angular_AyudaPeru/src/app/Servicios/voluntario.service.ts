import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, retry, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Voluntario } from '../voluntario';

@Injectable({
  providedIn: 'root'
})
export class VoluntarioService {

  constructor(private httpClient: HttpClient) { }
  //Este metodo nos sirve para obtener los empleados
  obtenerListaVoluntarios(): Observable<Voluntario[]> {
    return this.httpClient.get<Voluntario[]>(`${environment.urlApi}voluntarios`);
  }
  //Este metodo es para registrar un voluntario
  registrarVoluntario(voluntario: Voluntario): Observable<Voluntario> {
    return this.httpClient.post(`${environment.urlApi}voluntario`, voluntario).pipe(
      retry(3),
      catchError(this.handleError)
    );
  }
  obtenerVoluntarioPorId(idVoluntario:number):Observable<Voluntario>{
    return this.httpClient.get<Voluntario>(`${environment.urlApi}voluntarios/${idVoluntario}`).pipe(
      retry(3),
      catchError(this.handleError)
    );
  }
  deleteVoluntario(idVoluntario:number):Observable<any>{
    return this.httpClient.delete<Voluntario>(`${environment.urlApi}voluntario/${idVoluntario}`).pipe(
      retry(3),
      catchError(this.handleError)
    );
  }
  handleError(error: any) {
    debugger
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return throwError(() => {
      return errorMessage;
    });
  }
}


