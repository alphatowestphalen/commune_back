package com.back.commune.controller;

import com.back.commune.utils.ResponsePageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import com.back.commune.model.ActeCelibataire;
import com.back.commune.request.ActeCelibataireRequest;
import com.back.commune.service.ActeCelibataireService;

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
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
        )
    {
        Pageable pageable = PageRequest.of(page-1, size);
        ResponsePageable<ActeCelibataire> response = acteCelibataireService.findAll(pageable);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

	@PostMapping
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
	  public ResponseEntity<ActeCelibataire> addActeCelibataire(@RequestBody ActeCelibataireRequest acteCelibataireRequest)
	{
        ActeCelibataire acteCelibataire = acteCelibataireService.save(acteCelibataireRequest);
        return new ResponseEntity<>(acteCelibataire, HttpStatus.CREATED);
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
