package com.example.demo.request;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

import com.example.demo.model.Temoin;
import com.fasterxml.jackson.annotation.JsonFormat;

public class MariageRequest {

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


	// Info Homme
	
	private String nationaliteHomme;

	private String idPremierCopieHomme;
	
	private String nomHomme;
	
	private String prenomsHomme;
	
	private String professionHomme;
	
	@JsonFormat(pattern ="dd/MM/yyyy")
	private String datenaissHomme;
	
	private String lieunaissHomme;
	
	private String adresseHomme;
	
	private String typeHomme;
	
	

	// PERE HOMME
	private long idPereHomme;
	 
	private String nomPere;

	private String prenomsPere;

	private String datenaissPere;

	private String  lieuNaissPere;

	private String professionPere;

	private String adressPere;


	//MERE HOMME

	private long idMereHomme;

	private String nomMere;

	private String prenomsMere;

	private String datenaissMere;

	private String lieunaissMere;

	private String professionMere;

  private String adresseMere;


	// Info Femme
	
	private String idPremierCopieFemme;
	
	private String nationaliteFemme;
	
	private String nomFemme;
	
	private String prenomsFemme;
	
	private String professionFemme;
	
	@JsonFormat(pattern ="dd/MM/yyyy")
	private String datenaissFemme;

	private String lieunaissFemme;

	private String adresseFemme;

	private String typeFemme;


	// PERE HOMME
	private long idPereFemme;
	 
	private String nomPereFemme;

	private String prenomsPereFemme;

	private String datenaissPereFemme;

	private String  lieuNaissPereFemme;

	private String professionPereFemme;

	private String adressPereFemme;


	//MERE HOMME

	private long idMereFemme;

	private String nomMereFemme;

	private String prenomsMereFemme;

	private String datenaissMereFemme;

	private String lieunaissMereFemme;

	private String professionMereFemme;

  private String adresseMereFemme;
	

	private String description;
	
	@JsonFormat(pattern ="dd/MM/yyyy")
	private String dateMariage;
	
	private String heureMariage;
	
	@CreatedDate
	private Instant createdDate; 
	
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
	
	

	public String getIdPremierCopieHomme() {
		return idPremierCopieHomme;
	}

	public void setIdPremierCopieHomme(String idPremierCopieHomme) {
		this.idPremierCopieHomme = idPremierCopieHomme;
	}

	public String getNationaliteHomme() {
		return nationaliteHomme;
	}

	public void setNationaliteHomme(String nationaliteHomme) {
		this.nationaliteHomme = nationaliteHomme;
	}

	public String getNomHomme() {
		return nomHomme;
	}

	public void setNomHomme(String nomHomme) {
		this.nomHomme = nomHomme;
	}

	public String getPrenomsHomme() {
		return prenomsHomme;
	}

	public void setPrenomsHomme(String prenomsHomme) {
		this.prenomsHomme = prenomsHomme;
	}

	public String getProfessionHomme() {
		return professionHomme;
	}

	public void setProfessionHomme(String professionHomme) {
		this.professionHomme = professionHomme;
	}

	public String getDatenaissHomme() {
		return datenaissHomme;
	}

	public void setDatenaissHomme(String datenaissHomme) {
		this.datenaissHomme = datenaissHomme;
	}

	public String getLieunaissHomme() {
		return lieunaissHomme;
	}

	public void setLieunaissHomme(String lieunaissHomme) {
		this.lieunaissHomme = lieunaissHomme;
	}

	public String getAdresseHomme() {
		return adresseHomme;
	}

	public void setAdresseHomme(String adresseHomme) {
		this.adresseHomme = adresseHomme;
	}

	public String getTypeHomme() {
		return typeHomme;
	}

	public void setTypeHomme(String typeHomme) {
		this.typeHomme = typeHomme;
	}

	public long getIdPereHomme() {
		return idPereHomme;
	}

	public void setIdPereHomme(long idPereHomme) {
		this.idPereHomme = idPereHomme;
	}

	public long getIdMereHomme() {
		return idMereHomme;
	}

	public void setIdMereHomme(long idMereHomme) {
		this.idMereHomme = idMereHomme;
	}

	public String getNationaliteFemme() {
		return nationaliteFemme;
	}

	
	public long getIdPereFemme() {
		return idPereFemme;
	}

	public void setIdPereFemme(long idPereFemme) {
		this.idPereFemme = idPereFemme;
	}

	public long getIdMereFemme() {
		return idMereFemme;
	}

