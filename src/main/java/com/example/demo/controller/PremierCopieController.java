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

import com.example.demo.model.Declarant;
import com.example.demo.model.Enfant;
import com.example.demo.model.Maire;
import com.example.demo.model.Mere;
import com.example.demo.model.Pere;
import com.example.demo.model.PieceJustificative;
import com.example.demo.model.PremierCopie;
import com.example.demo.repository.DeclarantRepository;
import com.example.demo.repository.EnfantRepository;
import com.example.demo.repository.MaireRepository;
import com.example.demo.repository.MereRepository;
import com.example.demo.repository.PereRepository;
import com.example.demo.repository.PieceJustificativeRepository;
import com.example.demo.repository.PremierCopieRepository;
import com.example.demo.request.PremierCopieRequest;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/premierCopies")
public class PremierCopieController {
	
	
	@Autowired
	DeclarantRepository declarantRepository;
	@Autowired
	EnfantRepository enfantRepository;
	@Autowired
	MaireRepository maireRepository;
	@Autowired
	MereRepository mereRepository;
	@Autowired
	PereRepository pereRepository;
	
	@Autowired
	PieceJustificativeRepository pieceJustificativeRepository;
	@Autowired
	PremierCopieRepository premierCopieRepository;
	
	@PostMapping
	  public ResponseEntity<PremierCopie> createPremierCopie(@RequestBody @Valid PremierCopieRequest premierCopieRequest )
	  {
	    
	   Maire maire = maireRepository.findById(premierCopieRequest.getIdMaire()).get();
	   
	   Declarant declarant = new Declarant(
			   premierCopieRequest.getNomDeclarant(),
			   premierCopieRequest.getPrenomsDeclarant(),
			   premierCopieRequest.getDatenaissDeclarant(),
			   premierCopieRequest.getLieuNaissDeclarant(),
			   premierCopieRequest.getAdressDeclarant(),
			   premierCopieRequest.getProfessionDeclarant());	    	
	   declarantRepository.save(declarant);
			   	   
	   Mere mere = new Mere(
			   premierCopieRequest.getNomMere(), 
			   premierCopieRequest.getPrenomsMere(),
			   premierCopieRequest.getDatenaissMere(), 
			   premierCopieRequest.getLieuNaissMere(), 
			   premierCopieRequest.getProfessionMere(),
			   premierCopieRequest.getAdresseMere() );
	   mereRepository.save(mere);
	   
	   Pere pere = new Pere(
			   premierCopieRequest.getNomPere(),
			   premierCopieRequest.getPrenomsPere(), 
			   premierCopieRequest.getDatenaissPere(), 
			   premierCopieRequest.getLieuNaissPere(), 
			   premierCopieRequest.getProfessionPere(),
			   premierCopieRequest.getAdressePere() );
	   pereRepository.save(pere);
	   
	   Enfant enfant = new Enfant(
			   premierCopieRequest.getNomEnfant(),
			   premierCopieRequest.getPrenomsEnfant(),
			   premierCopieRequest.getDatenaissEnfant(),
			   premierCopieRequest.getLieunaissEnfant(),
			   premierCopieRequest.getHeurenaissEnfant(),
			   premierCopieRequest.getSexeEnfant(),
			   premierCopieRequest.getDateEnfant());
	   enfantRepository.save(enfant);
	   
	   PieceJustificative pieceJustificative = new PieceJustificative(
			   premierCopieRequest.getCertificatAccouch(), 
			   premierCopieRequest.getLivretFamille(), 
			   premierCopieRequest.getCinMere(),
			   premierCopieRequest.getCinDeclarant() );
	   pieceJustificativeRepository.save(pieceJustificative);
	   
	   PremierCopie premierCopie = new PremierCopie(
			   premierCopieRequest.getIdPremierCopie(),
			   premierCopieRequest.getDescription(),
			   premierCopieRequest.getMention(),
			   premierCopieRequest.getDatePCopie(),
			   premierCopieRequest.getDatePremierCopie(),
			   declarant,
			   maire,
			   mere,
			   pere,
			   enfant,
			   pieceJustificative
			   );
	   premierCopieRepository.save(premierCopie);
	   
	   
	   
	   return new ResponseEntity<>(premierCopie, HttpStatus.CREATED);
	    
	  }
	
