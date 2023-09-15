package com.back.commune.service;

import com.back.commune.DTO.resulSet.CountByUser;
import com.back.commune.repository.PremierCopieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PremierCopieStatService {
    private final PremierCopieRepository premierCopieRepository;
    public Long count(){
        return premierCopieRepository.count();
    }

    public List<CountByUser> countByUser(){
        return premierCopieRepository.countByUser();
    }
    public List<CountByUser> countDeletedByUser(){
        return premierCopieRepository.countDeletedByUser();
    }

}
