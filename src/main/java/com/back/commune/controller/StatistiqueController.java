package com.back.commune.controller;

import com.back.commune.DTO.Statistique;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.back.commune.service.StatistiqueService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/statistiques")
public class StatistiqueController {

    private final StatistiqueService statistiqueService;


	@GetMapping
    public ResponseEntity<Statistique> getStatistique() {
        return ResponseEntity.ok().body(statistiqueService.getStatistique());
    }

    @GetMapping("/day/{date}")
    public ResponseEntity<Statistique> getStatistiqueDays(
        @PathVariable("date") String day
    ) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = dateFormat.parse(day);
        return ResponseEntity.ok().body(statistiqueService.getStatistiqueDays(date));
    }

    @GetMapping("/day/{startDate}/{endDate}")
    public ResponseEntity<Statistique> getStatistiqueDays(
        @PathVariable("startDate")String startDate,
        @PathVariable("endDate") String endDate
    ) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date1 = dateFormat.parse(startDate);
        Date date2 = dateFormat.parse(endDate);

        return ResponseEntity.ok().body(statistiqueService.getStatistiqueDays(date1,date2));
    }

    @GetMapping("/month/{month}/{year}")
    public ResponseEntity<Statistique> getStatistiqueMonth(
        @PathVariable("month")String month,
        @PathVariable("year") String year
    ){
        return ResponseEntity.ok().body(
            statistiqueService.getStatistiqueMonth(
                Integer.parseInt(month),
                Integer.parseInt(year)
            )
        );
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<Statistique> getStatistiqueYear(
        @PathVariable("year") String year
    ){
        return ResponseEntity.ok().body(statistiqueService.getStatistiqueYear(Integer.parseInt(year)));
    }
}
