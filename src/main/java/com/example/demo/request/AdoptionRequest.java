package com.example.demo.request;

import java.time.Instant;
import java.util.ArrayList;

import org.springframework.data.annotation.CreatedDate;

public class AdoptionRequest {

    private String parentAdoptif;

    private String idPremierCopie;

    public String getIdPremierCopie() {
        return idPremierCopie;
    }

    public void setIdPremierCopie(String idPremierCopie) {
        this.idPremierCopie = idPremierCopie;
    }

    private String dateAdoption;

	private String heureAdoption;

	private String numAdoption;

	@CreatedDate
	private Instant createdDate;

	public String getParentAdoptif() {
		return parentAdoptif;
	}

	public void setParentAdoptif(String parentAdoptif) {
		this.parentAdoptif = parentAdoptif;
	}

	public String getDateAdoption() {
		return dateAdoption;
	}

	public void setDateAdoption(String dateAdoption) {
		this.dateAdoption = dateAdoption;
	}

	public String getHeureAdoption() {
		return heureAdoption;
	}

	public void setHeureAdoption(String heureAdoption) {
		this.heureAdoption = heureAdoption;
	}

	public String getNumAdoption() {
		return numAdoption;
	}

	public void setNumAdoption(String numAdoption) {
		this.numAdoption = numAdoption;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}
}
