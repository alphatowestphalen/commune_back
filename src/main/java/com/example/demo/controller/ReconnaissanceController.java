package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	 @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
	  public ResponseEntity<Map<String, Object>> getAllReconnaissances(
			     @RequestParam(required = false) String title,
			        @RequestParam(defaultValue = "0") int page,
			        @RequestParam(defaultValue = "3") int size) {
		try {
			
			 List<Reconnaissance> reconnaissances = new ArrayList<Reconnaissance>();
		        Pageable paging = PageRequest.of(page, size);
		        
		        Page<Reconnaissance> pagereconnaissance;
		        pagereconnaissance = reconnaissanceRepository.findAll(paging);

		        if (pagereconnaissance.hasContent())
		        	
		        	reconnaissances = pagereconnaissance.getContent();

		             Map<String, Object> response = new HashMap<>();
		             response.put("reconnaissance", reconnaissances);
		             response.put("currentPage", pagereconnaissance.getNumber());
		             response.put("totalItems", pagereconnaissance.getTotalElements());
		             response.put("totalPages", pagereconnaissance.getTotalPages());
		      return new ResponseEntity<>(response, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }
	
	
	@GetMapping("/{id}")
	 @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
	  public ResponseEntity<Reconnaissance> getReconnaissanceById(@PathVariable(value = "id") Long id) {
		Reconnaissance reconnaissance = reconnaissanceRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Reconnaissance with id = " + id));

	    return new ResponseEntity<>(reconnaissance, HttpStatus.OK);
	  }
	
	@PostMapping("/{IdPremierCopie}")
	 @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
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
	 @PreAuthorize(" hasRole('MAIRE')")
	public ResponseEntity<Reconnaissance> updateReconnaissance(@PathVariable(value = "id") Long id, @RequestBody ReconnaissanceRequest reconnaissanceRequest)
	{
		Reconnaissance reconnaissance = reconnaissanceRepository.findById(id)
		        .orElseThrow(() -> new ResourceNotFoundException("Not found Reconnaissance with id = " + id));
		
		PremierCopie premierCopie = premierCopieRepository.findById(reconnaissance.getPremierecopie().getIdPremierCopie()).get();
		
		reconnaissance.setDateDeclaration(reconnaissanceRequest.getDateDeclaration());
		reconnaissance.setHeureDeclaration(reconnaissanceRequest.getHeureDeclaration());
		reconnaissance.setInfoPersonDeclarant(reconnaissanceRequest.getInfoPersonDeclarant());
		reconnaissance.setPremierecopie(premierCopie);
		
		reconnaissanceRepository.save(reconnaissance);
		
		return new ResponseEntity<>(reconnaissance, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	 @PreAuthorize(" hasRole('MAIRE')")
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
