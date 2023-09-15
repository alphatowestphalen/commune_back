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

        statistique.setPremierCopie(getStatistiquePremierCopie());
        statistique.setActeDeces(getStatistiaqueDeces());
        statistique.setAdoption(getStatistiqueAdoption());
        statistique.setJugement(getStatistiqueJugement());
        statistique.setMariage(getStatistiqueMariage());
        statistique.setBulletinNaissance(getStatistiqueBulletinNaiss());
        statistique.setReconnaissance(getStatistiqueReconnaissance());

        return statistique;
    }

    private StatistiquePremierCopie getStatistiquePremierCopie() {
        StatistiquePremierCopie statistiquePremierCopie = new StatistiquePremierCopie();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(premierCopieStatService.count());
        statisiqueAbstract.setNombreParUtilisateur(premierCopieStatService.countByUser());

        statistiquePremierCopie.setNombre(statisiqueAbstract);

        return statistiquePremierCopie;
    }

    private StatistiqueAdoption getStatistiqueAdoption() {
        StatistiqueAdoption statistiqueAdoption = new StatistiqueAdoption();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(adoptionService.count());
        statisiqueAbstract.setNombreParUtilisateur(adoptionService.countByUser());

        statistiqueAdoption.setNombre(statisiqueAbstract);

        return statistiqueAdoption;
    }

    private StatistiqueJugement getStatistiqueJugement() {
        StatistiqueJugement statiqueJugement = new StatistiqueJugement();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(jugementService.count());
        statisiqueAbstract.setNombreParUtilisateur(jugementService.countByUser());

        statiqueJugement.setNombre(statisiqueAbstract);

        return statiqueJugement;
    }

    private StatistiqueReconnaissance getStatistiqueReconnaissance() {
        StatistiqueReconnaissance statistiqueReconnaissance = new StatistiqueReconnaissance();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(reconnaissanceService.count());
        statisiqueAbstract.setNombreParUtilisateur(reconnaissanceService.countByUser());

        statistiqueReconnaissance.setNombre(statisiqueAbstract);

        return statistiqueReconnaissance;
    }

    private StatistiqueMariage getStatistiqueMariage() {
        StatistiqueMariage statistiqueMariage = new StatistiqueMariage();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(mariageService.count());
        statisiqueAbstract.setNombreParUtilisateur(mariageService.countByUser());

        statistiqueMariage.setNombre(statisiqueAbstract);

        return statistiqueMariage;
    }

    private StatistiaqueDeces getStatistiaqueDeces() {
        StatistiaqueDeces statistiaqueDeces = new StatistiaqueDeces();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(acteDecesService.count());
        statisiqueAbstract.setNombreParUtilisateur(acteDecesService.countByUser());

        statistiaqueDeces.setNombre(statisiqueAbstract);

        return statistiaqueDeces;
    }

    private StatistiqueBulletinNaiss getStatistiqueBulletinNaiss() {
        StatistiqueBulletinNaiss statistiqueBulletinNaiss = new StatistiqueBulletinNaiss();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(bulletinNaissanceService.count());
        statisiqueAbstract.setNombreParUtilisateur(bulletinNaissanceService.countByUser());

        statistiqueBulletinNaiss.setNombre(statisiqueAbstract);

        return statistiqueBulletinNaiss;
    }



}
