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
import com.ayudaperu.app.models.Voluntario;
import com.ayudaperu.app.repository.VoluntarioRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:4200/")
public class VoluntarioController {
	
	@Autowired
	private VoluntarioRepository repository;
	
	//Listar todos los empleados
	@GetMapping("/voluntarios")
	public List<Voluntario> listarVoluntarios(){
		return repository.findAll();
	}
	//Guardar y Editar empleados
	@PostMapping("/voluntario")
	public Voluntario guardarVoluntario(@RequestBody Voluntario voluntario) {
		return repository.save(voluntario);
	}
	
	//Método para buscar voluntario
	@GetMapping("/voluntarios/{id}")
	public ResponseEntity<Voluntario>obtenerVoluntario(@PathVariable Long id){
		Voluntario voluntario=repository.findById(id)
			.orElseThrow(()->new ResourceNotFoundException("No existe el voluntario con el Id: "+id));
		return ResponseEntity.ok(voluntario);
	}
	
	//Método para eliminar voluntario
	@DeleteMapping("/voluntario/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarVoluntario(@PathVariable Long id){
		Voluntario voluntario=repository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("No existe el voluntario con el Id: "+id));
		repository.delete(voluntario);
		Map<String, Boolean> respuesta= new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}
	
}
