package com.back.commune.controller;

import com.back.commune.model.PremierCopie;
import com.back.commune.utils.ResponsePageable;
import com.back.commune.service.JugementService;
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


import com.back.commune.model.Jugement;
import com.back.commune.request.JugementRequest;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/jugements")
public class JugementController {

    private final JugementService jugementService;

    @Autowired
    public JugementController(JugementService jugementService) {
        this.jugementService = jugementService;
    }

    @GetMapping
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
    public ResponseEntity<ResponsePageable<Jugement>> getAllJugements(
		        @RequestParam(defaultValue = "1") int page,
		        @RequestParam(defaultValue = "10") int size) {
        Pageable paging = PageRequest.of(page-1, size);
        ResponsePageable<Jugement> response = jugementService.getAll(paging);
        return new ResponseEntity<> (response, HttpStatus.OK);
    }

    @GetMapping("/premierCopies")
    // @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
    public ResponseEntity<ResponsePageable<PremierCopie>> getAllPremierCopie(
        @RequestParam(defaultValue = "true") boolean haveJugement,
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size) {
        Pageable paging = PageRequest.of(page-1, size);
        ResponsePageable<PremierCopie> response;

        if(haveJugement)
            response = jugementService.getAllPremierCopieHaveJugement(paging);
        else
            response = jugementService.getAllPremierCopieNotHaveJugement(paging);

        return new ResponseEntity<> (response, HttpStatus.OK);
    }

	@GetMapping("/{id}")
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
    public ResponseEntity<Jugement> getJugementById(@PathVariable(value = "id") Long id) {
        Jugement jugement = jugementService.findById(id);
	    return new ResponseEntity<>(jugement, HttpStatus.OK);
    }

	@PostMapping()
	// @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
	  public ResponseEntity<Jugement> addJugement(@RequestBody JugementRequest jugementRequest)
	{
        Jugement jugement = new Jugement();
        try {
             jugement = jugementService.save(jugementRequest);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(jugement, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	// @PreAuthorize(" hasRole('MAIRE')")
	public ResponseEntity<Jugement> updateJugement(@PathVariable(value = "id") Long id,
			@RequestBody JugementRequest jugementRequest)
	{
        Jugement jugement = jugementService.update(id, jugementRequest);
		return new ResponseEntity<>(jugement, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	// @PreAuthorize(" hasRole('MAIRE')")
	  public ResponseEntity<HttpStatus> deleteJugement(@PathVariable("id") long id)
	{
        jugementService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
