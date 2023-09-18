package com.back.commune.service;

import com.back.commune.DTO.StatisiqueAbstract;
import com.back.commune.DTO.StatistiquePremierCopie;
import com.back.commune.DTO.resulSet.CountByUser;
import com.back.commune.repository.PremierCopieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PremierCopieStatService {
    private final PremierCopieRepository premierCopieRepository;
    public List<CountByUser> countDeletedByUser(){
        return premierCopieRepository.countDeletedByUser();
    }

    public StatistiquePremierCopie getStatistiquePremierCopie() {
        StatistiquePremierCopie statistiquePremierCopie = new StatistiquePremierCopie();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(premierCopieRepository.count());
        statisiqueAbstract.setNombreParUtilisateur(premierCopieRepository.countByUser());

        statistiquePremierCopie.setNombre(statisiqueAbstract);

        return statistiquePremierCopie;
    }

    public StatistiquePremierCopie getStatistiquePremierCopieDays(Date date){
        StatistiquePremierCopie statistiquePremierCopie = new StatistiquePremierCopie();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(premierCopieRepository.countByDays(date));
        statisiqueAbstract.setNombreParUtilisateur(premierCopieRepository.countByUserDay(date));

        statistiquePremierCopie.setNombre(statisiqueAbstract);

        return statistiquePremierCopie;
    }

    public StatistiquePremierCopie getStatistiquePremierCopieDays(Date date1, Date date2){
        StatistiquePremierCopie statistiquePremierCopie = new StatistiquePremierCopie();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(premierCopieRepository.countByDays(date1,date2));
        statisiqueAbstract.setNombreParUtilisateur(premierCopieRepository.countByUserDay(date1,date2));

        statistiquePremierCopie.setNombre(statisiqueAbstract);

        return statistiquePremierCopie;
    }

    public StatistiquePremierCopie getStatistiquePremierCopieMonth(String mois, String anne){
        StatistiquePremierCopie statistiquePremierCopie = new StatistiquePremierCopie();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(premierCopieRepository.countByMonth(mois,anne));
        statisiqueAbstract.setNombreParUtilisateur(premierCopieRepository.countByUserMonth(mois,anne));

        statistiquePremierCopie.setNombre(statisiqueAbstract);

        return statistiquePremierCopie;
    }

    public StatistiquePremierCopie getStatistiquePremierCopieYear(String anne){
        StatistiquePremierCopie statistiquePremierCopie = new StatistiquePremierCopie();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(premierCopieRepository.countByYear(anne));
        statisiqueAbstract.setNombreParUtilisateur(premierCopieRepository.countByUserYear(anne));

        statistiquePremierCopie.setNombre(statisiqueAbstract);

        return statistiquePremierCopie;
    }
}
