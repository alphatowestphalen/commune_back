package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;


import com.example.demo.model.auth.User;
import com.example.demo.security.services.UserService;
import com.example.demo.utils.ResponsePageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
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
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import com.example.demo.model.Adoption;
import com.example.demo.model.Declarant;
import com.example.demo.model.Enfant;
import com.example.demo.model.Jugement;
import com.example.demo.model.Maire;
import com.example.demo.model.Mariage;
import com.example.demo.model.Mention;
import com.example.demo.model.MentionInfo;
import com.example.demo.model.Mere;
import com.example.demo.model.Pere;
import com.example.demo.model.PieceJustificative;
import com.example.demo.model.PremierCopie;
import com.example.demo.model.Reconnaissance;
import com.example.demo.repository.DeclarantRepository;
import com.example.demo.repository.EnfantRepository;
import com.example.demo.repository.MaireRepository;
import com.example.demo.repository.MereRepository;
import com.example.demo.repository.PereRepository;
import com.example.demo.repository.PieceJustificativeRepository;
import com.example.demo.repository.PremierCopieRepository;
import com.example.demo.request.NumeroRequest;
import com.example.demo.request.PremierCopieRequest;
import com.example.demo.service.PremierCopieService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/premierCopies")

public class PremierCopieController {

    @Autowired
    PieceJustificativeRepository pieceJustificativeRepository;
    @Autowired
    EnfantRepository enfantRepository;
    @Autowired
    MereRepository mereRepository;
    @Autowired
    PereRepository pereRepository;
    @Autowired
    DeclarantRepository declarantRepository;
	@Autowired
	MaireRepository maireRepository;
    @Autowired
    UserService userService;
	@Autowired
	PremierCopieService premierCopieService;
	@Autowired
	PremierCopieRepository premierCopieRepository;

	@PostMapping
//	@PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
	  public ResponseEntity<PremierCopie> createPremierCopie(@RequestBody @Valid PremierCopieRequest premierCopieRequest)
	  {
          PremierCopie premierCopie = premierCopieService.save(premierCopieRequest);
          return new ResponseEntity<> (premierCopie, HttpStatus.CREATED);
	  }

	@GetMapping
//	@PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
	  public ResponseEntity<ResponsePageable<PremierCopie>> getAllPremierCopie(
			        @RequestParam(defaultValue = "1") int page,
			        @RequestParam(defaultValue = "10") int size)
    {
	        Pageable pageable = PageRequest.of(page-1, size);
            ResponsePageable<PremierCopie> response =  premierCopieService.findAll(pageable);
            return new ResponseEntity<>(response, HttpStatus.OK);
    }

