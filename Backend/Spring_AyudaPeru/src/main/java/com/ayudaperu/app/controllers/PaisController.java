package com.ayudaperu.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayudaperu.app.models.Pais;
import com.ayudaperu.app.repository.PaisRepository;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:4200/")
public class PaisController {
	@Autowired
	private PaisRepository repository;
	
	//Listar todos los paises
	@GetMapping("/paises")
	public List<Pais> listarPaises(){
		return repository.findAll();
	}

}
