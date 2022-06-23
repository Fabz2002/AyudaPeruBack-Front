import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { PaisService } from '../Servicios/pais.service';
import { Pais, Voluntario } from '../voluntario';
import swal, { SweetAlertIcon } from 'sweetalert2';
import { VoluntarioService } from '../Servicios/voluntario.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-registrar-voluntario',
  templateUrl: './registrar-voluntario.component.html',
  styleUrls: ['./registrar-voluntario.component.css']
})
export class RegistrarVoluntarioComponent implements OnInit {

  voluntario: Voluntario = new Voluntario();
  paises: Pais[] = [];
  idpais: number;
  form: FormGroup;
  submitted: boolean = false;
  idVoluntario: number = 0;
  constructor(private servicePais: PaisService,
    private formBuilder: FormBuilder,
    private voluntarioServico: VoluntarioService,
    private router: Router, private routeActived: ActivatedRoute) { }

  ngOnInit(): void {
    this.routeActived.params.subscribe((param) => {
      let id = param['idVoluntario'] as string;
      if (id != null) {
        this.idVoluntario = Number.parseInt(id);
        this.obtenerVoluntario(this.idVoluntario);
      }
    });
    this.form = new FormGroup({
      id: new FormControl('', []),
      idpais: new FormControl('', [Validators.required]),
      nombre: new FormControl('', [Validators.required, Validators.maxLength(50)]),
      apellido: new FormControl('', [Validators.required, Validators.maxLength(50)]),
      direccion: new FormControl('', [Validators.required, Validators.maxLength(50)]),
      telefono: new FormControl('', [Validators.required, Validators.maxLength(10)]),
      email: new FormControl('', [Validators.required, Validators.maxLength(20)]),
      numeroDocumento: new FormControl('', [Validators.required, Validators.maxLength(12)]),
      tipoDocumento: new FormControl('', [Validators.required, Validators.maxLength(9)]),
      estado: new FormControl('', [Validators.required])
    });
    this.obtenerPais();

  }
  obtenerPais() {
    this.servicePais.obtenerListaPaises().subscribe(response => {
      this.paises = response;
    });
  }
  obtenerVoluntario(idVoluntario:number) {
    this.voluntarioServico.obtenerVoluntarioPorId(idVoluntario).subscribe(response=>{
        if(response != null){
            this.llenarValoresVoluntario(true,response);
        }
    });
  }
  guardarVoluntario() {
    this.submitted = true;
    if (this.form.valid) {
      this.llenarValoresVoluntario();
      this.voluntarioServico.registrarVoluntario(this.voluntario).subscribe(result => {
        if (result != null) {
          this.alert('HECHO', 'Voluntario registrado exitosamente', 'success');
          this.router.navigate(['/voluntarios']);
          this.voluntario = new Voluntario();
        } else {
          this.alert('ERROR', 'Error al guardar  voluntario', 'error');
        }
      });
    }
  }

  llenarValoresVoluntario(isAutoCompleted:boolean=false,voluntario?:Voluntario) {
    // obtiene el valor  de la caja de texto nombre y llena  a la clase 
    if(isAutoCompleted){
      this.form.get('id')?.setValue(voluntario?.id);
      this.form.get('nombre')?.setValue(voluntario?.nombre);
      this.form.get('apellido')?.setValue(voluntario?.apellido);
      this.form.get('tipoDocumento')?.setValue(voluntario?.tipoDocumento);
      this.form.get('numeroDocumento')?.setValue(voluntario?.numeroDocumento);
      this.form.get('idpais')?.setValue(voluntario?.pais?.idpais);
      this.form.get('direccion')?.setValue(voluntario?.direccion);
      this.form.get('telefono')?.setValue(voluntario?.telefono);
      this.form.get('email')?.setValue(voluntario?.email);
      this.form.get('estado')?.setValue(voluntario?.estado);
      return;
    }
    this.voluntario.id = this.form.get('id')?.value as number;
    this.voluntario.nombre = this.form.get('nombre')?.value as string;
    this.voluntario.apellido = this.form.get('apellido')?.value as string;
    this.voluntario.tipoDocumento = this.form.get('tipoDocumento')?.value as string;
    this.voluntario.numeroDocumento = this.form.get('numeroDocumento')?.value as string;
    let idpais = this.form.get('idpais')?.value as number;
    this.voluntario.pais = this.paises.find(p => p.idpais == idpais);
    this.voluntario.direccion = this.form.get('direccion')?.value as string;
    this.voluntario.telefono = this.form.get('telefono')?.value as string;
    this.voluntario.email = this.form.get('email')?.value as string;
    this.voluntario.estado = this.form.get('estado')?.value as boolean;
  }
  alert(title: string, detail: string, status: SweetAlertIcon) {
    swal.fire(
      title,
      detail,
      status
    );
    //setTimeout(()=>{swal.close();},2000)
  }
}
