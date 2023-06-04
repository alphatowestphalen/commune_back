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


import com.example.demo.model.Jugement;
import com.example.demo.model.PremierCopie;
import com.example.demo.model.Reconnaissance;
import com.example.demo.repository.AdoptionRepository;
import com.example.demo.repository.JugementRepository;
import com.example.demo.repository.PremierCopieRepository;
import com.example.demo.request.JugementRequest;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/jugements")
public class JugementController {
	
	@Autowired
	PremierCopieRepository premierCopieRepository;
	@Autowired
	JugementRepository jugementRepository;
	
	@GetMapping
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
	  public ResponseEntity<Map<String, Object>> getAllJugements(
			   @RequestParam(required = false) String title,
		        @RequestParam(defaultValue = "0") int page,
		        @RequestParam(defaultValue = "3") int size) {
		
		try {
			  List<Jugement> jugements = new ArrayList<Jugement>();
			    Pageable paging = PageRequest.of(page, size);
			    
			    Page<Jugement> pagejugement;
		        pagejugement = jugementRepository.findAll(paging);

		        if (pagejugement.hasContent())
		        	
		        	jugements = pagejugement.getContent();

		             Map<String, Object> response = new HashMap<>();
		             response.put("jugement", jugements);
		             response.put("currentPage", pagejugement.getNumber());
		             response.put("totalItems", pagejugement.getTotalElements());
		             response.put("totalPages", pagejugement.getTotalPages());
		      return new ResponseEntity<>(response, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }

	 
	
	@GetMapping("/{id}")
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
	  public ResponseEntity<Jugement> getJugementById(@PathVariable(value = "id") Long id) {
		Jugement jugement = jugementRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Jugement with id = " + id));

	    return new ResponseEntity<>(jugement, HttpStatus.OK);
	  }
	
	@PostMapping("/{IdPremierCopie}")
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
	  public ResponseEntity<Jugement> addJugement(@PathVariable(value = "IdPremierCopie") String IdPremierCopie, 
			  @RequestBody JugementRequest jugementRequest) 
	{
		try {
			PremierCopie premierCopie = premierCopieRepository.findByIdPremierCopie(IdPremierCopie);
			
			Jugement jugement = new Jugement(
					jugementRequest.getNumJugement(),
					jugementRequest.getDecretJuridique(),
					jugementRequest.getDateDecret(),
					jugementRequest.getTypeJugement(),
					jugementRequest.getInfoChangement(),
					jugementRequest.getCreatedDate(),
					premierCopie);
			jugementRepository.save(jugement);
			return new ResponseEntity<>(jugement, HttpStatus.OK);
		}
		catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }

	}
	
	@PutMapping("/{id}")
	// @PreAuthorize(" hasRole('MAIRE')")
	public ResponseEntity<Jugement> updateJugement(@PathVariable(value = "id") Long id, 
			@RequestBody JugementRequest jugementRequest)
	{
		Jugement jugement = jugementRepository.findById(id)
		        .orElseThrow(() -> new ResourceNotFoundException("Not found Jugement with id = " + id));
		
		PremierCopie premierCopie = premierCopieRepository.findByIdPremierCopie(jugement.getPremierCopie().getIdPremierCopie());
		
		jugement.setNumJugement(jugementRequest.getNumJugement());
		jugement.setDecretJuridique(jugementRequest.getDecretJuridique());
		jugement.setDateDecret(jugementRequest.getDateDecret());
		jugement.setTypeJugement(jugementRequest.getTypeJugement());
		jugement.setInfoChangement(jugementRequest.getInfoChangement());
		jugement.setCreatedDate(jugementRequest.getCreatedDate());
		jugement.setPremierCopie(premierCopie);
		
		jugementRepository.save(jugement);
		
		return new ResponseEntity<>(jugement, HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/{id}")
	// @PreAuthorize(" hasRole('MAIRE')")
	  public ResponseEntity<HttpStatus> deleteJugement(@PathVariable("id") long id) 
	{
		try {
			jugementRepository.deleteById(id);

		    return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	    
	  }
	

}
