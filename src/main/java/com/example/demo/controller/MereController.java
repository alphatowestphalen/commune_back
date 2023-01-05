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

import com.example.demo.model.Mere;
import com.example.demo.repository.MereRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MereController {
	
	@Autowired
	MereRepository mereRepository;
	
	@PostMapping("/mere")
	  public ResponseEntity<Mere> createMere(@RequestBody Mere mere )
	  {
	    try {
	    	Mere _mere = mereRepository
	          .save(new Mere(mere.getNomMere(), mere.getPrenomsMere(), mere.getDatenaissMere(), mere.getLieuNaissMere(), mere.getProfessionMere(), mere.getAdresseMere() ));
	      return new ResponseEntity<>(_mere, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@GetMapping("/meres")
	  public ResponseEntity<List<Mere>> getAllMeres() {
	    try {
	      List<Mere> meres = new ArrayList<Mere>();

	     	      
	      mereRepository.findAll().forEach(meres::add);
	      if (meres.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

	      return new ResponseEntity<>(meres, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@GetMapping("/meres/{id}")
	  public ResponseEntity<Mere> getMereById(@PathVariable("id") long id) 
	{
	    Optional<Mere> mereData = mereRepository.findById(id);

	    if (mereData.isPresent()) {
	      return new ResponseEntity<>(mereData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@PutMapping("/meres/{id}")
	  public ResponseEntity<Mere> updateMere(@PathVariable("id") long id, @RequestBody Mere mere) {
	    Optional<Mere> mereData = mereRepository.findById(id);

	    if (mereData.isPresent()) {
	    	Mere _mere = mereData.get();
	    	_mere.setNomMere(mere.getNomMere());
	    	_mere.setPrenomsMere(mere.getPrenomsMere());
	    	_mere.setDatenaissMere(mere.getDatenaissMere());
	    	_mere.setLieuNaissMere(mere.getLieuNaissMere());
	    	_mere.setProfessionMere(mere.getProfessionMere());
	    	_mere.setAdresseMere(mere.getAdresseMere());

	      return new ResponseEntity<>(mereRepository.save(_mere), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@DeleteMapping("/meres/{id}")
	  public ResponseEntity<HttpStatus> deleteMere(@PathVariable("id") long id) {
	    try {
	    	mereRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }


}
