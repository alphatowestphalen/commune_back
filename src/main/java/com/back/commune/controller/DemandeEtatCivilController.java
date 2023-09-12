package com.back.commune.controller;

import com.back.commune.model.demande.DemandeEtatCivile;
import com.back.commune.request.DemandeEtatCivileRequest;
import com.back.commune.service.DemandeEtatCivileService;
import com.back.commune.utils.ResponsePageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/DemandeEtatCivil")
public class DemandeEtatCivilController {
    DemandeEtatCivileService demandeEtatCivileService;

    @Autowired
    public DemandeEtatCivilController(DemandeEtatCivileService demandeEtatCivileService) {
        this.demandeEtatCivileService = demandeEtatCivileService;
    }

    @GetMapping
    public ResponseEntity<ResponsePageable> getAllDemandeEtatCivils(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        Pageable paging = PageRequest.of(page, size);

        Page<DemandeEtatCivile> demandeEtatCivils = demandeEtatCivileService.getAllDemandeEtatCivils(paging);

        ResponsePageable<DemandeEtatCivile> response = new ResponsePageable<>(demandeEtatCivils);
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<DemandeEtatCivile> addDemandeEtatCivil(@RequestBody DemandeEtatCivileRequest demandeEtatCivileRequest) {
        DemandeEtatCivile demandeEtatCivile = demandeEtatCivileService.addDemandeEtatCivil(demandeEtatCivileRequest);
        return ResponseEntity.ok(demandeEtatCivile);
    }

    @PostMapping("signed/{idDemande}")
    public ResponseEntity<DemandeEtatCivile> addDemandeEtatCivil(@PathVariable("idDemande") String idDemande) {
        DemandeEtatCivile demandeEtatCivile = demandeEtatCivileService.setSignedByMaire(idDemande);
        return ResponseEntity.ok(demandeEtatCivile);
    }



    @GetMapping("/year")
    public ResponseEntity<ResponsePageable> getAllDemandeEtatCivils(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam() Optional<String> year,
        @RequestParam() Optional<String> date
    ) {
        Pageable paging = PageRequest.of(page, size);

        if(year.isPresent()){
            Page<DemandeEtatCivile> demandeEtatCivils = demandeEtatCivileService.getAllDemandeEtatYear(year.get(),paging);
            ResponsePageable<DemandeEtatCivile> response = new ResponsePageable<>(demandeEtatCivils);
            return ResponseEntity.ok(response);
        }
        if(date.isPresent()){
            Date ndate = null;
            try {
                ndate = new SimpleDateFormat("yyyy-MM-dd").parse(date.get());
            } catch (ParseException e) {
                return ResponseEntity.badRequest().build();
            }
            Page<DemandeEtatCivile> demandeEtatCivils = demandeEtatCivileService.getAllDemandeEtatYear(ndate,paging);
            ResponsePageable<DemandeEtatCivile> response = new ResponsePageable<>(demandeEtatCivils);
            return ResponseEntity.ok(response);
        }else{
            Page<DemandeEtatCivile> demandeEtatCivils = demandeEtatCivileService.getAllDemandeEtatCivils(new Date() ,paging);
            ResponsePageable<DemandeEtatCivile> response = new ResponsePageable<>(demandeEtatCivils);
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/month")
    public ResponseEntity<ResponsePageable> getAllDemandeEtatCivils(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam() Optional<String> month,
        @RequestParam() Optional<String> year,
        @RequestParam() Optional<String> date
    ) {
        Pageable paging = PageRequest.of(page, size);
        if(month.isPresent() && year.isPresent()) {
            Page<DemandeEtatCivile> demandeEtatCivils = demandeEtatCivileService.getAllDemandeEtatMonth(month.get(),year.get(),paging);
            ResponsePageable<DemandeEtatCivile> response = new ResponsePageable<>(demandeEtatCivils);
            return ResponseEntity.ok(response);
        } else if (date.isPresent()) {
            Date ndate;
            try{
                ndate = new SimpleDateFormat("yyyy-MM-dd").parse(date.get());
            }catch (ParseException e){
                return ResponseEntity.badRequest().build();
            }
            Page<DemandeEtatCivile> demandeEtatCivils = demandeEtatCivileService.getAllDemandeEtatMonth(ndate,paging);
            ResponsePageable<DemandeEtatCivile> response = new ResponsePageable<>(demandeEtatCivils);
            return ResponseEntity.ok(response);
        }else{
            Page<DemandeEtatCivile> demandeEtatCivils = demandeEtatCivileService.getAllDemandeEtatMonth(new Date(),paging);
            ResponsePageable<DemandeEtatCivile> response = new ResponsePageable<>(demandeEtatCivils);
            return ResponseEntity.ok(response);
        }
    }
}
