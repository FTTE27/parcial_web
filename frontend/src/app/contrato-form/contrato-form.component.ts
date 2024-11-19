import { Component, OnInit } from '@angular/core';
import { ContratoService } from '../contrato-service.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-contrato-form',
  standalone: true, 
  templateUrl: './contrato-form.component.html',
  styleUrls: ['./contrato-form.component.css'],
  imports: [FormsModule],
})
export class ContratoFormComponent implements OnInit {
  contratos: any[] = [];
  contrato: any = {
    identificador: '',
    valor: null,
    nombreContratante: '',
    documentoContratante: '',
    nombreContratantista: '',
    documentoContratantista: '',
    fechaInicial: '',
    fechaFinal: ''
  };

  constructor(private contratoService: ContratoService) {}

  ngOnInit(): void {
    this.obtenerContratos();
  }

  obtenerContratos(): void {
    this.contratoService.obtenerContratos().subscribe(data => {
      this.contratos = data;
    });
  }

  crearContrato(): void {
    this.contratoService.crearContrato(this.contrato).subscribe(() => {
      this.obtenerContratos();
      this.resetForm();
    });
  }

  eliminarContrato(id: number): void {
    this.contratoService.eliminarContrato(id).subscribe(() => {
      this.obtenerContratos();
    });
  }

  resetForm(): void {
    this.contrato = {
      identificador: '',
      valor: null,
      nombreContratante: '',
      documentoContratante: '',
      nombreContratantista: '',
      documentoContratantista: '',
      fechaInicial: '',
      fechaFinal: ''
    };
  }
}

