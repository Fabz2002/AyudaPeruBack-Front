import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListaVoluntariosComponent } from './lista-voluntarios/lista-voluntarios.component';
import { RegistrarVoluntarioComponent } from './registrar-voluntario/registrar-voluntario.component';

const routes: Routes = [
  {path: 'voluntarios',component:ListaVoluntariosComponent},
  {path:'',redirectTo:'voluntarios',pathMatch:'full'},
  {path:'registrar-voluntario',component:RegistrarVoluntarioComponent},
  {path:'editar-voluntario/:idVoluntario',component:RegistrarVoluntarioComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
