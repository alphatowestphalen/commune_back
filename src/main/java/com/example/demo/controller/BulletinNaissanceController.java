package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BulletinNaissance;
import com.example.demo.repository.BulletinNaissanceRepository;



@CrossOrigin("*")
@RestController
@RequestMapping("/api/bulletinNaissances")
public class BulletinNaissanceController {

	@Autowired
	BulletinNaissanceRepository bulletinNaissanceRepository;
	
	@PostMapping
	public ResponseEntity<BulletinNaissance> addBulletinNaissance(@RequestBody BulletinNaissance bulletinNaissance) 
	{
		try {
			BulletinNaissance bulletin = bulletinNaissanceRepository.save(bulletinNaissance);
			return new ResponseEntity<>(bulletin, HttpStatus.CREATED);
		    
		}
		catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@GetMapping("/{id}")
	  public ResponseEntity<BulletinNaissance> getBulletinNaissanceById(@PathVariable(value = "id") Long id) {
		BulletinNaissance bulletinNaissance = bulletinNaissanceRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Bulletin de Naissance with id = " + id));

	    return new ResponseEntity<>(bulletinNaissance, HttpStatus.OK);
	  }
	  

	 @GetMapping("/numcopie/{numCopie}")
	 public ResponseEntity<BulletinNaissance> getBulletinNaissanceByNumCopie(@PathVariable(value = "numCopie" ) String idPremierCopie) 
	 {
		BulletinNaissance bulletinNaissance = bulletinNaissanceRepository.findByIdPremierCopie(idPremierCopie);
		
	    return new ResponseEntity<>(bulletinNaissance, HttpStatus.OK);
	 }


	@GetMapping()
	public ResponseEntity<Map<String, Object>> getAllBulletinNaissances(
	@RequestParam(defaultValue = "0") int page,
	@RequestParam(defaultValue = "10") int size)
	{
	try {

		List<BulletinNaissance> bulletin = new ArrayList<BulletinNaissance>();
		Pageable paging = PageRequest.of(page, size);

		Page<BulletinNaissance> bulletinNaiss;

		bulletinNaiss = bulletinNaissanceRepository.findAll(paging);


		bulletin = bulletinNaiss.getContent();

		Map<String, Object> response = new HashMap<>();
		response.put("BulletinNaiss", bulletin);
		response.put("currentPage", bulletinNaiss.getNumber());
		response.put("length", bulletinNaiss.getTotalElements());
		response.put("totalPages", bulletinNaiss.getTotalPages());

		
	   return new ResponseEntity<>(response, HttpStatus.OK);
	   }
	    catch (Exception e) {
	   return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	   }

	}

	
	@PutMapping("/{id}")
	public ResponseEntity<BulletinNaissance> updateBulletinNaissance(@PathVariable(value = "id") Long id,@RequestBody BulletinNaissance bulletinNaissance)
	{
		try {
			BulletinNaissance bulletin = bulletinNaissanceRepository.findById(id)
			        .orElseThrow(() -> new ResourceNotFoundException("Not found Acte de décès with id = " + id));
			
			bulletin.setIdPremierCopie(bulletinNaissance.getIdPremierCopie());
			bulletin.setNomPersonne(bulletinNaissance.getNomPersonne());
			bulletin.setPrenomsPersonne(bulletinNaissance.getPrenomsPersonne());
			bulletin.setDateNaissPersonne(bulletinNaissance.getDateNaissPersonne());
			bulletin.setLieuNaissPersonne(bulletinNaissance.getLieuNaissPersonne());
			bulletin.setNomPere(bulletinNaissance.getNomPere());
			bulletin.setPrenomsPere(bulletinNaissance.getPrenomsPere());
			bulletin.setNomMere(bulletinNaissance.getNomMere());
			bulletin.setPrenomsMere(bulletinNaissance.getPrenomsMere());
			bulletin.setDateCopie(bulletinNaissance.getDateCopie());
			
			bulletinNaissanceRepository.save(bulletin);
			
			return new ResponseEntity<>(bulletin, HttpStatus.OK);
		}
		catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus>  supprBulletinNaissance(@PathVariable("id") long idBulletinNaissance)
	{
		try {
			BulletinNaissance bulletin= bulletinNaissanceRepository.findById(idBulletinNaissance).get();
			
			bulletinNaissanceRepository.delete(bulletin);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
}