	@GetMapping
	  public ResponseEntity<List<PremierCopie>> getAllPremierCopie() {
	    try {
	      List<PremierCopie> premierCopies = premierCopieRepository.findAll();

	      if (premierCopies.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(premierCopies, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@GetMapping("/{id}")
	  public ResponseEntity<PremierCopie> getByIdPremierCopie(@PathVariable("id") Long id) 
	{
		PremierCopie premierCopie = premierCopieRepository.findById(id).get();
		
	   if(premierCopie != null){		   
		      return new ResponseEntity<>(premierCopie, HttpStatus.OK);	   
	   }
	   else {
		   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }	   	     	   
	 }
	
	@PutMapping("/{IdPremierCopie}")
	public ResponseEntity<PremierCopie> updatePremierCopie(@PathVariable("IdPremierCopie") Long IdPremierCopie,
			@RequestBody PremierCopieRequest premierCopieRequest) 
	{
		try {
			PremierCopie premierCopie = premierCopieRepository.findById(IdPremierCopie).get();
			Declarant declarant  =  premierCopie.getDeclarant();
			Mere mere  =  premierCopie.getMere();
			Pere pere =  premierCopie.getPere();
			Enfant enfant =  premierCopie.getEnfant();
			PieceJustificative pieceJustificative  =  premierCopie.getPieceJustificative();
			
			Maire maire = maireRepository.findById(premierCopieRequest.getIdMaire()).get();
			
			declarant.setNomDeclarant( premierCopieRequest.getNomDeclarant());
			declarant.setPrenomsDeclarant(premierCopieRequest.getPrenomsDeclarant());
			declarant.setDatenaissDeclarant( premierCopieRequest.getDatenaissDeclarant());
			declarant.setLieuNaissDeclarant( premierCopieRequest.getLieuNaissDeclarant());
			declarant.setAdressDeclarant( premierCopieRequest.getAdressDeclarant());
			declarant.setProfessionDeclarant( premierCopieRequest.getProfessionDeclarant());			
			declarantRepository.save(declarant);
			
			mere.setNomMere( premierCopieRequest.getNomMere());
			mere.setPrenomsMere( premierCopieRequest.getPrenomsMere());
			mere.setDatenaissMere( premierCopieRequest.getDatenaissMere());
			mere.setLieuNaissMere( premierCopieRequest.getLieuNaissMere());
			mere.setProfessionMere( premierCopieRequest.getProfessionMere());
			mere.setAdresseMere( premierCopieRequest.getAdresseMere());
			mereRepository.save(mere);
			
			pere.setNomPere( premierCopieRequest.getNomPere());
			pere.setPrenomsPere( premierCopieRequest.getPrenomsPere());
			pere.setDatenaissPere( premierCopieRequest.getDatenaissPere());
			pere.setLieuNaissPere( premierCopieRequest.getLieuNaissPere());
			pere.setProfessionPere( premierCopieRequest.getProfessionPere());
			pere.setAdressePere( premierCopieRequest.getAdressePere());
			pereRepository.save(pere);
			
			enfant.setNomEnfant( premierCopieRequest.getNomEnfant());
			enfant.setPrenomsEnfant( premierCopieRequest.getPrenomsEnfant());
			enfant.setDatenaissEnfant( premierCopieRequest.getDatenaissEnfant());
			enfant.setLieunaissEnfant( premierCopieRequest.getLieunaissEnfant());
			enfant.setHeurenaissEnfant( premierCopieRequest.getHeurenaissEnfant());
			enfant.setSexeEnfant( premierCopieRequest.getSexeEnfant());
			enfant.setDateEnfant( premierCopieRequest.getDateEnfant());
			enfant.setNomEnfant( premierCopieRequest.getNomEnfant());
			enfantRepository.save(enfant);
			
			pieceJustificative.setCertificatAccouch( premierCopieRequest.getCertificatAccouch());
			pieceJustificative.setLivretFamille( premierCopieRequest.getLivretFamille());
			pieceJustificative.setCinMere( premierCopieRequest.getCinMere());
			pieceJustificative.setCinDeclarant( premierCopieRequest.getCinDeclarant());
			pieceJustificativeRepository.save(pieceJustificative);
			
			premierCopie.setIdPremierCopie( premierCopieRequest.getIdPremierCopie());
			premierCopie.setDescription( premierCopieRequest.getDescription());
			premierCopie.setMention( premierCopieRequest.getMention());
			premierCopie.setDatePCopie( premierCopieRequest.getDatePCopie());
			premierCopie.setDatePremierCopie( premierCopieRequest.getDatePremierCopie());
			premierCopie.setDeclarant(declarant);
			premierCopie.setMaire(maire);
			premierCopie.setMere(mere);
			premierCopie.setPere(pere);
			premierCopie.setEnfant(enfant);
			premierCopie.setPieceJustificative(pieceJustificative);			
			premierCopieRepository.save(premierCopie);
	   
	   return new ResponseEntity<>(premierCopie, HttpStatus.CREATED);
		}
		catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@DeleteMapping("/{IdPremierCopie}")
	public ResponseEntity<HttpStatus>  supprPremierCopie(@PathVariable("IdPremierCopie") long IdPremierCopie)
	{	
		try
		{
			PremierCopie premierCopie = premierCopieRepository.findById(IdPremierCopie).get();
			Declarant declarant  =  premierCopie.getDeclarant();
			Mere mere  =  premierCopie.getMere();
			Pere pere =  premierCopie.getPere();
			Enfant enfant =  premierCopie.getEnfant();
			PieceJustificative pieceJustificative  =  premierCopie.getPieceJustificative();
				
			premierCopieRepository.delete(premierCopie);
			pieceJustificativeRepository.delete(pieceJustificative);
			enfantRepository.delete(enfant);
			pereRepository.delete(pere);
			mereRepository.delete(mere);
			declarantRepository.delete(declarant);
				
		    return new ResponseEntity<>(HttpStatus.OK);
			
	    } 
		catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
