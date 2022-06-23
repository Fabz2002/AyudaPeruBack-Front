package com.ayudaperu.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayudaperu.app.exceptions.ResourceNotFoundException;
import com.ayudaperu.app.models.DetalleDonacion;
import com.ayudaperu.app.models.Donacion;
import com.ayudaperu.app.models.Tipodnm;
import com.ayudaperu.app.repository.DetalleDonacionRepository;
import com.ayudaperu.app.repository.DonacionNMRepository;
import com.ayudaperu.app.repository.DonacionRepository;
import com.ayudaperu.app.viewmodels.DonacionDetalleViewModel;
import com.ayudaperu.app.viewmodels.DonacionViewModel;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:4200/")
public class DonacionController {
	
	@Autowired
	private DonacionRepository repository;
	
	@Autowired
	private DetalleDonacionRepository drepository;
	@Autowired
	private DonacionNMRepository  donacionnmRepository;
	
	//Listar todas las donaciones
	@GetMapping("/donaciones")
	public List<Donacion> listarDonaciones(){
		return repository.findAll();
	}
	
	@GetMapping("/donacionesnm")
	public List<Tipodnm> listarDonacionesnm(){
		return donacionnmRepository.findAll();
	}
	
	@GetMapping("/detalledonacion/{tipoDonacion}")
	public List<DetalleDonacion> listarDetalledonacion(@PathVariable String tipoDonacion){
		List<DetalleDonacion> list = drepository.findAll();
		if(!tipoDonacion.equals("a")) {
		   return   list.stream().filter(p->p.getDonacion().getTipodonacion().equals(tipoDonacion)).toList();
		}
		return  list;
	}
	
   
	
	//Guardar y Editar donaciones
		@PostMapping("/guardarDonacion")
		public Donacion guardarDonacion(@RequestBody DonacionViewModel donacion) {
			Donacion mld= new Donacion();
			mld.setNombre(donacion.getNombre());
			mld.setApellido(donacion.getApellido());
			mld.setTipodocumento(donacion.getTipodocumento());
			mld.setTipodonacion(donacion.getTipodonacion());
			mld.setNumerodoc(donacion.getNumerodoc());
			mld.setEmail(donacion.getEmail());
			mld.setPais(donacion.getPais());
			mld.setDireccion(donacion.getDireccion());
			mld.setTelefono(donacion.getTelefono());
			mld.setCelular(donacion.getCelular());
			mld.setFecha(donacion.getFecha());
			
			Donacion res=  repository.save(mld);
			for(int i= 0; i< donacion.getItems().size();i++) {
				DetalleDonacion detalleDonacion= new DetalleDonacion();
				DonacionDetalleViewModel item= donacion.getItems().get(i);
				detalleDonacion.setTipodnm(item.getTipodnm());
				detalleDonacion.setDonacion(res);
				detalleDonacion.setMonto(item.getMonto());
				detalleDonacion.setNumtarjeta(item.getNumtarjeta());
				detalleDonacion.setMesexpira(item.getMesexpira());
				detalleDonacion.setAnioexpira(item.getAnioexpira());
				detalleDonacion.setNomtarjeta(item.getNomtarjeta());
				detalleDonacion.setDescripcion(item.getDescripcion());
				detalleDonacion.setCantidad(item.getCantidad());
				detalleDonacion.setValorunitario(item.getValorunitario());
				detalleDonacion.setTotal(item.getTotal());
				drepository.save(detalleDonacion);
			}
			return res;
		}
	
	
	//Método para buscar donacion
	@GetMapping("/donaciones/{id}")
	public ResponseEntity<Donacion>obtenerDonacion(@PathVariable Long id){
		Donacion donacion = repository.findById(id)
			.orElseThrow(()->new ResourceNotFoundException("No existe la donación con el Id: " + id));
		return ResponseEntity.ok(donacion);
	}
	
	//Método para eliminar donacion
	@DeleteMapping("/donacion/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarDonacion(@PathVariable Long id){
		Donacion donacion = repository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("No existe la donación con el Id: "+id));
		repository.delete(donacion);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}
}