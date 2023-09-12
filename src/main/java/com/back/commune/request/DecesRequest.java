package com.back.commune.request;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DecesRequest {

	private String dateDeclaration;

	private String heureDeclaration;

	private String nomDeclarant;

	private String prenomsDeclarant;

	private String professionDeclarant;

	private String lieuNaissanceDeclarant;

	private String adresseDeclarant;

	private String dateNaissanceDeclarant;

	@JsonFormat(pattern ="dd/MM/yyyy")
	private String date;

	private long idMaire;

	private String professionDefunt;

	private String adresseDefunt;

	private String dateDeces;

	private String lieuDeces;

	private String heureDeces;

	private boolean nomPiece;

	@CreatedDate
	private Instant createdDate;



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

	public String getProfessionDeclarant() {
		return professionDeclarant;
	}

	public void setProfessionDeclarant(String professionDeclarant) {
		this.professionDeclarant = professionDeclarant;
	}

	public String getLieuNaissanceDeclarant() {
		return lieuNaissanceDeclarant;
	}

	public void setLieuNaissanceDeclarant(String lieuNaissanceDeclarant) {
		this.lieuNaissanceDeclarant = lieuNaissanceDeclarant;
	}

	public String getAdresseDeclarant() {
		return adresseDeclarant;
	}

	public void setAdresseDeclarant(String adresseDeclarant) {
		this.adresseDeclarant = adresseDeclarant;
	}

	public String getDateNaissanceDeclarant() {
		return dateNaissanceDeclarant;
	}

	public void setDateNaissanceDeclarant(String dateNaissanceDeclarant) {
		this.dateNaissanceDeclarant = dateNaissanceDeclarant;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getIdMaire() {
		return idMaire;
	}

	public void setIdMaire(long idMaire) {
		this.idMaire = idMaire;
	}

	public String getProfessionDefunt() {
		return professionDefunt;
	}

	public void setProfessionDefunt(String professionDefunt) {
		this.professionDefunt = professionDefunt;
	}

	public String getAdresseDefunt() {
		return adresseDefunt;
	}

	public void setAdresseDefunt(String adresseDefunt) {
		this.adresseDefunt = adresseDefunt;
	}

	public String getDateDeces() {
		return dateDeces;
	}

	public void setDateDeces(String dateDeces) {
		this.dateDeces = dateDeces;
	}

	public String getLieuDeces() {
		return lieuDeces;
	}

	public void setLieuDeces(String lieuDeces) {
		this.lieuDeces = lieuDeces;
	}

	public String getHeureDeces() {
		return heureDeces;
	}

	public void setHeureDeces(String heureDeces) {
		this.heureDeces = heureDeces;
	}

	public boolean isNomPiece() {
		return nomPiece;
	}

	public void setNomPiece(boolean nomPiece) {
		this.nomPiece = nomPiece;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}



}
