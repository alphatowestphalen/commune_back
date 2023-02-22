package com.example.demo.repository;


import java.time.Instant;
import java.time.format.DateTimeFormatter;

import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository {
	public String PremierCopie= "Premier Copie";
	public String Mariage= "Mariage";
	public String Deces= "Deces";
	public String AjoutPremierCopie = "Ajouter Premier Copie";
}
