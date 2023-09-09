package com.example.demo.service;
import com.example.demo.model.Adoption;
import com.example.demo.repository.AdoptionRepository;
import com.example.demo.utils.ResponsePageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

@Controller
public class AdoptionService {

    private final AdoptionRepository adoptionRepository;

    @Autowired
    public AdoptionService(AdoptionRepository adoptionRepository) {
        this.adoptionRepository = adoptionRepository;
    }

    public ResponsePageable<Adoption> getAll(Pageable pageable) {
        Page<Adoption> adoptionPage  = adoptionRepository.findAll(pageable);
        return new ResponsePageable<>(adoptionPage);
    }
}
