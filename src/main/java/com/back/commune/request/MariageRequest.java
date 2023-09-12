package com.back.commune.request;
import com.fasterxml.jackson.annotation.JsonFormat;

public abstract class MariageRequest{

	// temoin Homme
	private String nomTemoinHomme;

	private String prenomsTemoinHomme;

	private String professionTemoinHomme;

	@JsonFormat(pattern ="dd/MM/yyyy")
	private String datenaissTemoinHomme;

	private String lieunaissTemoinHomme;

	private String adresseTemoinHomme;


	// Temoin Femme

	private String nomTemoinFemme;

	private String prenomsTemoinFemme;

	private String professionTemoinFemme;

	@JsonFormat(pattern ="dd/MM/yyyy")
	private String datenaissTemoinFemme;

	private String lieunaissTemoinFemme;

	private String adresseTemoinFemme;

	private String description;

    private String numeroCopieMariage;

	@JsonFormat(pattern ="dd/MM/yyyy")
	private String dateMariage;

	private String heureMariage;

	private long idMaire;

	public String getNomTemoinHomme() {
		return nomTemoinHomme;
	}

	public void setNomTemoinHomme(String nomTemoinHomme) {
		this.nomTemoinHomme = nomTemoinHomme;
	}

	public String getPrenomsTemoinHomme() {
		return prenomsTemoinHomme;
	}

	public void setPrenomsTemoinHomme(String prenomsTemoinHomme) {
		this.prenomsTemoinHomme = prenomsTemoinHomme;
	}

	public String getProfessionTemoinHomme() {
		return professionTemoinHomme;
	}

	public void setProfessionTemoinHomme(String professionTemoinHomme) {
		this.professionTemoinHomme = professionTemoinHomme;
	}

	public String getDatenaissTemoinHomme() {
		return datenaissTemoinHomme;
	}

	public void setDatenaissTemoinHomme(String datenaissTemoinHomme) {
		this.datenaissTemoinHomme = datenaissTemoinHomme;
	}

	public String getLieunaissTemoinHomme() {
		return lieunaissTemoinHomme;
	}

	public void setLieunaissTemoinHomme(String lieunaissTemoinHomme) {
		this.lieunaissTemoinHomme = lieunaissTemoinHomme;
	}

	public String getAdresseTemoinHomme() {
		return adresseTemoinHomme;
	}

	public void setAdresseTemoinHomme(String adresseTemoinHomme) {
		this.adresseTemoinHomme = adresseTemoinHomme;
	}

	public String getNomTemoinFemme() {
		return nomTemoinFemme;
	}

	public void setNomTemoinFemme(String nomTemoinFemme) {
		this.nomTemoinFemme = nomTemoinFemme;
	}

	public String getPrenomsTemoinFemme() {
		return prenomsTemoinFemme;
	}

	public void setPrenomsTemoinFemme(String prenomsTemoinFemme) {
		this.prenomsTemoinFemme = prenomsTemoinFemme;
	}

	public String getProfessionTemoinFemme() {
		return professionTemoinFemme;
	}

	public void setProfessionTemoinFemme(String professionTemoinFemme) {
		this.professionTemoinFemme = professionTemoinFemme;
	}

	public String getDatenaissTemoinFemme() {
		return datenaissTemoinFemme;
	}

	public void setDatenaissTemoinFemme(String datenaissTemoinFemme) {
		this.datenaissTemoinFemme = datenaissTemoinFemme;
	}

	public String getLieunaissTemoinFemme() {
		return lieunaissTemoinFemme;
	}

	public void setLieunaissTemoinFemme(String lieunaissTemoinFemme) {
		this.lieunaissTemoinFemme = lieunaissTemoinFemme;
	}

	public String getAdresseTemoinFemme() {
		return adresseTemoinFemme;
	}

	public void setAdresseTemoinFemme(String adresseTemoinFemme) {
		this.adresseTemoinFemme = adresseTemoinFemme;
	}




	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateMariage() {
		return dateMariage;
	}

	public void setDateMariage(String dateMariage) {
		this.dateMariage = dateMariage;
	}

	public String getHeureMariage() {
		return heureMariage;
	}

	public void setHeureMariage(String heureMariage) {
		this.heureMariage = heureMariage;
	}

	public long getIdMaire() {
		return idMaire;
	}

	public void setIdMaire(long idMaire) {
		this.idMaire = idMaire;
	}

    public String getNumeroCopieMariage() {
        return numeroCopieMariage;
    }

    public void setNumeroCopieMariage(String numeroCopieMariage) {
        this.numeroCopieMariage = numeroCopieMariage;
    }
}
