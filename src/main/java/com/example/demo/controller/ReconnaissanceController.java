package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Reconnaissance;
import com.example.demo.repository.PremierCopieRepository;
import com.example.demo.repository.ReconnaissanceRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/reconnaissances")
public class ReconnaissanceController {

	@Autowired
	PremierCopieRepository premierCopieRepository;
	@Autowired
	ReconnaissanceRepository reconnaissanceRepository;
	
	@GetMapping
	  public ResponseEntity<List<Reconnaissance>> getAllReconnaissances() {
	    List<Reconnaissance> reconnaissances = new ArrayList<Reconnaissance>();

	    reconnaissanceRepository.findAll().forEach(reconnaissances::add);

	    if (reconnaissances.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    return new ResponseEntity<>(reconnaissances, HttpStatus.OK);
	  }
	
	
	@GetMapping("/{id}")
	  public ResponseEntity<Reconnaissance> getReconnaissanceById(@PathVariable(value = "id") Long id) {
		Reconnaissance reconnaissance = reconnaissanceRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Reconnaissance with id = " + id));

	    return new ResponseEntity<>(reconnaissance, HttpStatus.OK);
	  }
	
	
	
}
