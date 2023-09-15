package com.back.commune.controller;
import com.back.commune.utils.ResponsePageable;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.back.commune.model.ActeDeces;
import com.back.commune.request.DecesRequest;
import com.back.commune.service.ActeDecesService;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/deces")
@AllArgsConstructor
public class ActeDecesController {

    private final ActeDecesService acteDecesService;

	@PostMapping
	  public ResponseEntity<ActeDeces> addDeces(@RequestBody DecesRequest decesRequest)
	{
        ActeDeces actedeces = acteDecesService.save(decesRequest);
        return new ResponseEntity<>(actedeces, HttpStatus.OK);
	}

	@GetMapping
	  public ResponseEntity<ResponsePageable<ActeDeces>> getAllActeDeces(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page-1, size);
        ResponsePageable<ActeDeces> acteDeces = acteDecesService.findAll(pageable);
	    return new ResponseEntity<>(acteDeces, HttpStatus.OK);
	  }

	@GetMapping("/{id}")
	  public ResponseEntity<ActeDeces> getActeDecesById(@PathVariable(value = "id") String id) {
		ActeDeces acte = acteDecesService.findById(id);
	    return new ResponseEntity<>(acte, HttpStatus.OK);
	  }

	@PutMapping("/{id}")
	public ResponseEntity<ActeDeces> updateActeDeces(
        @PathVariable(value = "id") String id,
        @RequestBody DecesRequest decesRequest)
	{
        ActeDeces acteDeces = acteDecesService.update(id, decesRequest);
        return new ResponseEntity<>(acteDeces, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus>  supprActeDeces(@PathVariable("id") String idActeDeces)
	{
        acteDecesService.delete(idActeDeces);
        return new ResponseEntity<>(HttpStatus.OK);
	}
}
