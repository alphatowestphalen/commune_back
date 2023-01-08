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
import com.example.demo.model.Maire;
import com.example.demo.model.Mere;
import com.example.demo.model.Pere;
import com.example.demo.model.Personne;
import com.example.demo.model.PieceJustificative;
import com.example.demo.model.PremierCopie;
import com.example.demo.repository.DeclarantRepository;
import com.example.demo.repository.MaireRepository;
import com.example.demo.repository.MereRepository;
import com.example.demo.repository.PereRepository;
import com.example.demo.repository.PersonneRepository;
import com.example.demo.repository.PieceJustificativeRepository;
import com.example.demo.repository.PremierCopieRepository;
import com.example.demo.request.PremierCopieRequest;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/premierCopies")
public class PremierCopieController {
	
	@Autowired
	PremierCopieRepository premierCopieRepository;
	@Autowired
	DeclarantRepository declarantRepository;
	@Autowired
	MaireRepository maireRepository;
	@Autowired
	MereRepository mereRepository;
	@Autowired
	PereRepository pereRepository;
	@Autowired
	PersonneRepository 	personneRepository;
	@Autowired
	PieceJustificativeRepository pieceJustificativeRepository;
	
	@PostMapping
	  public ResponseEntity<PremierCopie> createPremierCopie(@RequestBody @Valid PremierCopieRequest premierCopieRequest )
	  {
	    
	   Maire maire = maireRepository.findById(premierCopieRequest.getIdMaire()).get();
	   
	   Declarant declarant = new Declarant(
			   premierCopieRequest.getNomDeclarant(),
			   premierCopieRequest.getPrenomsDeclarant(),
			   premierCopieRequest.getDatenaissDeclarant(),
			   premierCopieRequest.getLieuNaissDeclarant(),
			   premierCopieRequest.getAdressDeclarant());	    	
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
	   
	   Personne personne =  new Personne(
			   premierCopieRequest.getDatenaissPersonne(), 
			   premierCopieRequest.getHeurenaissPersonne(), 
			   premierCopieRequest.getLieuNaissPersonne(),
			   premierCopieRequest.getNomPersonne(),
			   premierCopieRequest.getPrenomsPersonne(),
			   premierCopieRequest.getSexePersonne() );
	   personneRepository.save(personne);
	   
	   PieceJustificative pieceJustificative = new PieceJustificative(
			   premierCopieRequest.getCertificatAccouch(), 
			   premierCopieRequest.getLivretFamille(), 
			   premierCopieRequest.getCinMere(),
			   premierCopieRequest.getCinDeclarant() );
	   pieceJustificativeRepository.save(pieceJustificative);
	   
	   PremierCopie premierCopie = new PremierCopie(
			   premierCopieRequest.getDescription(),
			   premierCopieRequest.getMention(),
			   declarant,
			   mere,
			   pere,
			   personne,
			   pieceJustificative,
			   maire);
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
	public ResponseEntity<PremierCopie> updatePremierCopie(@PathVariable("IdPremierCopie") Long IdPremierCopie, @RequestBody @Valid PremierCopieRequest premierCopieRequest) 
	{
		PremierCopie premierCopie = premierCopieRepository.findById(IdPremierCopie).get();
		
		if(premierCopie != null)
		{
			Declarant declarant = declarantRepository.findById(premierCopie.getDeclarant().getIdDeclarant()).get();
			Mere mere = mereRepository.findById(premierCopie.getMere().getIdMere()).get();
			Pere pere = pereRepository.findById(premierCopie.getPere().getIdPere()).get();
			Personne personne = personneRepository.findById(premierCopie.getPersonne().getIdPersonne()).get();
			PieceJustificative pieceJustificative = pieceJustificativeRepository.findById(premierCopie.getPieceJustificative().getIdPieceJustificative()).get();
			
			Maire maire = maireRepository.findById(premierCopieRequest.getIdMaire()).get();
			
			if (declarant != null) {
				declarant.setNomDeclarant(premierCopieRequest.getNomDeclarant());
				declarant.setPrenomsDeclarant(premierCopieRequest.getPrenomsDeclarant());
				declarant.setDatenaissDeclarant(premierCopieRequest.getDatenaissDeclarant());
				declarant.setLieuNaissDeclarant(premierCopieRequest.getLieuNaissDeclarant());
				declarant.setAdressDeclarant(premierCopieRequest.getAdressDeclarant());

		    	declarantRepository.save(declarant);
		    } 			
			if (mere != null) {
				mere.setNomMere(premierCopieRequest.getNomMere());
				mere.setPrenomsMere(premierCopieRequest.getPrenomsMere());
				mere.setDatenaissMere(premierCopieRequest.getDatenaissMere());
				mere.setLieuNaissMere(premierCopieRequest.getLieuNaissMere());
				mere.setProfessionMere(premierCopieRequest.getProfessionMere());
				mere.setAdresseMere(premierCopieRequest.getAdresseMere());
		    	
		    	mereRepository.save(mere);
			}
			if (pere != null) {
				pere.setNomPere(premierCopieRequest.getNomPere());
				pere.setPrenomsPere(premierCopieRequest.getPrenomsPere());
				pere.setDatenaissPere(premierCopieRequest.getDatenaissPere());
		    	pere.setLieuNaissPere(premierCopieRequest.getLieuNaissPere());
		    	pere.setProfessionPere(premierCopieRequest.getProfessionPere());
		    	pere.setAdressePere(premierCopieRequest.getAdressePere());

		    	pereRepository.save(pere);
			}
			if (personne != null) {
				personne.setDatenaissPersonne(premierCopieRequest.getDatenaissPersonne());
		    	personne.setHeurenaissPersonne(premierCopieRequest.getHeurenaissPersonne());
		    	personne.setLieuNaissPersonne(premierCopieRequest.getLieuNaissPersonne());
		    	personne.setNomPersonne(premierCopieRequest.getNomPersonne());
		    	personne.setPrenomsPersonne(premierCopieRequest.getPrenomsPersonne());
		    	personne.setSexePersonne(premierCopieRequest.getSexePersonne());

		    	personneRepository.save(personne);
			}
			 if (pieceJustificative != null) {
				 pieceJustificative.setCertificatAccouch(premierCopieRequest.getCertificatAccouch());
				 pieceJustificative.setCinDeclarant(premierCopieRequest.getCinDeclarant());
				 pieceJustificative.setCinMere(premierCopieRequest.getCinMere());
				 pieceJustificative.setLivretFamille(premierCopieRequest.getLivretFamille());
			    	
			    pieceJustificativeRepository.save(pieceJustificative);
			 }
			
			 premierCopie.setDescription(premierCopieRequest.getDescription());
			 premierCopie.setMention(premierCopieRequest.getMention()) ;
			 premierCopie.setMaire(maire);
			 
			 premierCopieRepository.save(premierCopie);
			 
			 return new ResponseEntity<>(premierCopie, HttpStatus.OK);	   
		}else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus>  supprPremierCopie(@PathVariable("id") long id)
	{	
		try
		{
			PremierCopie premierCopie = premierCopieRepository.findById(id).get();
			
			if(premierCopie != null)
			{
				Declarant declarant = declarantRepository.findById(premierCopie.getDeclarant().getIdDeclarant()).get();
				Mere mere = mereRepository.findById(premierCopie.getMere().getIdMere()).get();
				Pere pere = pereRepository.findById(premierCopie.getPere().getIdPere()).get();
				Personne personne = personneRepository.findById(premierCopie.getPersonne().getIdPersonne()).get();
				PieceJustificative pieceJustificative = pieceJustificativeRepository.findById(premierCopie.getPieceJustificative().getIdPieceJustificative()).get();
								
				premierCopieRepository.delete(premierCopie);
				declarantRepository.delete(declarant);
				mereRepository.delete(mere);
				pereRepository.delete(pere);
				personneRepository.delete(personne);
				pieceJustificativeRepository.delete(pieceJustificative);
				
		        return new ResponseEntity<>(HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    } 
		catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
}