	public void setIdMereFemme(long idMereFemme) {
		this.idMereFemme = idMereFemme;
	}

	public String getIdPremierCopieFemme() {
		return idPremierCopieFemme;
	}

	public void setIdPremierCopieFemme(String idPremierCopieFemme) {
		this.idPremierCopieFemme = idPremierCopieFemme;
	}

	public void setNationaliteFemme(String nationaliteFemme) {
		this.nationaliteFemme = nationaliteFemme;
	}

	public String getNomFemme() {
		return nomFemme;
	}

	public void setNomFemme(String nomFemme) {
		this.nomFemme = nomFemme;
	}

	public String getPrenomsFemme() {
		return prenomsFemme;
	}

	public void setPrenomsFemme(String prenomsFemme) {
		this.prenomsFemme = prenomsFemme;
	}

	public String getProfessionFemme() {
		return professionFemme;
	}

	public void setProfessionFemme(String professionFemme) {
		this.professionFemme = professionFemme;
	}

	public String getDatenaissFemme() {
		return datenaissFemme;
	}

	public void setDatenaissFemme(String datenaissFemme) {
		this.datenaissFemme = datenaissFemme;
	}

	public String getLieunaissFemme() {
		return lieunaissFemme;
	}

	public void setLieunaissFemme(String lieunaissFemme) {
		this.lieunaissFemme = lieunaissFemme;
	}

	public String getAdresseFemme() {
		return adresseFemme;
	}

	public void setAdresseFemme(String adresseFemme) {
		this.adresseFemme = adresseFemme;
	}

	public String getTypeFemme() {
		return typeFemme;
	}

	public void setTypeFemme(String typeFemme) {
		this.typeFemme = typeFemme;
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

	public String getAdressPere() {
		return adressPere;
	}

	public void setAdressPere(String adressPere) {
		this.adressPere = adressPere;
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

	public String getLieunaissMere() {
		return lieunaissMere;
	}

	public void setLieunaissMere(String lieunaissMere) {
		this.lieunaissMere = lieunaissMere;
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

	public String getNomPereFemme() {
		return nomPereFemme;
	}

	public void setNomPereFemme(String nomPereFemme) {
		this.nomPereFemme = nomPereFemme;
	}

	public String getPrenomsPereFemme() {
		return prenomsPereFemme;
	}

	public void setPrenomsPereFemme(String prenomsPereFemme) {
		this.prenomsPereFemme = prenomsPereFemme;
	}

	public String getDatenaissPereFemme() {
		return datenaissPereFemme;
	}

	public void setDatenaissPereFemme(String datenaissPereFemme) {
		this.datenaissPereFemme = datenaissPereFemme;
	}

	public String getLieuNaissPereFemme() {
		return lieuNaissPereFemme;
	}

	public void setLieuNaissPereFemme(String lieuNaissPereFemme) {
		this.lieuNaissPereFemme = lieuNaissPereFemme;
	}

	public String getProfessionPereFemme() {
		return professionPereFemme;
	}

	public void setProfessionPereFemme(String professionPereFemme) {
		this.professionPereFemme = professionPereFemme;
	}

	public String getAdressPereFemme() {
		return adressPereFemme;
	}

	public void setAdressPereFemme(String adressPereFemme) {
		this.adressPereFemme = adressPereFemme;
	}

	public String getNomMereFemme() {
		return nomMereFemme;
	}

	public void setNomMereFemme(String nomMereFemme) {
		this.nomMereFemme = nomMereFemme;
	}

	public String getPrenomsMereFemme() {
		return prenomsMereFemme;
	}

	public void setPrenomsMereFemme(String prenomsMereFemme) {
		this.prenomsMereFemme = prenomsMereFemme;
	}

	public String getDatenaissMereFemme() {
		return datenaissMereFemme;
	}

	public void setDatenaissMereFemme(String datenaissMereFemme) {
		this.datenaissMereFemme = datenaissMereFemme;
	}

	public String getLieunaissMereFemme() {
		return lieunaissMereFemme;
	}

	public void setLieunaissMereFemme(String lieunaissMereFemme) {
		this.lieunaissMereFemme = lieunaissMereFemme;
	}

	public String getProfessionMereFemme() {
		return professionMereFemme;
	}

	public void setProfessionMereFemme(String professionMereFemme) {
		this.professionMereFemme = professionMereFemme;
	}

	public String getAdresseMereFemme() {
		return adresseMereFemme;
	}

	public void setAdresseMereFemme(String adresseMereFemme) {
		this.adresseMereFemme = adresseMereFemme;
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

	

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
