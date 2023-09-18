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

}
