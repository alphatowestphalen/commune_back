package com.back.commune.controller;

import com.back.commune.DTO.resulSet.CountByUser;
import com.back.commune.output.Acte;
import com.back.commune.output.Naissance;
import com.back.commune.service.PremierCopieStatService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.commune.service.StatistiqueService;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/statistiques")
public class StatistiqueController {

	private final StatistiqueService statistiqueService;
    private final PremierCopieStatService premierCopieStatService;

	@GetMapping
	public Acte getActe()
	{
		Acte acte = statistiqueService.statistiqueacte();

		return acte;
	}

	@GetMapping("/naissance")
	public Naissance getStatistiqueNaissance()
	{
		Naissance naissance = statistiqueService.statistiqueNaissance();

		return naissance;
	}
    @GetMapping("/user")
    public List<CountByUser> statByUser()
    {
        return premierCopieStatService.countByUser();
    }
}
