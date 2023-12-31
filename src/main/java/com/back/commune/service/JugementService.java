package com.back.commune.service;

import com.back.commune.DTO.StatisiqueAbstract;
import com.back.commune.DTO.StatistiqueJugement;
import com.back.commune.DTO.resulSet.CountByUser;
import com.back.commune.exceptions.NotFoundDataException;
import com.back.commune.model.PremierCopie;
import com.back.commune.model.auth.User;
import com.back.commune.repository.JugementRepository;
import com.back.commune.utils.ResponsePageable;
import com.back.commune.model.Jugement;
import com.back.commune.request.JugementRequest;
import com.back.commune.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

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

    public Jugement save(JugementRequest jugementRequest) {
        try {
            User user = userService.getAuthenticatedUser();
            if (user == null) throw new NotFoundDataException("Not found User authenticated");
            PremierCopie premierCopie = premierCopieService.findById(jugementRequest.getIdPremierCopie());
            if (premierCopie == null)
                throw new NotFoundDataException("Not found PremierCopie with id = " + jugementRequest.getIdPremierCopie());
            Jugement jugement = new Jugement(
                jugementRequest.getNumJugement(),
                jugementRequest.getDecretJuridique(),
                jugementRequest.getDateDecret(),
                jugementRequest.getTypeJugement(),
                jugementRequest.getInfoChangement(),
                premierCopie);
            jugement.setCreatedBy(user);
            return jugementRepository.save(jugement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

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

    public ResponsePageable<PremierCopie> getAllPremierCopieNotHaveJugement(Pageable pageable){
        Page<PremierCopie> premierCopiePage = jugementRepository.getAllPremierCopieNotHaveJugement(pageable);
        return new ResponsePageable<>(premierCopiePage);
    }

    public void delete(Long id) {
        Jugement jugement = findById(id);
        if(jugement == null) throw new NotFoundDataException("Not found Jugement with id = " + id);
        jugementRepository.delete(jugement);
    }

    public ResponsePageable<PremierCopie> getAllPremierCopieHaveJugement(Pageable pageable) {
        Page<PremierCopie> premierCopiePage = jugementRepository.getAllPremierCopieHaveJugement(pageable);
        return new ResponsePageable<>(premierCopiePage);
    }

    public Long count() {
        return jugementRepository.count();
    }

    public List<CountByUser> countByUser() {
        return jugementRepository.countByUser();
    }

    public StatistiqueJugement getStatistiqueJugement() {
        StatistiqueJugement statiqueJugement = new StatistiqueJugement();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(jugementRepository.count());
        statisiqueAbstract.setNombreParUtilisateur(jugementRepository.countByUser());

        statiqueJugement.setNombre(statisiqueAbstract);

        return statiqueJugement;
    }

    public StatistiqueJugement getStatistiqueJugementDays(Date day) {
        StatistiqueJugement statiqueJugement = new StatistiqueJugement();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(jugementRepository.countByDays(day));
        statisiqueAbstract.setNombreParUtilisateur(jugementRepository.countByUserDay(day));

        statiqueJugement.setNombre(statisiqueAbstract);

        return statiqueJugement;
    }

    public StatistiqueJugement getStatistiqueJugementDays(Date day1, Date day2) {
        StatistiqueJugement statiqueJugement = new StatistiqueJugement();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(jugementRepository.countByDays(day1, day2));
        statisiqueAbstract.setNombreParUtilisateur(jugementRepository.countByUserDay(day1, day2));

        statiqueJugement.setNombre(statisiqueAbstract);

        return statiqueJugement;
    }

    public StatistiqueJugement getStatistiqueJugementMonth(Integer month, Integer year) {
        StatistiqueJugement statiqueJugement = new StatistiqueJugement();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(jugementRepository.countByMonth(month, year));
        statisiqueAbstract.setNombreParUtilisateur(jugementRepository.countByUserMonth(month, year));

        statiqueJugement.setNombre(statisiqueAbstract);

        return statiqueJugement;
    }
    public StatistiqueJugement getStatistiqueJugementYear( Integer year) {
        StatistiqueJugement statiqueJugement = new StatistiqueJugement();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(jugementRepository.countByYear(year));
        statisiqueAbstract.setNombreParUtilisateur(jugementRepository.countByUserYear(year));

        statiqueJugement.setNombre(statisiqueAbstract);

        return statiqueJugement;
    }


    public ResponsePageable<Jugement> getAllSearch(String query, Pageable paging) {
        Page<Jugement> jugementPage = jugementRepository.findAllSearch(query, paging);
        return new ResponsePageable<>(jugementPage);
    }
}
