package com.back.commune.service;

import com.back.commune.DTO.StatisiqueAbstract;
import com.back.commune.DTO.StatistiqueBulletinNaiss;
import com.back.commune.DTO.resulSet.CountByUser;
import com.back.commune.exceptions.NotFoundDataException;
import com.back.commune.model.BulletinNaissance;
import com.back.commune.model.auth.User;
import com.back.commune.repository.BulletinNaissanceRepository;
import com.back.commune.request.BulletinNaissanceRequest;
import com.back.commune.model.PremierCopie;
import com.back.commune.security.services.UserService;
import com.back.commune.utils.ResponsePageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Controller
public class BulletinNaissanceService {

    private final BulletinNaissanceRepository bulletinNaissanceRepository;
    private final UserService userService;

    private final PremierCopieService premierCopieService;


    @Autowired
    public BulletinNaissanceService(BulletinNaissanceRepository bulletinNaissanceRepository, UserService userService, PremierCopieService premierCopieService) {
        this.bulletinNaissanceRepository = bulletinNaissanceRepository;
        this.userService = userService;
        this.premierCopieService = premierCopieService;
    }


    public ResponsePageable<BulletinNaissance> findAll(Pageable pageable) {
        Page<BulletinNaissance> responsePage = bulletinNaissanceRepository.findAll(pageable);
        return new ResponsePageable<BulletinNaissance>(responsePage);
    }

    public BulletinNaissance findById(String id) {
        return findById(Long.parseLong(id));
    }
    public BulletinNaissance findById(Long id) {
        return bulletinNaissanceRepository.findById(id).orElseThrow(()-> new NotFoundDataException("Not found Bulletin de Naissance with id = " + id));
    }

    public BulletinNaissance findByNumeroPremierCopie(String idPremierCopie) {
        BulletinNaissance bulletinNaissance = bulletinNaissanceRepository.findByIdPremierCopie(idPremierCopie);
        return bulletinNaissance;
    }

    public void delete(Long numBulletin){
        BulletinNaissance bulletinNaissance = findById(numBulletin);
        bulletinNaissanceRepository.delete(bulletinNaissance);
    }

    @Transactional
    public BulletinNaissance save(BulletinNaissanceRequest request) {
        User user = userService.getAuthenticatedUser();
        if(user == null) throw new NotFoundDataException("User not found");
        BulletinNaissance bulletin = new BulletinNaissance();
        if(request.getIdPremierCopie()!=null) {
            PremierCopie premierCopie = premierCopieService.findById(request.getIdPremierCopie());
            if (premierCopie == null) throw new NotFoundDataException("PremierCopie not found");
            bulletin.setIdPremierCopie(premierCopie);
        }
        bulletin.setNomPersonne(request.getNomPersonne());
        bulletin.setType(request.getType());
        bulletin.setPrenomsPersonne(request.getPrenomsPersonne());
        bulletin.setDateNaissPersonne(request.getDateNaissPersonne());
        bulletin.setLieuNaissPersonne(request.getLieuNaissPersonne());
        bulletin.setNomPere(request.getNomPere());
        bulletin.setPrenomsPere(request.getPrenomsPere());
        bulletin.setNomMere(request.getNomMere());
        bulletin.setPrenomsMere(request.getPrenomsMere());
        bulletin.setDateCopie(request.getDateCopie());
        bulletin.setCreatedBy(user);
        return bulletinNaissanceRepository.save(bulletin);
    }

    public BulletinNaissance update(Long id , BulletinNaissanceRequest request) {
        User user = userService.getAuthenticatedUser();
        if(user == null) throw new NotFoundDataException("User not found");

        BulletinNaissance bulletin = findById(id);

        bulletin.setNomPersonne(request.getNomPersonne());
        bulletin.setPrenomsPersonne(request.getPrenomsPersonne());
        bulletin.setDateNaissPersonne(request.getDateNaissPersonne());
        bulletin.setLieuNaissPersonne(request.getLieuNaissPersonne());
        bulletin.setNomPere(request.getNomPere());
        bulletin.setType(request.getType());
        bulletin.setPrenomsPere(request.getPrenomsPere());
        bulletin.setNomMere(request.getNomMere());
        bulletin.setPrenomsMere(request.getPrenomsMere());
        bulletin.setDateCopie(request.getDateCopie());
        bulletin.setCreatedBy(user);

        return bulletinNaissanceRepository.save(bulletin);
    }

    public Long count() {
        return bulletinNaissanceRepository.count();
    }

    public StatistiqueBulletinNaiss getStatistiqueBulletinNaiss() {
        StatistiqueBulletinNaiss statistiqueBulletinNaiss = new StatistiqueBulletinNaiss();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(bulletinNaissanceRepository.count());
        statisiqueAbstract.setNombreParUtilisateur(bulletinNaissanceRepository.countByUser());

        statistiqueBulletinNaiss.setNombre(statisiqueAbstract);

        return statistiqueBulletinNaiss;
    }

    public StatistiqueBulletinNaiss getStatistiqueBulletinNaissDays(Date day) {
        StatistiqueBulletinNaiss statistiqueBulletinNaiss = new StatistiqueBulletinNaiss();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(bulletinNaissanceRepository.countByDays(day));
        statisiqueAbstract.setNombreParUtilisateur(bulletinNaissanceRepository.countByUserDay(day));

        statistiqueBulletinNaiss.setNombre(statisiqueAbstract);

        return statistiqueBulletinNaiss;
    }

    public StatistiqueBulletinNaiss getStatistiqueBulletinNaissDays(Date day1, Date day2) {
        StatistiqueBulletinNaiss statistiqueBulletinNaiss = new StatistiqueBulletinNaiss();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(bulletinNaissanceRepository.countByDays(day1, day2));
        statisiqueAbstract.setNombreParUtilisateur(bulletinNaissanceRepository.countByUserDay(day1, day2));

        statistiqueBulletinNaiss.setNombre(statisiqueAbstract);

        return statistiqueBulletinNaiss;
    }

    public StatistiqueBulletinNaiss getStatistiqueBulletinNaissMonth(String month, String year) {
        StatistiqueBulletinNaiss statistiqueBulletinNaiss = new StatistiqueBulletinNaiss();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(bulletinNaissanceRepository.countByMonth(month, year));
        statisiqueAbstract.setNombreParUtilisateur(bulletinNaissanceRepository.countByUserMonth(month, year));

        statistiqueBulletinNaiss.setNombre(statisiqueAbstract);

        return statistiqueBulletinNaiss;
    }

    public StatistiqueBulletinNaiss getStatistiqueBulletinNaissYear(String year) {
        StatistiqueBulletinNaiss statistiqueBulletinNaiss = new StatistiqueBulletinNaiss();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(bulletinNaissanceRepository.countByYear(year));
        statisiqueAbstract.setNombreParUtilisateur(bulletinNaissanceRepository.countByUserYear(year));

        statistiqueBulletinNaiss.setNombre(statisiqueAbstract);

        return statistiqueBulletinNaiss;
    }

}
