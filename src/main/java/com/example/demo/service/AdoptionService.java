package com.example.demo.service;
import com.example.demo.exceptions.NotFoundDataException;
import com.example.demo.model.Adoption;
import com.example.demo.model.PremierCopie;
import com.example.demo.model.auth.User;
import com.example.demo.repository.AdoptionRepository;
import com.example.demo.request.AdoptionRequest;
import com.example.demo.security.services.UserService;
import com.example.demo.utils.ResponsePageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
public class AdoptionService {

    private final AdoptionRepository adoptionRepository;
    private final PremierCopieService premierCopieService;

    private final UserService userService;

    @Autowired
    public AdoptionService(
        AdoptionRepository adoptionRepository,
        PremierCopieService premierCopieService,
        UserService userService
    )
    {
        this.adoptionRepository = adoptionRepository;
        this.premierCopieService = premierCopieService;
        this.userService = userService;
    }

    public ResponsePageable<Adoption> getAll(Pageable pageable) {
        Page<Adoption> adoptionPage  = adoptionRepository.findAll(pageable);
        return new ResponsePageable<>(adoptionPage);
    }

    public Adoption getById(Long id) {
        return adoptionRepository.findById(id).orElseThrow(() -> new NotFoundDataException("Not found Adoption with id = " + id));
    }
    @Transactional
    public Adoption save(AdoptionRequest adoptionRequest) {
        PremierCopie premierCopie = premierCopieService.findById(adoptionRequest.getIdPremierCopie());
        if(premierCopie == null) throw new NotFoundDataException("Not found PremierCopie with id = " + adoptionRequest.getIdPremierCopie());
        User user = userService.getAuthenticatedUser();
        if (user == null) throw new NotFoundDataException("Not found User authenticated");
        Adoption adoption = new Adoption(
            adoptionRequest.getParentAdoptif(),
            adoptionRequest.getDateAdoption(),
            adoptionRequest.getHeureAdoption(),
            adoptionRequest.getNumAdoption(),
            adoptionRequest.getCreatedDate(),
            premierCopie
        );
        adoption.setCreatedBy(user);
        return adoptionRepository.save(adoption);
    }
}
