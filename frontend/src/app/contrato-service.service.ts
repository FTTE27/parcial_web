import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContratoService {

  private apiUrl = 'http://localhost:8080/api/contratos';

  constructor(private http: HttpClient) { }

  crearContrato(contrato: any): Observable<any> {
    return this.http.post(this.apiUrl, contrato);
  }

  obtenerContratos(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  obtenerContratoPorId(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }

  actualizarContrato(id: number, contrato: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}`, contrato);
  }

  eliminarContrato(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
