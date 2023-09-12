package com.back.commune.repository;

import java.time.LocalDate;

import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository {
    public int year=LocalDate.now().getYear();

	public String PremierCopie= "Premier Copie";
	public String Mariage= "Mariage";
	public String Deces= "Deces";
	public String AjoutPremierCopie = "Ajouter Premier Copie";
}
