package com.back.commune.service;

import com.back.commune.exceptions.NotFoundDataException;
import com.back.commune.model.Maire;
import com.back.commune.repository.MaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MaireService {
    private final MaireRepository maireRepository;


    @Autowired
    public MaireService(MaireRepository maireRepository) {
        this.maireRepository = maireRepository;
    }

    public Maire findById(long idMaire) {
        Optional<Maire> maireOptional =  maireRepository.findById(idMaire);
        return maireOptional.orElseThrow(()-> new NotFoundDataException("Maire not found"));
    }

}
