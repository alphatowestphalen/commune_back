package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


import com.example.demo.model.Poste;
import com.example.demo.repository.PosteRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/postes")
public class PosteController {

	@Autowired
	PosteRepository posteRepository;
	
	@PostMapping	
	  public ResponseEntity<Poste> createPoste (@RequestBody @Valid Poste posteRequest )
	  {
	    
		Poste poste = posteRepository.save(posteRequest);
	      return new ResponseEntity<>(poste, HttpStatus.CREATED);
	    
	  }
	

	@GetMapping
	  public ResponseEntity<List<Poste>> getAllPostes() {
	    try {
	      List<Poste> postes = posteRepository.findAll();

	      if (postes.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(postes, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@GetMapping("/{id}")
	  public ResponseEntity<Poste> getByIdPoste(@PathVariable("id") Long id)
	{
		Poste poste = posteRepository.findById(id).get();
	    	
	    	if (poste != null) {
	  	      return new ResponseEntity<>(poste, HttpStatus.OK);
	  	    } else {
	  	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  	    }
	  }
	
	@PutMapping("/{id}")
	public ResponseEntity<Poste> updatePoste(@PathVariable("id") Long id, @RequestBody @Valid Poste posteRequest) 
	{
		Poste poste = posteRepository.findById(id).get();
		if(poste != null)
		{
			poste.getIdPoste();
			poste.setNomPoste(posteRequest.getNomPoste());
			poste.setDescriptionPoste(posteRequest.getDescriptionPoste());
			
			posteRepository.save(poste);
			
			return new ResponseEntity<>(poste, HttpStatus.OK);
		}
		else
		{
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus>  supprPoste(@PathVariable("id") long id) {	
		try {
			posteRepository.deleteById(id);			 
	      return new ResponseEntity<>(HttpStatus.OK);
	      
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
