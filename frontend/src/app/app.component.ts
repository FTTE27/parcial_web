import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ContratoFormComponent } from "./contrato-form/contrato-form.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ContratoFormComponent],
  templateUrl: './app.component.html',


})
export class AppComponent {
  title = 'frontend';
}
