package com.example.demo.service;

import com.example.demo.exceptions.NotFoundDataException;
import com.example.demo.model.Jugement;
import com.example.demo.model.PremierCopie;
import com.example.demo.model.auth.User;
import com.example.demo.repository.JugementRepository;
import com.example.demo.request.JugementRequest;
import com.example.demo.security.services.UserService;
import com.example.demo.utils.ResponsePageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
public class JugementService {

    private final JugementRepository jugementRepository;
    private final PremierCopieService premierCopieService;
    private final UserService userService;

    @Autowired
    public JugementService(JugementRepository jugementRepository,
                           PremierCopieService premierCopieService,
                           UserService userService) {
        this.jugementRepository = jugementRepository;
        this.premierCopieService = premierCopieService;
        this.userService = userService;
    }

    public ResponsePageable<Jugement> getAll(Pageable pageable) {
        Page<Jugement> jugementPage = jugementRepository.findAll(pageable);
        return new ResponsePageable<>(jugementPage);
    }

    public Jugement findById(Long id) {
        return jugementRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found Jugement with id = " + id));
    }

    @Transactional
    public Jugement save(JugementRequest jugementRequest) {
        User user =  userService.getAuthenticatedUser();
        if (user == null) throw new NotFoundDataException("Not found User authenticated");
        PremierCopie premierCopie = premierCopieService.findById(jugementRequest.getIdPremierCopie());
        if(premierCopie == null) throw new NotFoundDataException("Not found PremierCopie with id = " + jugementRequest.getIdPremierCopie());
        Jugement jugement = new Jugement(
            jugementRequest.getNumJugement(),
            jugementRequest.getDecretJuridique(),
            jugementRequest.getDateDecret(),
            jugementRequest.getTypeJugement(),
            jugementRequest.getInfoChangement(),
            premierCopie);
        jugement.setCreatedBy(user);
        return jugementRepository.save(jugement);
    }

    @Transactional
    public Jugement update(Long id ,  JugementRequest jugementRequest){
        Jugement jugement = findById(id);
        if(jugement == null) throw new NotFoundDataException("Not found Jugement with id = " + id);

        User user =  userService.getAuthenticatedUser();
        if (user == null) throw new NotFoundDataException("Not found User authenticated");

        jugement.setDecretJuridique(jugementRequest.getDecretJuridique());
        jugement.setDateDecret(jugementRequest.getDateDecret());
        jugement.setTypeJugement(jugementRequest.getTypeJugement());
        jugement.setInfoChangement(jugementRequest.getInfoChangement());

        return jugementRepository.save(jugement);
    }

    @Transactional
    public void delete(Long id) {
        Jugement jugement = findById(id);
        if(jugement == null) throw new NotFoundDataException("Not found Jugement with id = " + id);
        jugementRepository.delete(jugement);
    }
}