	@GetMapping("/{id}")
//	@PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
	  public ResponseEntity<PremierCopie> getByIdPremierCopie(@PathVariable("id") String id)
	{

		PremierCopie premierCopie = premierCopieRepository.findByIdPremierCopie(id);

				List<Mention> mentions = new ArrayList<>();

			    if (premierCopie.getReconnaissance() != null && !premierCopie.getReconnaissance().isEmpty()) {
			    	for (Reconnaissance rec : premierCopie.getReconnaissance()) {
			    		  Mention m = new Mention();
			    		  m.setCreatedDate(rec.getCreatedDate());
			    		  m.getInfo().add(rec);
			    		  m.setType("reconnaissance");
			    		  mentions.add(m);
			    		}

			    	//mentions.addAll(premierCopie.getReconnaissance());
			    }

			    if (premierCopie.getJugement() != null) {

			    		  Mention m = new Mention();
			    		  m.setCreatedDate(premierCopie.getJugement().getCreatedDate());
			    		  m.getInfo().add(premierCopie.getJugement() );
			    		  m.setType("jugement");
			    		  mentions.add(m);

			    	// mentions.add(premierCopie.getJugement());
			    }

			    if (premierCopie.getAdoption() != null && !premierCopie.getAdoption().isEmpty()) {
			    	for (Adoption rec : premierCopie.getAdoption()) {
			    		  Mention m = new Mention();
			    		  m.setInfo(new ArrayList<>());
			    		  m.setCreatedDate(rec.getCreatedDate());
			    		  m.getInfo().add(rec);
			    		  m.setType("adoption");
			    		  mentions.add(m);
			    		}
			    	// mentions.addAll(premierCopie.getAdoption());
			    }

			    // if (premierCopie.getMariage() != null && !premierCopie.getMariage().isEmpty()) {
			    // 	if(premierCopie.getEnfant().getSexeEnfant() == "M")
			    // 	{
			    // 		for (Mariage mar : premierCopie.getMariage()) {
			    // 			Mention m = new Mention();
				//     		 m.setInfo(new ArrayList<>());
				//     		  m.setCreatedDate(mar.getCreatedDate());
				//     		  m.getInfo().add(new MentionInfo("numMariage",mar.getIdMariage()));
				//     		  m.getInfo().add(new MentionInfo("dateMariage",mar.getDateMariage()));
				//     		  m.getInfo().add(new MentionInfo("nomCouple",mar.getFemme().getNomFemme()));
				//     		  m.getInfo().add(new MentionInfo("prenomCouple",mar.getFemme().getPrenomsFemme()));
				//     		  m.getInfo().add(new MentionInfo("datenaissCouple",mar.getFemme().getDatenaissFemme()));
				//     		  m.getInfo().add(new MentionInfo("profession",mar.getFemme().getProfessionFemme()));
				//     		  m.getInfo().add(new MentionInfo("lieunaiss",mar.getFemme().getLieunaissFemme()));
				//     		  m.getInfo().add(new MentionInfo("adresse",mar.getFemme().getAdresseFemme()));

				//     		  m.setType("mariage");
				//     		  mentions.add(m);
			    // 		}

			    // 	}
			    // 	else {
			    // 		for (Mariage mar : premierCopie.getMariage()) {
			    // 			Mention m = new Mention();
				//     		 m.setInfo(new ArrayList<>());
				//     		  m.setCreatedDate(mar.getCreatedDate());
				//     		  m.getInfo().add(new MentionInfo("numMariage",mar.getIdMariage()));
				//     		  m.getInfo().add(new MentionInfo("dateMariage",mar.getDateMariage()));
				//     		  m.getInfo().add(new MentionInfo("nomCouple",mar.getHomme().getNomHomme()));
				//     		  m.getInfo().add(new MentionInfo("prenomCouple",mar.getHomme().getPrenomsHomme()));
				//     		  m.getInfo().add(new MentionInfo("datenaissCouple",mar.getHomme().getDatenaissHomme()));
				//     		  m.getInfo().add(new MentionInfo("profession",mar.getHomme().getProfessionHomme()));
				//     		  m.getInfo().add(new MentionInfo("lieunaiss",mar.getHomme().getLieunaissHomme()));
				//     		  m.getInfo().add(new MentionInfo("adresse",mar.getHomme().getAdresseHomme()));

				//     		  m.setType("mariage");
				//     		  mentions.add(m);
			    // 		}
			    // 	}

			    // 	// mentions.addAll(premierCopie.getMariage());
			    // }



			    Collections.sort(mentions, (a, b) -> a.getCreatedDate().compareTo(b.getCreatedDate()));
			    premierCopie.setMentions(mentions);

				return new ResponseEntity<>(premierCopie, HttpStatus.OK);

	 }


