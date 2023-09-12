package com.back.commune.request;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;

public class ReconnaissanceRequest {

	private String dateDeclaration;

    private String idPremierCopie;

	private String heureDeclaration;

	private String infoPersonDeclarant;

	public String getDateDeclaration() {
		return dateDeclaration;
	}

	public void setDateDeclaration(String dateDeclaration) {
		this.dateDeclaration = dateDeclaration;
	}

	public String getHeureDeclaration() {
		return heureDeclaration;
	}

	public void setHeureDeclaration(String heureDeclaration) {
		this.heureDeclaration = heureDeclaration;
	}

	public String getInfoPersonDeclarant() {
		return infoPersonDeclarant;
	}

	public void setInfoPersonDeclarant(String infoPersonDeclarant) {
		this.infoPersonDeclarant = infoPersonDeclarant;
	}

    public String getIdPremierCopie() {
        return idPremierCopie;
    }

    public void setIdPremierCopie(String idPremierCopie) {
        this.idPremierCopie = idPremierCopie;
    }
}
