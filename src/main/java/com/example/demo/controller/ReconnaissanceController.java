package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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

import com.example.demo.model.PremierCopie;
import com.example.demo.model.Reconnaissance;
import com.example.demo.repository.PremierCopieRepository;
import com.example.demo.repository.ReconnaissanceRepository;
import com.example.demo.request.ReconnaissanceRequest;

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
		try {
			List<Reconnaissance> reconnaissances =  reconnaissanceRepository.findAll();

		    if (reconnaissances.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }

		    return new ResponseEntity<>(reconnaissances, HttpStatus.OK);
		}
		catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }	
	    
	  }
	
	
	@GetMapping("/{id}")
	  public ResponseEntity<Reconnaissance> getReconnaissanceById(@PathVariable(value = "id") Long id) {
		Reconnaissance reconnaissance = reconnaissanceRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Reconnaissance with id = " + id));

	    return new ResponseEntity<>(reconnaissance, HttpStatus.OK);
	  }
	
	@PostMapping("/{IdPremierCopie}")
	  public ResponseEntity<Reconnaissance> addReconnaissance(@PathVariable(value = "IdPremierCopie") Long IdPremierCopie, @RequestBody ReconnaissanceRequest reconnaissanceRequest) 
	{
		try {
			PremierCopie premierCopie = premierCopieRepository.findById(IdPremierCopie).get();
			
			Reconnaissance reconnaissance = new Reconnaissance(
					reconnaissanceRequest.getDateDeclaration(),
					reconnaissanceRequest.getHeureDeclaration(),
					reconnaissanceRequest.getInfoPersonDeclarant(),
					reconnaissanceRequest.getCreatedDate(),
					premierCopie
					);
			reconnaissanceRepository.save(reconnaissance);
			return new ResponseEntity<>(reconnaissance, HttpStatus.OK);
		}
		catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }	
			
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Reconnaissance> updateReconnaissance(@PathVariable(value = "id") Long id, @RequestBody Reconnaissance reconnaissanceRequest)
	{
		Reconnaissance reconnaissance = reconnaissanceRepository.findById(id)
		        .orElseThrow(() -> new ResourceNotFoundException("Not found Reconnaissance with id = " + id));
		
		PremierCopie premierCopie = premierCopieRepository.findById(reconnaissanceRequest.getPremierCopie().getIdPremierCopie()).get();
		
		reconnaissance.setDateDeclaration(reconnaissanceRequest.getDateDeclaration());
		reconnaissance.setHeureDeclaration(reconnaissanceRequest.getHeureDeclaration());
		reconnaissance.setInfoPersonDeclarant(reconnaissanceRequest.getInfoPersonDeclarant());
		reconnaissance.setPremierCopie(premierCopie);
		
		reconnaissanceRepository.save(reconnaissance);
		
		return new ResponseEntity<>(reconnaissance, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	  public ResponseEntity<HttpStatus> deleteReconnaissance(@PathVariable("id") long id) 
	{
		try {
			reconnaissanceRepository.deleteById(id);

		    return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	    
	  }
	
}
