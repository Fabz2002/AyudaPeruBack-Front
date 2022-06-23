import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListaVoluntariosComponent } from './lista-voluntarios/lista-voluntarios.component';
import {HttpClientModule} from '@angular/common/http';
import { RegistrarVoluntarioComponent } from './registrar-voluntario/registrar-voluntario.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PaisService } from './Servicios/pais.service';
import { MainBaseComponent } from './shell/main-base/main-base.component';
import { SideBarComponent } from './shell/side-bar/side-bar.component';
import { HeaderComponent } from './shell/header/header.component';

@NgModule({
  declarations: [
    AppComponent,
    ListaVoluntariosComponent,
    RegistrarVoluntarioComponent,
    MainBaseComponent,
    SideBarComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [PaisService],
  bootstrap: [AppComponent]
})
export class AppModule { }
