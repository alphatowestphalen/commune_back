package com.back.commune.service;

import com.back.commune.DTO.StatisiqueAbstract;
import com.back.commune.DTO.StatistiqueReconnaissance;
import com.back.commune.DTO.resulSet.CountByUser;
import com.back.commune.exceptions.NotFoundDataException;
import com.back.commune.model.auth.User;
import com.back.commune.model.PremierCopie;
import com.back.commune.model.Reconnaissance;
import com.back.commune.repository.ReconnaissanceRepository;
import com.back.commune.request.ReconnaissanceRequest;
import com.back.commune.security.services.UserService;
import com.back.commune.utils.ResponsePageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ReconnaissanceService {

    private final ReconnaissanceRepository reconnaissanceRepository;
    private final PremierCopieService premierCopieService;
    private final UserService userService;


    @Autowired
    public ReconnaissanceService(
        ReconnaissanceRepository reconnaissanceRepository,
        PremierCopieService premierCopieService, UserService userService)
    {
        this.reconnaissanceRepository = reconnaissanceRepository;
        this.premierCopieService = premierCopieService;
        this.userService = userService;
    }

    public ResponsePageable<Reconnaissance> getAll(Pageable pageable) {
        Page<Reconnaissance> reconnaissancePage = reconnaissanceRepository.findAll(pageable);
        reconnaissancePage.getContent().forEach(e-> System.out.println(e.getPremierecopie().getEnfant().getNomEnfant()));
        return new ResponsePageable<Reconnaissance>(reconnaissancePage);
    }

    public Reconnaissance findById(Long id) {
        return reconnaissanceRepository.findById(id).orElseThrow(() -> new NotFoundDataException("Not found Reconnaissance with id = " + id));
    }

    @Transactional
    public  Reconnaissance save(ReconnaissanceRequest reconnaissanceRequest) {
        PremierCopie premierCopie = premierCopieService.findById(reconnaissanceRequest.getIdPremierCopie());
        if (premierCopie == null)
            throw new NotFoundDataException("Not found PremierCopie with id = " + reconnaissanceRequest.getIdPremierCopie());

        User user = userService.getAuthenticatedUser();
        if (user == null) throw new NotFoundDataException("Not found User authenticated");

        Reconnaissance reconnaissance = new Reconnaissance(
            reconnaissanceRequest.getDateDeclaration(),
            reconnaissanceRequest.getHeureDeclaration(),
            reconnaissanceRequest.getInfoPersonDeclarant(),
            premierCopie
        );
        System.out.println("reco : "+reconnaissance.getInfoPersonDeclarant());
        reconnaissance.setCreatedBy(user);
        return reconnaissanceRepository.save(reconnaissance);
    }

    public Reconnaissance update(Long id, ReconnaissanceRequest reconnaissanceRequest){
        Reconnaissance reconnaissance = findById(id);
        if(reconnaissance == null) throw new NotFoundDataException("Not found Reconnaissance with id = " + id);

        User user = userService.getAuthenticatedUser();
        if(user == null) throw new NotFoundDataException("Not found User authenticated");

        reconnaissance.setDateDeclaration(reconnaissanceRequest.getDateDeclaration());
        reconnaissance.setHeureDeclaration(reconnaissanceRequest.getHeureDeclaration());
        reconnaissance.setInfoPersonDeclarant(reconnaissanceRequest.getInfoPersonDeclarant());

        reconnaissance.setCreatedBy(user);

        return reconnaissanceRepository.save(reconnaissance);
    }

    public void delete(Long id) {
        Reconnaissance reconnaissance = findById(id);
        if(reconnaissance == null) throw new NotFoundDataException("Not found Reconnaissance with id = " + id);
        reconnaissanceRepository.delete(reconnaissance);
    }

    public StatistiqueReconnaissance getStatistiqueReconnaissance() {
        StatistiqueReconnaissance statistiqueReconnaissance = new StatistiqueReconnaissance();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(reconnaissanceRepository.count());
        statisiqueAbstract.setNombreParUtilisateur(reconnaissanceRepository.countByUser());

        statistiqueReconnaissance.setNombre(statisiqueAbstract);

        return statistiqueReconnaissance;
    }
    public StatistiqueReconnaissance getStatistiqueReconnaissanceDays(Date date) {
        StatistiqueReconnaissance statistiqueReconnaissance = new StatistiqueReconnaissance();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(reconnaissanceRepository.countByDays(date));
        statisiqueAbstract.setNombreParUtilisateur(reconnaissanceRepository.countByUserDay(date));

        statistiqueReconnaissance.setNombre(statisiqueAbstract);

        return statistiqueReconnaissance;
    }

    public StatistiqueReconnaissance getStatistiqueReconnaissanceDays(Date date1, Date date2) {
        StatistiqueReconnaissance statistiqueReconnaissance = new StatistiqueReconnaissance();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(reconnaissanceRepository.countByDays(date1,date2));
        statisiqueAbstract.setNombreParUtilisateur(reconnaissanceRepository.countByUserDay(date1, date2));

        statistiqueReconnaissance.setNombre(statisiqueAbstract);

        return statistiqueReconnaissance;
    }

    public StatistiqueReconnaissance getStatistiqueReconnaissanceMonth(Integer month, Integer year) {
        StatistiqueReconnaissance statistiqueReconnaissance = new StatistiqueReconnaissance();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(reconnaissanceRepository.countByMonth(month, year));
        statisiqueAbstract.setNombreParUtilisateur(reconnaissanceRepository.countByUserMonth(month, year));

        statistiqueReconnaissance.setNombre(statisiqueAbstract);

        return statistiqueReconnaissance;
    }

    public StatistiqueReconnaissance getStatistiqueReconnaissanceYear(Integer year) {
        StatistiqueReconnaissance statistiqueReconnaissance = new StatistiqueReconnaissance();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(reconnaissanceRepository.countByYear(year));
        statisiqueAbstract.setNombreParUtilisateur(reconnaissanceRepository.countByUserYear(year));

        statistiqueReconnaissance.setNombre(statisiqueAbstract);

        return statistiqueReconnaissance;
    }
}
