package com.ayudaperu.app.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayudaperu.app.models.Organizacion;
import com.ayudaperu.app.repository.OrganizacionRepository;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:4200/")
public class OrganizacionController {
	@Autowired
	private OrganizacionRepository repository;
	
	@GetMapping("/organizaciones")
	public List<Organizacion> listarOrganizaciones(){
		return repository.findAll();
	}
}
