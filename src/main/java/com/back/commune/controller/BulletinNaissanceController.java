package com.back.commune.controller;

import com.back.commune.model.BulletinNaissance;
import com.back.commune.request.BulletinNaissanceRequest;
import com.back.commune.service.BulletinNaissanceService;
import com.back.commune.utils.ResponsePageable;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

import java.util.Optional;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/bulletinNaissances")
public class BulletinNaissanceController {

    private final BulletinNaissanceService bulletinNaissanceService;

    @Autowired
    public BulletinNaissanceController(BulletinNaissanceService bulletinNaissanceService) {
        this.bulletinNaissanceService = bulletinNaissanceService;
    }

    @PostMapping
	public ResponseEntity<BulletinNaissance> addBulletinNaissance(@RequestBody BulletinNaissanceRequest request)
	{
        try {
            BulletinNaissance bulletin = bulletinNaissanceService.save(request);
            return new ResponseEntity<>(bulletin, HttpStatus.CREATED);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}

	@GetMapping("/{id}")
	  public ResponseEntity<BulletinNaissance> getBulletinNaissanceById(@PathVariable(value = "id") Long id) {
        BulletinNaissance bulletin = bulletinNaissanceService.findById(id);
        return new ResponseEntity<>(bulletin, HttpStatus.OK);
	  }


	 @GetMapping("/premierCopies/{numCopie}")
	 public ResponseEntity<BulletinNaissance> getBulletinNaissanceByNumCopie(@PathVariable(value = "numCopie" ) String idPremierCopie)
	 {
		BulletinNaissance bulletinNaissance = bulletinNaissanceService.findByNumeroPremierCopie(idPremierCopie);
	    return new ResponseEntity<>(bulletinNaissance, HttpStatus.OK);
	 }


	@GetMapping()
	public ResponseEntity<ResponsePageable<BulletinNaissance>> getAllBulletinNaissances(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam() Optional<String> q,
	    @RequestParam(defaultValue = "10") int size)
	{
		Pageable pageable = PageRequest.of(page-1, size);
        ResponsePageable<BulletinNaissance> response ;
        if(q.isPresent() && !q.get().trim().isEmpty()){
            response = bulletinNaissanceService.findSearchAll(q.get().trim(),pageable);
        }else{
            response = bulletinNaissanceService.findAll(pageable);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
	}


	@PutMapping("/{id}")
	public ResponseEntity<BulletinNaissance> updateBulletinNaissance(@PathVariable(value = "id") Long id,@RequestBody BulletinNaissanceRequest request)
	{
        BulletinNaissance bulletin = bulletinNaissanceService.update(id, request);
        return new ResponseEntity<>(bulletin, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus>  supprBulletinNaissance(@PathVariable("id") Long idBulletinNaissance)
	{
        bulletinNaissanceService.delete(idBulletinNaissance);
        return new ResponseEntity<>(HttpStatus.OK);
	}
}
