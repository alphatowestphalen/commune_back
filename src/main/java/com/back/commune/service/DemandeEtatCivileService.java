package com.back.commune.service;

import com.back.commune.exceptions.NotFoundDataException;
import com.back.commune.model.PremierCopie;
import com.back.commune.model.auth.User;
import com.back.commune.model.demande.DemandeEtatCivile;
import com.back.commune.repository.DemandeEtatCivileRepository;
import com.back.commune.request.DemandeEtatCivileRequest;
import com.back.commune.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DemandeEtatCivileService {
    private final DemandeEtatCivileRepository demandeEtatCivileRepository;
    private final PremierCopieService premierCopieService;
    private final UserService userService;

    @Autowired
    public DemandeEtatCivileService(DemandeEtatCivileRepository demandeEtatCivileRepository, PremierCopieService premierCopieService, UserService userService) {
        this.demandeEtatCivileRepository = demandeEtatCivileRepository;
        this.premierCopieService = premierCopieService;
        this.userService = userService;
    }

    public Page<DemandeEtatCivile> getAllDemandeEtatCivils(Pageable pageable) {
        return demandeEtatCivileRepository.findAllNotSigned(pageable);
    }
    public Page<DemandeEtatCivile> getAllDemandeEtatCivils(Date date,  Pageable pageable) {
        return demandeEtatCivileRepository.findAllNotSigned(date, pageable);
    }

    public Page<DemandeEtatCivile> getAllDemandeEtatMonth(Date date,  Pageable pageable) {
        return demandeEtatCivileRepository.findAllByMonth(date, pageable);
    }
    public Page<DemandeEtatCivile> getAllDemandeEtatMonth(String month, String year,  Pageable pageable) {
        return demandeEtatCivileRepository.findAllByMonth(month,year, pageable);
    }

    public Page<DemandeEtatCivile> getAllDemandeEtatYear(Date date,  Pageable pageable) {
        return demandeEtatCivileRepository.findAllByYear(date, pageable);
    }

    public Page<DemandeEtatCivile> getAllDemandeEtatYear(String year,  Pageable pageable) {
        return demandeEtatCivileRepository.findAllByYear(year, pageable);
    }

    public DemandeEtatCivile addDemandeEtatCivil(DemandeEtatCivileRequest demandeEtatCivileRequest) {
        DemandeEtatCivile demandeEtatCivile = new DemandeEtatCivile();
        PremierCopie premierCopie = premierCopieService.findById(demandeEtatCivileRequest.getIdPremierCopie());
        if(premierCopie == null) throw new NotFoundDataException("Premier Copie Not Found");
        User user  = userService.getAuthenticatedUser();
        if (user == null) throw new NotFoundDataException("User who created Not Found");
        demandeEtatCivile.setPremierCopie(premierCopie);
        demandeEtatCivile.setTypeDemande(demandeEtatCivileRequest.getTypeDemande());
        demandeEtatCivile.setCreatedBy(user);

        return demandeEtatCivileRepository.save(demandeEtatCivile);
    }

    public DemandeEtatCivile setSignedByMaire(String id) {
        User user = userService.getAuthenticatedUser();
        if("Maire".equalsIgnoreCase(user.roles.getName())){
            return demandeEtatCivileRepository.setSigned(id, Long.toString(user.getId()));
        }
        throw new RuntimeException("You must be an Maire to sign this demande");
    }

    private DemandeEtatCivile findById(Long id) {
        return demandeEtatCivileRepository.findById(id).orElseThrow(() -> new NotFoundDataException("Demande Not Found"));
    }
}
