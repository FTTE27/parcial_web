import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContratosArrendadorComponent } from './contratos-arrendador/contratos-arrendador.component';
import { LoginComponent } from './login/login.component'; // Componente de login
<<<<<<< Updated upstream
=======
import { ContratosArrendatarioComponent } from './contratos-arrendatario/contratos-arrendatario.component';
>>>>>>> Stashed changes
import { PrincipalArrendadorComponent } from './principal-arrendador/principal-arrendador.component';
import { PrincipalArrendatarioComponent } from './principal-arrendatario/principal-arrendatario.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'arrendador/:idArrendador/contratos', component: ContratosArrendadorComponent },
<<<<<<< Updated upstream
  { path: 'arrendador/:idArrendador', component: PrincipalArrendadorComponent },
  { path: 'arrendatario/:idArrendatario', component: PrincipalArrendatarioComponent },
=======
  { path: 'arrendatario/:idArrendatario/contratos', component: ContratosArrendatarioComponent},
  { path: 'arrendador/:idArrendador', component: PrincipalArrendadorComponent },
  { path: 'arrendatario/:idArrendatario', component: PrincipalArrendatarioComponent },
  // Otras rutas...
>>>>>>> Stashed changes
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
