package com.back.commune.service;

import com.back.commune.DTO.ActeCelibataireDTO;
import com.back.commune.exceptions.NotFoundDataException;
import com.back.commune.model.PremierCopie;
import com.back.commune.model.auth.User;
import com.back.commune.model.mariage.GenreMariage;
import com.back.commune.repository.ActeCelibataireRepository;
import com.back.commune.repository.PremierCopieRepository;
import com.back.commune.repository.TypeRepository;
import com.back.commune.request.ActeCelibataireRequestE;
import com.back.commune.request.ActeCelibataireRequestI;
import com.back.commune.request.NumeroActeCelibataire;
import com.back.commune.security.services.UserService;
import com.back.commune.utils.ResponsePageable;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.back.commune.model.celibataire.ActeCelibataire;

import java.util.List;

@Service
@AllArgsConstructor
public class ActeCelibataireService {

    private final ActeCelibataireRepository acteCelibataireRepository;
    private final PremierCopieRepository premierCopieRepository;
    private final UserService userService;

    public ActeCelibataireDTO save(ActeCelibataireRequestI acteCelibataireRequestI) {
        User user = userService.getAuthenticatedUser();
        if (user == null) throw new NotFoundDataException("Not found User authenticated");
        PremierCopie premierCopie = premierCopieRepository.findByIdPremierCopie(acteCelibataireRequestI.getIdPremierCopie());
        if(premierCopie == null) throw new NotFoundDataException("Not found PremierCopie with id = " + acteCelibataireRequestI.getIdPremierCopie());
        ActeCelibataire acteCelibataire = new  ActeCelibataire();

        acteCelibataire.setLieuCin(acteCelibataireRequestI.getLieuCin());
        acteCelibataire.setNomFkt(acteCelibataireRequestI.getNomFkt());
        acteCelibataire.setNumCin(acteCelibataireRequestI.getNumCin());
        acteCelibataire.setDateCin(acteCelibataireRequestI.getDateCin());
        acteCelibataire.setPremierecopie(premierCopie);
        acteCelibataire.setNomPere(
            premierCopie.getPere().getNomPere() +" "+premierCopie.getPere().getPrenomsPere()
        );
        acteCelibataire.setGenre(
            premierCopie.getEnfant().getSexeEnfant().equals("fille")? GenreMariage.FEMME : GenreMariage.HOMME
        );
        acteCelibataire.setNomMere(
            premierCopie.getMere().getNomMere() +" "+premierCopie.getMere().getPrenomsMere()
        );
        acteCelibataire.setNom(premierCopie.getEnfant().getNomEnfant()+" "+premierCopie.getEnfant().getPrenomsEnfant());
        acteCelibataire.setDateDeNaiss(premierCopie.getEnfant().getDatenaissEnfant());
        acteCelibataire.setLieuDeNaiss(premierCopie.getEnfant().getLieunaissEnfant());
        acteCelibataire.setCreatedBy(user);

        return new ActeCelibataireDTO(acteCelibataireRepository.save(acteCelibataire));
    }

    public ActeCelibataireDTO save(ActeCelibataireRequestE acteCelibataireRequestE) {
        User user = userService.getAuthenticatedUser();
        if (user == null) throw new NotFoundDataException("Not found User authenticated");
        ActeCelibataire acteCelibataire = new  ActeCelibataire();

        acteCelibataire.setLieuCin(acteCelibataireRequestE.getLieuCin());
        acteCelibataire.setNom(acteCelibataireRequestE.getNom());
        acteCelibataire.setNomFkt(acteCelibataireRequestE.getNomFkt());
        acteCelibataire.setNumCin(acteCelibataireRequestE.getNumCin());
        acteCelibataire.setDateCin(acteCelibataireRequestE.getDateCin());
        acteCelibataire.setNomPere(acteCelibataireRequestE.getNomPere());
        acteCelibataire.setNomMere(acteCelibataireRequestE.getNomMere());
        acteCelibataire.setDateDeNaiss(acteCelibataireRequestE.getDateDeNaiss());
        acteCelibataire.setLieuDeNaiss(acteCelibataireRequestE.getLieuDeNaiss());
        acteCelibataire.setCreatedBy(user);

        return new ActeCelibataireDTO(acteCelibataireRepository.save(acteCelibataire));
    }


    public void delete(Long id) {
        acteCelibataireRepository.deleteById(id);
    }

    public ActeCelibataireDTO update(ActeCelibataireRequestI acteCelibataireRequestI, Long id) {
        User user = userService.getAuthenticatedUser();
        if (user == null) throw new NotFoundDataException("Not found User authenticated");
        ActeCelibataire acteCelibataire = acteCelibataireRepository
            .findById(id)
            .orElseThrow(() -> new NotFoundDataException("Not found acte de celibataire with id = " + id));;
        acteCelibataire.setLieuCin(acteCelibataireRequestI.getLieuCin());
        acteCelibataire.setNomFkt(acteCelibataireRequestI.getNomFkt());
        acteCelibataire.setNumCin(acteCelibataireRequestI.getNumCin());
        acteCelibataire.setDateCin(acteCelibataireRequestI.getDateCin());
        acteCelibataire.setCreatedBy(user);

        return new ActeCelibataireDTO(acteCelibataireRepository.save(acteCelibataire));
    }

    public ActeCelibataireDTO update(ActeCelibataireRequestE acteCelibataireRequestE, Long id) {
        User user = userService.getAuthenticatedUser();
        if (user == null) throw new NotFoundDataException("Not found User authenticated");
        ActeCelibataire acteCelibataire = acteCelibataireRepository
            .findById(id)
            .orElseThrow(() -> new NotFoundDataException("Not found acte de celibataire with id = " + id));;

        acteCelibataire.setLieuCin(acteCelibataireRequestE.getLieuCin());
        acteCelibataire.setNomFkt(acteCelibataireRequestE.getNomFkt());
        acteCelibataire.setNumCin(acteCelibataireRequestE.getNumCin());
        acteCelibataire.setGenre(acteCelibataireRequestE.getGenre());
        acteCelibataire.setNom(acteCelibataireRequestE.getNom());
        acteCelibataire.setDateCin(acteCelibataireRequestE.getDateCin());
        acteCelibataire.setNomPere(acteCelibataireRequestE.getNomPere());
        acteCelibataire.setNomMere(acteCelibataireRequestE.getNomMere());
        acteCelibataire.setDateDeNaiss(acteCelibataireRequestE.getDateDeNaiss());
        acteCelibataire.setLieuDeNaiss(acteCelibataireRequestE.getLieuDeNaiss());
        acteCelibataire.setCreatedBy(user);

        return new ActeCelibataireDTO(acteCelibataireRepository.save(acteCelibataire));
    }





    public ActeCelibataireDTO find(Long id) {
       ActeCelibataire acteCelibataire =  acteCelibataireRepository
            .findById(id)
            .orElseThrow(() -> new NotFoundDataException("Not found ActeCellibataire with id = " + id));
        return new ActeCelibataireDTO(acteCelibataire);
    }
    public ResponsePageable<ActeCelibataireDTO> findAll(Pageable pageable) {
        Page<ActeCelibataire> resultDB = acteCelibataireRepository.findAll(pageable);
        List<ActeCelibataireDTO> listDTO =  resultDB.getContent().
            stream().map(ActeCelibataireDTO::new).collect(java.util.stream.Collectors.toList());
        Page<ActeCelibataireDTO> page = new PageImpl<>(listDTO,pageable,resultDB.getTotalElements());
        return new ResponsePageable<>(page);
    }
}