	 @GetMapping("/")
	 //	@PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
		   public ResponseEntity<Map<String, Object>> findByIdPremiereCopie(
		   @RequestParam(required = true) String idPremierCopie,
		   @RequestParam(defaultValue = "0") int page,
		   @RequestParam(defaultValue = "3") int size)
		 {
				try {
					List<PremierCopie> premierCopies = new ArrayList<PremierCopie>();
					Pageable paging = PageRequest.of(page, size);

					Page<PremierCopie> pagecopie;
					// pagecopie = premierCopieRepository.findAll(paging);


					// if(idPremierCopie == 0)

					// 	 pagecopie = premierCopieRepository.findAll(paging);

					// else
						System.out.println(idPremierCopie);
						pagecopie = premierCopieRepository.findByIdPremierCopieStartsWith(idPremierCopie,paging);





					premierCopies = pagecopie.getContent();


						Map<String, Object> response = new HashMap<>();
						response.put("premierCopies", premierCopies);
						response.put("currentPage", pagecopie.getNumber());
						response.put("totalItems", pagecopie.getTotalElements());
						response.put("totalPages", pagecopie.getTotalPages());
				 return new ResponseEntity<>(response, HttpStatus.OK);




				} catch (Exception e) {
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}


		  }


	 @GetMapping("/nomEnfant")
	 //	@PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
		   public ResponseEntity<Map<String, Object>> findByNomEnfant(
		   @RequestParam(required = true) String NomEnfant,
		   @RequestParam(required = true) String PrenomsEnfant,
		   @RequestParam(defaultValue = "0") int page,
		   @RequestParam(defaultValue = "3") int size)
		 {
				try {
					List<PremierCopie> premierCopies = new ArrayList<PremierCopie>();
					Pageable paging = PageRequest.of(page, size);

					Page<PremierCopie> pagecopie;
					// pagecopie = premierCopieRepository.findAll(paging);


					// if(idPremierCopie == 0)

					// 	 pagecopie = premierCopieRepository.findAll(paging);

					// else

						pagecopie = premierCopieRepository.findByEnfantNomEnfantStartsWithOrEnfantPrenomsEnfantStartsWith(NomEnfant,PrenomsEnfant,paging);

					premierCopies = pagecopie.getContent();


						Map<String, Object> response = new HashMap<>();
						response.put("premierCopies", premierCopies);
						response.put("currentPage", pagecopie.getNumber());
						response.put("totalItems", pagecopie.getTotalElements());
						response.put("totalPages", pagecopie.getTotalPages());
				 return new ResponseEntity<>(response, HttpStatus.OK);




				} catch (Exception e) {
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}


		  }


	@PutMapping("/{IdPremierCopie}")
	// @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<PremierCopie> updatePremierCopie(@PathVariable("IdPremierCopie") String IdPremierCopie,
			@RequestBody PremierCopieRequest premierCopieRequest)
	{
		try {
			PremierCopie premierCopie = premierCopieRepository.findById(IdPremierCopie)
					.orElseThrow(() -> new ResourceNotFoundException("Not found Premier Copie with id = " + IdPremierCopie));;

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

			//premierCopie.setIdPremierCopie( premierCopieRequest.getIdPremierCopie());
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
	// @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<HttpStatus>  supprPremierCopie(@PathVariable("IdPremierCopie") String IdPremierCopie)
	{
		try
		{
			PremierCopie premierCopie = premierCopieRepository.findByIdPremierCopie(IdPremierCopie);
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
	/*
	@GetMapping("/test")
	public Long test()
	{
		PremierCopie pc = premierCopieRepository.chercherPremierCopie();
		long a = pc.getNumero() + 1;
		return a;
	}
	*/

	@GetMapping("LastPremiereCopie")
	public String getLastIdPremierCopie() {
		PremierCopie premierecopie = premierCopieRepository.findTopByOrderByIdPremierCopieDesc();
		if( premierecopie != null && premierecopie.getIdPremierCopie() != null) {
			 NumeroRequest numerorequest =  premierCopieService.numeroCopie();
				return numerorequest.idPremierCopie;
		}
		 NumeroRequest numerorequest =  premierCopieService.numeroCopie();
		return numerorequest.idPremierCopie;


	}

	@Transactional
	@PutMapping("/restore/{idPremierCopie}")
	public ResponseEntity<HttpStatus> restorePremierCopie(@PathVariable("idPremierCopie") String idPremierCopie)
	{
		try {

			premierCopieRepository.restorePremierCopie(idPremierCopie);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e)
		{
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
