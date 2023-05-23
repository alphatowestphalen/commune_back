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

import com.example.demo.model.Adoption;
import com.example.demo.model.PremierCopie;
import com.example.demo.repository.AdoptionRepository;
import com.example.demo.repository.PremierCopieRepository;
import com.example.demo.request.AdoptionRequest;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/adoptions")

public class AdoptionController {

	@Autowired
	PremierCopieRepository premierCopieRepository;
	@Autowired
	AdoptionRepository adoptionRepository;
	
	@GetMapping
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
	  public ResponseEntity<Map<String, Object>> getAllAdoptions(
			     @RequestParam(required = false) String title,
			        @RequestParam(defaultValue = "0") int page,
			        @RequestParam(defaultValue = "10") int size) {
	 	  
	    try {
	    	 List<Adoption> adoptions = new ArrayList<Adoption>();
	        Pageable paging = PageRequest.of(page, size);
	        
	        Page<Adoption> pageadoption;
	        pageadoption = adoptionRepository.findAll(paging);

	        if (pageadoption.hasContent())
	        	 adoptions = pageadoption.getContent();
	        
	             Map<String, Object> response = new HashMap<>();
	             response.put("adoption", adoptions);
	             response.put("currentPage", pageadoption.getNumber());
	             response.put("totalItems", pageadoption.getTotalElements());
	             response.put("totalPages", pageadoption.getTotalPages());
	      return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	
	@GetMapping("/{id}")
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
	  public ResponseEntity<Adoption> getAdoptionById(@PathVariable(value = "id") Long id) {
		Adoption adoption = adoptionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found Jugement with id = " + id));
;
	    return new ResponseEntity<>(adoption, HttpStatus.OK);
	  }
	
	@PostMapping("/{IdPremierCopie}")
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
	  public ResponseEntity<Adoption> addAdoption(@PathVariable(value = "IdPremierCopie") String IdPremierCopie, @RequestBody AdoptionRequest adoptionRequest) 
	{
		try {
			PremierCopie premierCopie = premierCopieRepository.findByIdPremierCopie(IdPremierCopie);
			
			Adoption adoption = new Adoption(
					adoptionRequest.getParentAdoptif(),
					adoptionRequest.getDateAdoption(),
					adoptionRequest.getHeureAdoption(),
					adoptionRequest.getNumAdoption(),
					adoptionRequest.getCreatedDate(),
					adoptionRequest.getPereAdoptif(),
					adoptionRequest.getMereAdoptif(),
					premierCopie
					);
			
			adoptionRepository.save(adoption);
			return new ResponseEntity<>(adoption, HttpStatus.OK);
		}
		catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }	
			
		
	}
	
	@PutMapping("/{id}")
	
	//@PreAuthorize(" hasRole('MAIRE')")
	public ResponseEntity<Adoption> updateAdoption(@PathVariable(value = "id") Long id, @RequestBody AdoptionRequest adoptionRequest)
	{
		Adoption adoption = adoptionRepository.findById(id)
		        .orElseThrow(() -> new ResourceNotFoundException("Not found Adoption with id = " + id));
		
		PremierCopie premierCopie = premierCopieRepository.findByIdPremierCopie(adoption.getPremierecopie().getIdPremierCopie());
		
		adoption.setParentAdoptif(adoptionRequest.getParentAdoptif());
		adoption.setDateAdoption(adoptionRequest.getDateAdoption());
		adoption.setHeureAdoption(adoptionRequest.getHeureAdoption());
		adoption.setNumAdoption(adoptionRequest.getNumAdoption());
		adoption.setPereAdoptif(adoptionRequest.getPereAdoptif());
		adoption.setMereAdoptif(adoptionRequest.getMereAdoptif());
		adoption.setPremierecopie(premierCopie);
		
		
		adoptionRepository.save(adoption);
		
		return new ResponseEntity<>(adoption, HttpStatus.OK);	}

	
	@DeleteMapping("/{id}")
//	 @PreAuthorize(" hasRole('MAIRE')")
	  public ResponseEntity<HttpStatus> deleteAdoption(@PathVariable("id") long id) 
	{
		try {
			adoptionRepository.deleteById(id);

		    return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	    
	  }
	
}
