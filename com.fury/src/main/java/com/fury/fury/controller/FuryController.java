package com.fury.fury.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fury.fury.model.Fury;
import com.fury.fury.repository.FuryRepository;

@RestController
@RequestMapping({"/api/controller"})

public class FuryController {
	
	private FuryRepository repository;
	
	public FuryController(FuryRepository repository) {
		this.repository = repository;
	}
	//Lisar Todos
	@GetMapping
	//htpp/localhost:8090/api/controller
	public List findAll() {
		return repository.findAll();
		
	}
	
	//find by id
	@GetMapping ( value = "{id}")
	public ResponseEntity<Fury> findById(@PathVariable Long id){
		return repository.findById(id)
		.map(mapping -> ResponseEntity.ok().body(mapping))
		.orElse(ResponseEntity.notFound().build());
	}
	
	//Create 
	@PutMapping
	public Fury create(@RequestBody Fury fury) {
		return repository.save(fury);
	
	}
	
	//update
	@PutMapping (value = "{id}")
	public ResponseEntity<Fury> update(@PathVariable Long id, @RequestBody Fury fury){
		return repository.findById(id)
		.map(mapping ->{
			mapping.setName(fury.getName());
			mapping.setEmail(fury.getEmail());
			mapping.setPhone(fury.getPhone());
			
		Fury update	= repository.save(mapping);
		
		return(ResponseEntity.ok().body(update));
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping
	public ResponseEntity <?> delete(@PathVariable Long id){
		return repository.findById(id)
		.map(mapping ->{
		repository.deleteById(id);
		return(ResponseEntity.ok().body("DELETADO COM SUCESSO"));
		}).orElse(ResponseEntity.notFound().build());
		
	}
	
	
}
