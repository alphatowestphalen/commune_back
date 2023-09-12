package com.back.commune.service;

import com.back.commune.model.Defunt;
import com.back.commune.repository.DefuntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefuntService {

    private final DefuntRepository defuntDao;

    @Autowired
    public DefuntService(DefuntRepository defuntDao) {
        this.defuntDao = defuntDao;
    }

    public Defunt save(Defunt defunt) {
        return defuntDao.save(defunt);
    }
}
