import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal, { SweetAlertIcon } from 'sweetalert2';
import { VoluntarioService } from '../Servicios/voluntario.service';
import { Voluntario } from '../voluntario';


@Component({
  selector: 'app-lista-voluntarios',
  templateUrl: './lista-voluntarios.component.html',
  styleUrls: ['./lista-voluntarios.component.css']
})
export class ListaVoluntariosComponent implements OnInit {

  voluntarios: Voluntario[];
  constructor(private voluntarioServicio: VoluntarioService, private route: Router) { }

  ngOnInit(): void {
    this.obtenerVoluntarios();
  }
  private obtenerVoluntarios() {
    this.voluntarioServicio.obtenerListaVoluntarios().subscribe(dato => {
      this.voluntarios = dato;
    });
  }
  onEdit(id: any) {
    this.route.navigate(['/editar-voluntario/', id])
  }
  onRemove(id: any) {
    this.alertQuestion('¿Seguro que desea eliminar este registro?', 'si se elimina no se recuperará', 'question', id);
  }
  alertQuestion(title: string, detail: string, status: SweetAlertIcon, help?: any) {
    Swal.fire({
      title: title,
      text: detail,
      icon: status,
      showCancelButton: true,
      confirmButtonText: 'Sí',
      cancelButtonText: 'No',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        this.deleteItem(Number.parseInt(help as string));
      }
    })
  }

  deleteItem(id:number){
    this.voluntarioServicio.deleteVoluntario(id).subscribe(response=>{
        if(response !=null){
           this.alert('Hecho','Voluntario  eliminado','success');
           this.obtenerVoluntarios();
        }else{
          this.alert('Error','Error al  eliminar voluntario','error');
        }
    });
  }
  alert(title: string, detail: string, status: SweetAlertIcon) {
    Swal.fire(
      title,
      detail,
      status
    );
    //setTimeout(()=>{swal.close();},2000)
  }
}
