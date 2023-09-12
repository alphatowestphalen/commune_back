package com.back.commune.request;


import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PremierCopieRequest {



	private String description;

	private String mention;

	@JsonFormat(pattern ="dd/MM/yyyy")
	private String datePCopie;

	private String datePremierCopie;

	private String nomDeclarant;

	private String prenomsDeclarant;

	private String datenaissDeclarant;

	private String lieuNaissDeclarant;

	private String adressDeclarant;

	private String professionDeclarant;

	private String nomMere;

	private String prenomsMere;

	private String datenaissMere;

	private String lieuNaissMere;

	private String professionMere;

	private String adresseMere;

	private String nomPere;

	private String prenomsPere;

	private String datenaissPere;

	private String lieuNaissPere;

	private String professionPere;

	private String adressePere;

	private String nomEnfant;

	private String prenomsEnfant;

	private String datenaissEnfant;

	private String lieunaissEnfant;

	private String heurenaissEnfant;

	private String sexeEnfant;

	@JsonFormat(pattern ="dd/MM/yyyy")
	private String dateEnfant;

	private Boolean certificatAccouch;

	private Boolean livretFamille;

	private Boolean cinMere;

	private Boolean cinDeclarant;

	private long idMaire;

	@CreatedDate
	private Instant createdDate;

	private Boolean avoirPere;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMention() {
		return mention;
	}

	public void setMention(String mention) {
		this.mention = mention;
	}

	public String getDatePCopie() {
		return datePCopie;
	}

	public void setDatePCopie(String datePCopie) {
		this.datePCopie = datePCopie;
	}

	public String getDatePremierCopie() {
		return datePremierCopie;
	}

	public void setDatePremierCopie(String datePremierCopie) {
		this.datePremierCopie = datePremierCopie;
	}

	public String getNomDeclarant() {
		return nomDeclarant;
	}

	public void setNomDeclarant(String nomDeclarant) {
		this.nomDeclarant = nomDeclarant;
	}

	public String getPrenomsDeclarant() {
		return prenomsDeclarant;
	}

	public void setPrenomsDeclarant(String prenomsDeclarant) {
		this.prenomsDeclarant = prenomsDeclarant;
	}

	public String getDatenaissDeclarant() {
		return datenaissDeclarant;
	}

	public void setDatenaissDeclarant(String datenaissDeclarant) {
		this.datenaissDeclarant = datenaissDeclarant;
	}

	public String getLieuNaissDeclarant() {
		return lieuNaissDeclarant;
	}

	public void setLieuNaissDeclarant(String lieuNaissDeclarant) {
		this.lieuNaissDeclarant = lieuNaissDeclarant;
	}

	public String getAdressDeclarant() {
		return adressDeclarant;
	}

	public void setAdressDeclarant(String adressDeclarant) {
		this.adressDeclarant = adressDeclarant;
	}

	public String getProfessionDeclarant() {
		return professionDeclarant;
	}

	public void setProfessionDeclarant(String professionDeclarant) {
		this.professionDeclarant = professionDeclarant;
	}

	public String getNomMere() {
		return nomMere;
	}

	public void setNomMere(String nomMere) {
		this.nomMere = nomMere;
	}

	public String getPrenomsMere() {
		return prenomsMere;
	}

	public void setPrenomsMere(String prenomsMere) {
		this.prenomsMere = prenomsMere;
	}

	public String getDatenaissMere() {
		return datenaissMere;
	}

	public void setDatenaissMere(String datenaissMere) {
		this.datenaissMere = datenaissMere;
	}

	public String getLieuNaissMere() {
		return lieuNaissMere;
	}

	public void setLieuNaissMere(String lieuNaissMere) {
		this.lieuNaissMere = lieuNaissMere;
	}

	public String getProfessionMere() {
		return professionMere;
	}

	public void setProfessionMere(String professionMere) {
		this.professionMere = professionMere;
	}

	public String getAdresseMere() {
		return adresseMere;
	}

	public void setAdresseMere(String adresseMere) {
		this.adresseMere = adresseMere;
	}

	public String getNomPere() {
		return nomPere;
	}

	public void setNomPere(String nomPere) {
		this.nomPere = nomPere;
	}

	public String getPrenomsPere() {
		return prenomsPere;
	}

	public void setPrenomsPere(String prenomsPere) {
		this.prenomsPere = prenomsPere;
	}

	public String getDatenaissPere() {
		return datenaissPere;
	}

	public void setDatenaissPere(String datenaissPere) {
		this.datenaissPere = datenaissPere;
	}

	public String getLieuNaissPere() {
		return lieuNaissPere;
	}

	public void setLieuNaissPere(String lieuNaissPere) {
		this.lieuNaissPere = lieuNaissPere;
	}

	public String getProfessionPere() {
		return professionPere;
	}

	public void setProfessionPere(String professionPere) {
		this.professionPere = professionPere;
	}

	public String getAdressePere() {
		return adressePere;
	}

	public void setAdressePere(String adressePere) {
		this.adressePere = adressePere;
	}

	public String getNomEnfant() {
		return nomEnfant;
	}

	public void setNomEnfant(String nomEnfant) {
		this.nomEnfant = nomEnfant;
	}

	public String getPrenomsEnfant() {
		return prenomsEnfant;
	}

	public void setPrenomsEnfant(String prenomsEnfant) {
		this.prenomsEnfant = prenomsEnfant;
	}

	public String getDatenaissEnfant() {
		return datenaissEnfant;
	}

	public void setDatenaissEnfant(String datenaissEnfant) {
		this.datenaissEnfant = datenaissEnfant;
	}

	public String getLieunaissEnfant() {
		return lieunaissEnfant;
	}

	public void setLieunaissEnfant(String lieunaissEnfant) {
		this.lieunaissEnfant = lieunaissEnfant;
	}

	public String getHeurenaissEnfant() {
		return heurenaissEnfant;
	}

	public void setHeurenaissEnfant(String heurenaissEnfant) {
		this.heurenaissEnfant = heurenaissEnfant;
	}

	public String getSexeEnfant() {
		return sexeEnfant;
	}

	public void setSexeEnfant(String sexeEnfant) {
		this.sexeEnfant = sexeEnfant;
	}

	public String getDateEnfant() {
		return dateEnfant;
	}

	public void setDateEnfant(String dateEnfant) {
		this.dateEnfant = dateEnfant;
	}

	public Boolean getCertificatAccouch() {
		return certificatAccouch;
	}

	public void setCertificatAccouch(Boolean certificatAccouch) {
		this.certificatAccouch = certificatAccouch;
	}

	public Boolean getLivretFamille() {
		return livretFamille;
	}

	public void setLivretFamille(Boolean livretFamille) {
		this.livretFamille = livretFamille;
	}

	public Boolean getCinMere() {
		return cinMere;
	}

	public void setCinMere(Boolean cinMere) {
		this.cinMere = cinMere;
	}

	public Boolean getCinDeclarant() {
		return cinDeclarant;
	}

	public void setCinDeclarant(Boolean cinDeclarant) {
		this.cinDeclarant = cinDeclarant;
	}

	public long getIdMaire() {
		return idMaire;
	}

	public void setIdMaire(long idMaire) {
		this.idMaire = idMaire;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean getAvoirPere() {
		return avoirPere;
	}

	public void setAvoirPere(Boolean avoirPere) {
		this.avoirPere = avoirPere;
	}




}
