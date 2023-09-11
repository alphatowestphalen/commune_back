package com.example.demo.service;

import com.example.demo.exceptions.NotFoundDataException;
import com.example.demo.model.BulletinNaissance;
import com.example.demo.model.PremierCopie;
import com.example.demo.model.auth.User;
import com.example.demo.repository.BulletinNaissanceRepository;
import com.example.demo.request.BulletinNaissanceRequest;
import com.example.demo.security.services.UserService;
import com.example.demo.utils.ResponsePageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

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
}
