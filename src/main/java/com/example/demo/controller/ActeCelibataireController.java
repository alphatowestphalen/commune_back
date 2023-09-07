package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.exceptions.NotFoundDataException;
import com.example.demo.utils.ResponsePageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import com.example.demo.model.ActeCelibataire;
import com.example.demo.model.ActeDeces;
import com.example.demo.model.Adoption;
import com.example.demo.model.Defunt;
import com.example.demo.model.Maire;
import com.example.demo.model.PieceDeces;
import com.example.demo.model.PremierCopie;
import com.example.demo.model.Reconnaissance;
import com.example.demo.repository.ActeCelibataireRepository;
import com.example.demo.repository.PremierCopieRepository;
import com.example.demo.request.ActeCelibataireRequest;
import com.example.demo.request.DecesRequest;
import com.example.demo.request.NumeroActeCelibataire;
import com.example.demo.request.ReconnaissanceRequest;
import com.example.demo.service.ActeCelibataireService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/acteCelibataires")
public class ActeCelibataireController {
    private  final ActeCelibataireService acteCelibataireService;

    @Autowired
    public ActeCelibataireController( ActeCelibataireService acteCelibataireService) {
        this.acteCelibataireService = acteCelibataireService;
    }

    @GetMapping
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
	  public ResponseEntity<ResponsePageable<ActeCelibataire>> getAllActeCelibataires
        (
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
        )
    {
        Pageable pageable = PageRequest.of(page, size);
        ResponsePageable<ActeCelibataire> response = acteCelibataireService.findAll(pageable);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

	@PostMapping("/{IdPremierCopie}")
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
	  public ResponseEntity<ActeCelibataire> addActeCelibataire(@PathVariable(value = "IdPremierCopie") String IdPremierCopie, @RequestBody ActeCelibataireRequest acteCelibataireRequest)
	{
        ActeCelibataire acteCelibataire = acteCelibataireService.save(acteCelibataireRequest, IdPremierCopie);
        return new ResponseEntity<>(acteCelibataire, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	  public ResponseEntity<ActeCelibataire> getActeCelibataireById(@PathVariable(value = "id") String id) {
        ActeCelibataire acteCelibataire = acteCelibataireService.find(id);
	    return new ResponseEntity<>(acteCelibataire, HttpStatus.OK);
	  }

	@PutMapping("/{id}")
	public ResponseEntity<ActeCelibataire> updateActeCelibataire(@PathVariable(value = "id") String id, @RequestBody ActeCelibataireRequest acteCelibataireRequest)
	{
        ActeCelibataire acteCelibataire = acteCelibataireService.update(acteCelibataireRequest, id);
        return new ResponseEntity<>(acteCelibataire, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
//	 @PreAuthorize(" hasRole('MAIRE')")
	  public ResponseEntity<HttpStatus> deleteActeCelibataire(@PathVariable("id") String id) {
            acteCelibataireService.delete(id);
		    return new ResponseEntity<>(HttpStatus.OK);
	  }
}
