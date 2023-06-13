package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ActeCelibataire;
import com.example.demo.model.Adoption;
import com.example.demo.model.PremierCopie;
import com.example.demo.repository.ActeCelibataireRepository;
import com.example.demo.repository.PremierCopieRepository;
import com.example.demo.request.ActeCelibataireRequest;
import com.example.demo.request.AdoptionRequest;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/celibataires")
public class ActeCelibataireController {
	
	@Autowired
	ActeCelibataireRepository acteCelibataireRepository;
	@Autowired
	PremierCopieRepository premierCopieRepository;
	
	@GetMapping
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
	  public ResponseEntity<Map<String, Object>> getAllActeCelibataire(
			     @RequestParam(required = false) String title,
			        @RequestParam(defaultValue = "0") int page,
			        @RequestParam(defaultValue = "10") int size) {
	 	  
	    try {
	    	 List<ActeCelibataire> acteCelibataires = new ArrayList<ActeCelibataire>();
	        Pageable paging = PageRequest.of(page, size);
	        
	        Page<ActeCelibataire> pageacteCelibataire;
	        pageacteCelibataire = acteCelibataireRepository.findAll(paging);

	        if (pageacteCelibataire.hasContent())
	        	 acteCelibataires = pageacteCelibataire.getContent();
	        
	             Map<String, Object> response = new HashMap<>();
	             response.put("acteCelibataire", acteCelibataires);
	             response.put("currentPage", pageacteCelibataire.getNumber());
	             response.put("totalItems", pageacteCelibataire.getTotalElements());
	             response.put("totalPages", pageacteCelibataire.getTotalPages());
	      return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@PostMapping("/{IdPremierCopie}")
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
	  public ResponseEntity<ActeCelibataire> addActeCelibataire(@PathVariable(value = "IdPremierCopie") String IdPremierCopie, @RequestBody ActeCelibataireRequest acteCelibataireRequest) 
	{
		try {
			PremierCopie premierCopie = premierCopieRepository.findByIdPremierCopie(IdPremierCopie);
			
			ActeCelibataire acteCelibataire = new ActeCelibataire(
					acteCelibataireRequest.getIdActeCelibataire(),
					premierCopie,
					acteCelibataireRequest.getNumCin(),
					acteCelibataireRequest.getDateCin(),
					acteCelibataireRequest.getLieuCin(),
					acteCelibataireRequest.getDateDelivrance()
					
					);
			
			acteCelibataireRepository.save(acteCelibataire);
			return new ResponseEntity<>(acteCelibataire, HttpStatus.OK);
		}
		catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }	
			
		
	}
	  

}
