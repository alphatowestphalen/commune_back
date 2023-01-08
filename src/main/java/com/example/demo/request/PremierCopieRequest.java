package com.example.demo.request;


import com.fasterxml.jackson.annotation.JsonFormat;

public class PremierCopieRequest {

	private String description;
	
	private String mention;
	
	private String nomDeclarant;
	
	private String prenomsDeclarant;
	
	@JsonFormat(pattern ="dd/MM/yyyy")
	private String datenaissDeclarant;
	
	private String nomMere;
	
	private String prenomsMere;
	
	@JsonFormat(pattern ="dd/MM/yyyy")
	private String datenaissMere;
	
	private String lieuNaissMere;
	
	private String professionMere;
	
	private String adresseMere;
	
	private String nomPere;
	
	private String prenomsPere;
	
	@JsonFormat(pattern ="dd/MM/yyyy")
	private String datenaissPere;
	
	private String lieuNaissPere;
	
	private String professionPere;
	
	private String adressePere;
	
	@JsonFormat(pattern ="dd/MM/yyyy")
	private String datenaissPersonne;
	
	private String heurenaissPersonne;
	
	private String lieuNaissPersonne;
	
	private String nomPersonne;
	
	private String prenomsPersonne;
	
	private String sexePersonne;
	
	private Boolean certificatAccouch;
	
	private Boolean livretFamille;
	
	private Boolean cinMere;
	
	private Boolean cinDeclarant;
	
	private String lieuNaissDeclarant;

	private String adressDeclarant;
	
	private Long idMaire;

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

	public String getDatenaissPersonne() {
		return datenaissPersonne;
	}

	public void setDatenaissPersonne(String datenaissPersonne) {
		this.datenaissPersonne = datenaissPersonne;
	}

	public String getHeurenaissPersonne() {
		return heurenaissPersonne;
	}

	public void setHeurenaissPersonne(String heurenaissPersonne) {
		this.heurenaissPersonne = heurenaissPersonne;
	}

	public String getLieuNaissPersonne() {
		return lieuNaissPersonne;
	}

	public void setLieuNaissPersonne(String lieuNaissPersonne) {
		this.lieuNaissPersonne = lieuNaissPersonne;
	}

	public String getNomPersonne() {
		return nomPersonne;
	}

	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}

	public String getPrenomsPersonne() {
		return prenomsPersonne;
	}

	public void setPrenomsPersonne(String prenomsPersonne) {
		this.prenomsPersonne = prenomsPersonne;
	}

	public String getSexePersonne() {
		return sexePersonne;
	}

	public void setSexePersonne(String sexePersonne) {
		this.sexePersonne = sexePersonne;
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

	public Long getIdMaire() {
		return idMaire;
	}

	public void setIdMaire(Long idMaire) {
		this.idMaire = idMaire;
	}
	
	
}
