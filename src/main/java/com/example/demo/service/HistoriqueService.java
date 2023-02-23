package com.example.demo.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Historique;
import com.example.demo.repository.HistoriqueRepository;
@Service
public class HistoriqueService {
	@Autowired
	private HistoriqueRepository historiqueRepository;
	
	public Historique ajoutHistorique(String idEntity, String entity,  String oldValue, String newValue, String action, Instant createdDate)
	{
		Historique historique = new Historique(idEntity, entity, oldValue, newValue, action, createdDate);
		return this.historiqueRepository.save(historique);
	}

}
