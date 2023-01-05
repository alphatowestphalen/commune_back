package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


import com.example.demo.model.Pere;
import com.example.demo.repository.PereRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PereController {
	
	@Autowired
	PereRepository pereRepository;
	
	@PostMapping("/pere")
	  public ResponseEntity<Pere> createPere(@RequestBody Pere pere )
	  {
	    try {
	    	Pere _pere = pereRepository
	          .save(new Pere(pere.getNomPere(), pere.getPrenomsPere(), pere.getDatenaissPere(), pere.getLieuNaissPere(), pere.getProfessionPere(), pere.getAdressePere() ));
	      return new ResponseEntity<>(_pere, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@GetMapping("/peres")
	  public ResponseEntity<List<Pere>> getAllPeres() {
	    try {
	      List<Pere> peres = new ArrayList<Pere>();

	     	      
	      pereRepository.findAll().forEach(peres::add);
	      if (peres.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

	      return new ResponseEntity<>(peres, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@GetMapping("/peres/{id}")
	  public ResponseEntity<Pere> getPereById(@PathVariable("id") long id) 
	{
	    Optional<Pere> pereData = pereRepository.findById(id);

	    if (pereData.isPresent()) {
	      return new ResponseEntity<>(pereData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@PutMapping("/peres/{id}")
	  public ResponseEntity<Pere> updatePere(@PathVariable("id") long id, @RequestBody Pere pere) {
	    Optional<Pere> pereData = pereRepository.findById(id);

	    if (pereData.isPresent()) {
	    	Pere _pere = pereData.get();
	    	_pere.setNomPere(pere.getNomPere());
	    	_pere.setPrenomsPere(pere.getPrenomsPere());
	    	_pere.setDatenaissPere(pere.getDatenaissPere());
	    	_pere.setLieuNaissPere(pere.getLieuNaissPere());
	    	_pere.setProfessionPere(pere.getProfessionPere());
	    	_pere.setAdressePere(pere.getAdressePere());

	      return new ResponseEntity<>(pereRepository.save(_pere), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@DeleteMapping("/peres/{id}")
	  public ResponseEntity<HttpStatus> deletePere(@PathVariable("id") long id) {
	    try {
	    	pereRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
