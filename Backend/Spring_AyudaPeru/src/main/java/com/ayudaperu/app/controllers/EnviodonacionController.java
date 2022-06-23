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
import com.ayudaperu.app.models.Enviodonacion;
import com.ayudaperu.app.repository.EnviodonacionRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:4200/")
public class EnviodonacionController {
	@Autowired
	private EnviodonacionRepository repository;
	
	@GetMapping("/enviodonaciones")
	public List<Enviodonacion> listarEnviodonaciones(){
		return repository.findAll();
	}
	
	@PostMapping("/enviodonacion")
	public Enviodonacion guardarEnviodonacion(@RequestBody  Enviodonacion enviodonacion) {
		return repository.save(enviodonacion);
	}
	
	@GetMapping("/enviodonaciones/{id}")
	public ResponseEntity<Enviodonacion>obtenerEnviodonacion(@PathVariable Long id){
		Enviodonacion enviodonacion=repository.findById(id)
			.orElseThrow(()->new ResourceNotFoundException("No existe el envio con el Id: "+id));
		return ResponseEntity.ok(enviodonacion);
	}
	
	@DeleteMapping("/enviodonacion/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarEnviodonacion(@PathVariable Long id){
		Enviodonacion enviodonacion=repository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("No existe el envio con el Id: "+id));
		repository.delete(enviodonacion);
		Map<String, Boolean> respuesta= new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}
}
