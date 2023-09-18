package com.back.commune.service;

import com.back.commune.DTO.*;
import com.back.commune.output.Acte;
import com.back.commune.output.Naissance;
import com.back.commune.repository.PremierCopieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.commune.repository.ActeDecesRepository;
import com.back.commune.repository.AdoptionRepository;
import com.back.commune.repository.JugementRepository;
import com.back.commune.repository.MariageRepository;
import com.back.commune.repository.ReconnaissanceRepository;

import java.util.Date;

@Service
@AllArgsConstructor
public class StatistiqueService {
    private final PremierCopieStatService premierCopieStatService;
    private final ActeDecesService acteDecesService;
    private final AdoptionService adoptionService;
    private final JugementService jugementService;
    private final MariageService mariageService;
    private final BulletinNaissanceService bulletinNaissanceService;
    private final ReconnaissanceService reconnaissanceService;

    public Statistique getStatistique() {
        Statistique statistique = new Statistique();

        statistique.setPremierCopie(premierCopieStatService.getStatistiquePremierCopie());
        statistique.setActeDeces(acteDecesService.getStatistiaqueDeces());
        statistique.setAdoption(adoptionService.getStatistiqueAdoption());
        statistique.setJugement(jugementService.getStatistiqueJugement());
        statistique.setMariage(mariageService.getStatistiqueMariage());
        statistique.setBulletinNaissance(bulletinNaissanceService.getStatistiqueBulletinNaiss());
        statistique.setReconnaissance(reconnaissanceService.getStatistiqueReconnaissance());

        return statistique;
    }

    public Statistique getStatistiqueDays(Date day) {
        Statistique statistique = new Statistique();

        statistique.setPremierCopie(premierCopieStatService.getStatistiquePremierCopieDays(day));
        statistique.setActeDeces(acteDecesService.getStatistiaqueDecesDays(day));
        statistique.setAdoption(adoptionService.getStatistiqueAdoptionDays(day));
        statistique.setJugement(jugementService.getStatistiqueJugementDays(day));
        statistique.setMariage(mariageService.getStatistiqueMariageDays(day));
        statistique.setBulletinNaissance(bulletinNaissanceService.getStatistiqueBulletinNaissDays(day));
        statistique.setReconnaissance(reconnaissanceService.getStatistiqueReconnaissanceDays(day));

        return statistique;
    }
    public Statistique getStatistiqueDays(Date day1, Date day2) {
        Statistique statistique = new Statistique();

        statistique.setPremierCopie(premierCopieStatService.getStatistiquePremierCopieDays(day1, day2));
        statistique.setActeDeces(acteDecesService.getStatistiaqueDecesDays(day1, day2));
        statistique.setAdoption(adoptionService.getStatistiqueAdoptionDays(day1, day2));
        statistique.setJugement(jugementService.getStatistiqueJugementDays(day1, day2));
        statistique.setMariage(mariageService.getStatistiqueMariageDays(day1, day2));
        statistique.setBulletinNaissance(bulletinNaissanceService.getStatistiqueBulletinNaissDays(day1, day2));
        statistique.setReconnaissance(reconnaissanceService.getStatistiqueReconnaissanceDays(day1, day2));

        return statistique;
    }

    public Statistique getStatistiqueMonth(Integer month, Integer year) {
        Statistique statistique = new Statistique();

        statistique.setPremierCopie(premierCopieStatService.getStatistiquePremierCopieMonth(month, year));
        statistique.setActeDeces(acteDecesService.getStatistiaqueDecesMonth(month, year));
        statistique.setAdoption(adoptionService.getStatistiqueAdoptionMonth(month, year));
        statistique.setJugement(jugementService.getStatistiqueJugementMonth(month, year));
        statistique.setMariage(mariageService.getStatistiqueMariageMonth(month, year));
        statistique.setBulletinNaissance(bulletinNaissanceService.getStatistiqueBulletinNaissMonth(month, year));
        statistique.setReconnaissance(reconnaissanceService.getStatistiqueReconnaissanceMonth(month, year));

        return statistique;
    }

    public Statistique getStatistiqueYear(Integer year) {
        Statistique statistique = new Statistique();

        statistique.setPremierCopie(premierCopieStatService.getStatistiquePremierCopieYear(year));
        statistique.setActeDeces(acteDecesService.getStatistiaqueDecesYear(year));
        statistique.setAdoption(adoptionService.getStatistiqueAdoptionYear(year));
        statistique.setJugement(jugementService.getStatistiqueJugementYear(year));
        statistique.setMariage(mariageService.getStatistiqueMariageYear(year));
        statistique.setBulletinNaissance(bulletinNaissanceService.getStatistiqueBulletinNaissYear(year));
        statistique.setReconnaissance(reconnaissanceService.getStatistiqueReconnaissanceYear(year));

        return statistique;
    }

}
