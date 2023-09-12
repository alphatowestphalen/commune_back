package com.back.commune.request;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;

public class ActeCelibataireRequest {


	private String nomFkt;

	private String numCin;

	private String dateCin;

	private String lieuCin;

	private String dateActe;

    private String idPremierCopie;

	public String getNomFkt() {
		return nomFkt;
	}

	public void setNomFkt(String nomFkt) {
		this.nomFkt = nomFkt;
	}

	public String getNumCin() {
		return numCin;
	}

	public void setNumCin(String numCin) {
		this.numCin = numCin;
	}

	public String getDateCin() {
		return dateCin;
	}

	public void setDateCin(String dateCin) {
		this.dateCin = dateCin;
	}

	public String getLieuCin() {
		return lieuCin;
	}

	public void setLieuCin(String lieuCin) {
		this.lieuCin = lieuCin;
	}

	public String getDateActe() {
		return dateActe;
	}

	public void setDateActe(String dateActe) {
		this.dateActe = dateActe;
	}

    public String getIdPremierCopie() {
        return idPremierCopie;
    }

    public void setIdPremierCopie(String idPremierCopie) {
        this.idPremierCopie = idPremierCopie;
    }
}
