package com.back.commune.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;


import com.back.commune.request.NumeroRequest;
import com.back.commune.request.PremierCopieRequest;
import com.back.commune.security.services.UserService;
import com.back.commune.service.PremierCopieService;
import com.back.commune.utils.ResponsePageable;
import lombok.AllArgsConstructor;
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

import com.back.commune.model.Adoption;
import com.back.commune.model.Declarant;
import com.back.commune.model.Enfant;
import com.back.commune.model.Maire;
import com.back.commune.model.Mention;
import com.back.commune.model.Mere;
import com.back.commune.model.Pere;
import com.back.commune.model.PieceJustificative;
import com.back.commune.model.PremierCopie;
import com.back.commune.model.Reconnaissance;
import com.back.commune.repository.DeclarantRepository;
import com.back.commune.repository.EnfantRepository;
import com.back.commune.repository.MaireRepository;
import com.back.commune.repository.MereRepository;
import com.back.commune.repository.PereRepository;
import com.back.commune.repository.PieceJustificativeRepository;
import com.back.commune.repository.PremierCopieRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/premierCopies")
@AllArgsConstructor
public class PremierCopieController {
    PieceJustificativeRepository pieceJustificativeRepository;
    EnfantRepository enfantRepository;
    MereRepository mereRepository;
    PereRepository pereRepository;
    DeclarantRepository declarantRepository;
	MaireRepository maireRepository;
    PremierCopieService premierCopieService;
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
    @GetMapping("/sexeEnfant/{sexeEnfant}")
    public ResponseEntity<ResponsePageable<PremierCopie>> getAllPremierCopieBySexe(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size,
        @PathVariable("sexeEnfant") String sexeEnfant
    ){
        Pageable pageable = PageRequest.of(page-1, size);
        ResponsePageable<PremierCopie> response =  premierCopieService.findBySexeEnfant(sexeEnfant, pageable);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/living")
    public ResponseEntity<ResponsePageable<PremierCopie>> getAllPremierCopieAlive(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size
    ){
        Pageable pageable = PageRequest.of(page-1, size);
        ResponsePageable<PremierCopie> response =  premierCopieService.findAllAlive(pageable);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

	@GetMapping("/{id}")
//	@PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
	  public ResponseEntity<PremierCopie> getByIdPremierCopie(@PathVariable("id") String id)
	{

		PremierCopie premierCopie = premierCopieRepository.findByIdPremierCopie(id);

				List<Mention> mentions = new ArrayList<>();

                List<Reconnaissance> reconnaissanceList = premierCopieService.getReconnaissances(id);

			    if (reconnaissanceList != null && !reconnaissanceList.isEmpty()) {
			    	for (Reconnaissance rec : reconnaissanceList) {
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

                List<Adoption> adoptionList = premierCopieService.getAdoptions(id);
			    if (adoptionList != null && !adoptionList.isEmpty()) {
			    	for (Adoption rec : adoptionList) {
			    		  Mention m = new Mention();
			    		  m.setInfo(new ArrayList<>());
			    		  m.setCreatedDate(rec.getCreatedDate());
			    		  m.getInfo().add(rec);
			    		  m.setType("adoption");
			    		  mentions.add(m);
			    		}
			    	// mentions.addAll(premierCopie.getAdoption());
			    }
			    Collections.sort(mentions, (a, b) -> a.getCreatedDate().compareTo(b.getCreatedDate()));
			    premierCopie.setMentions(mentions);
				return new ResponseEntity<>(premierCopie, HttpStatus.OK);

    }


    @GetMapping("/")
    //@PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
    public ResponseEntity<Map<String, Object>> findByIdPremiereCopie(
       @RequestParam(required = true) String idPremierCopie,
       @RequestParam(defaultValue = "0") int page,
       @RequestParam(defaultValue = "3") int size)
    {
        List<PremierCopie> premierCopies = new ArrayList<PremierCopie>();
        Pageable paging = PageRequest.of(page, size);
        Page<PremierCopie> pagecopie;
        System.out.println(idPremierCopie);
        pagecopie = premierCopieRepository.findByIdPremierCopieStartsWith(idPremierCopie,paging);
        premierCopies = pagecopie.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("premierCopies", premierCopies);
            response.put("currentPage", pagecopie.getNumber());
            response.put("totalItems", pagecopie.getTotalElements());
            response.put("totalPages", pagecopie.getTotalPages());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/nomEnfant")
    //@PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
    public ResponseEntity<Map<String, Object>> findByNomEnfant(
       @RequestParam(required = true) String NomEnfant,
       @RequestParam(required = true) String PrenomsEnfant,
       @RequestParam(defaultValue = "1") int page,
       @RequestParam(defaultValue = "10") int size)
    {
        List<PremierCopie> premierCopies = new ArrayList<PremierCopie>();
        Pageable paging = PageRequest.of(page-1, size);
        Page<PremierCopie> pagecopie;
        pagecopie = premierCopieRepository.findByEnfantNomEnfantStartsWithOrEnfantPrenomsEnfantStartsWith(NomEnfant,PrenomsEnfant,paging);
        premierCopies = pagecopie.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("premierCopies", premierCopies);
            response.put("currentPage", pagecopie.getNumber());
            response.put("totalItems", pagecopie.getTotalElements());
            response.put("totalPages", pagecopie.getTotalPages());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

	@PutMapping("/{IdPremierCopie}")
	// @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<PremierCopie> updatePremierCopie(
        @PathVariable("IdPremierCopie") String IdPremierCopie,
        @RequestBody PremierCopieRequest premierCopieRequest)
	{
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
			mere.setDateNaissMere( premierCopieRequest.getDatenaissMere());
			mere.setLieuNaissMere( premierCopieRequest.getLieuNaissMere());
			mere.setProfessionMere( premierCopieRequest.getProfessionMere());
			mere.setAdresseMere( premierCopieRequest.getAdresseMere());
			mereRepository.save(mere);

			pere.setNomPere( premierCopieRequest.getNomPere());
			pere.setPrenomsPere( premierCopieRequest.getPrenomsPere());
			pere.setDateNaissPere( premierCopieRequest.getDatenaissPere());
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
	@DeleteMapping("/{IdPremierCopie}")
	// @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<HttpStatus>  supprPremierCopie(@PathVariable("IdPremierCopie") String IdPremierCopie)
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
	public ResponseEntity<HttpStatus> restorePremierCopie(@PathVariable("idPremierCopie") String idPremierCopie) {
        premierCopieRepository.undoDeletePremierCopie(idPremierCopie);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
