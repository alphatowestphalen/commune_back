package com.back.commune.service;
import com.back.commune.DTO.StatisiqueAbstract;
import com.back.commune.DTO.StatistiqueAdoption;
import com.back.commune.DTO.resulSet.CountByUser;
import com.back.commune.exceptions.NotFoundDataException;
import com.back.commune.model.Adoption;
import com.back.commune.model.PremierCopie;
import com.back.commune.model.auth.User;
import com.back.commune.repository.AdoptionRepository;
import com.back.commune.utils.ResponsePageable;
import com.back.commune.request.AdoptionRequest;
import com.back.commune.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

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
            premierCopie
        );
        adoption.setCreatedBy(user);
        return adoptionRepository.save(adoption);
    }

    public Adoption update(Long id, AdoptionRequest request) {
        Adoption adoption = getById(id);
        User user = userService.getAuthenticatedUser();
        if (user == null) throw new NotFoundDataException("Not found User authenticated");
        if(adoption == null) throw new NotFoundDataException("Not found Adoption with id = " + id);
        adoption.setParentAdoptif(request.getParentAdoptif());
        adoption.setDateAdoption(request.getDateAdoption());
        adoption.setHeureAdoption(request.getHeureAdoption());
        return adoptionRepository.save(adoption);
    }

    public void delete(Long id) {
        Adoption adoption = getById(id);
        if(adoption == null) throw new NotFoundDataException("Not found Adoption with id = " + id);
        adoptionRepository.delete(adoption);
    }

    public Long count() {
        return adoptionRepository.count();
    }

    public List<CountByUser> countByUser() {
        return adoptionRepository.countByUser();
    }

    public StatistiqueAdoption getStatistiqueAdoption() {
        StatistiqueAdoption statistiqueAdoption = new StatistiqueAdoption();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(adoptionRepository.count());
        statisiqueAbstract.setNombreParUtilisateur(adoptionRepository.countByUser());

        statistiqueAdoption.setNombre(statisiqueAbstract);

        return statistiqueAdoption;
    }

    public StatistiqueAdoption getStatistiqueAdoptionDays(Date day) {
        StatistiqueAdoption statistiqueAdoption = new StatistiqueAdoption();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(adoptionRepository.countByDays(day));
        statisiqueAbstract.setNombreParUtilisateur(adoptionRepository.countByUserDay(day));

        statistiqueAdoption.setNombre(statisiqueAbstract);

        return statistiqueAdoption;
    }

    public StatistiqueAdoption getStatistiqueAdoptionDays(Date day1, Date day2) {
        StatistiqueAdoption statistiqueAdoption = new StatistiqueAdoption();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(adoptionRepository.countByDays(day1, day2));
        statisiqueAbstract.setNombreParUtilisateur(adoptionRepository.countByUserDay(day1, day2));

        statistiqueAdoption.setNombre(statisiqueAbstract);

        return statistiqueAdoption;
    }

    public StatistiqueAdoption getStatistiqueAdoptionMonth(Integer month, Integer Year) {
        StatistiqueAdoption statistiqueAdoption = new StatistiqueAdoption();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(adoptionRepository.countByMonth(month, Year));
        statisiqueAbstract.setNombreParUtilisateur(adoptionRepository.countByUserMonth(month, Year));

        statistiqueAdoption.setNombre(statisiqueAbstract);

        return statistiqueAdoption;
    }

    public StatistiqueAdoption getStatistiqueAdoptionYear(Integer Year) {
        StatistiqueAdoption statistiqueAdoption = new StatistiqueAdoption();
        StatisiqueAbstract statisiqueAbstract = new StatisiqueAbstract();

        statisiqueAbstract.setNombre(adoptionRepository.countByYear(Year));
        statisiqueAbstract.setNombreParUtilisateur(adoptionRepository.countByUserYear(Year));

        statistiqueAdoption.setNombre(statisiqueAbstract);

        return statistiqueAdoption;
    }

    public ResponsePageable<Adoption> getSearchAll(String query, Pageable pageable) {
        Page<Adoption> adoptionPage  = adoptionRepository.findSearchAll(query, pageable);
        return new ResponsePageable<>(adoptionPage);
    }
}
