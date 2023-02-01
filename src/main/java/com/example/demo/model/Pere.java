package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pere")
public class Pere {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPere")
	private long idPere;
	
	@Column(name = "nomPere")
	private String nomPere;
	
	@Column(name = "prenomsPere")
	private String prenomsPere;
	
	@Column(name = "datenaissPere")
	private String datenaissPere;
	
	@Column(name = "lieunaissPere")
	private String lieunaissPere;
	
	@Column(name = "professionPere")
	private String professionPere;
	
	@Column(name = "adressePere")
	private String adressePere;

	public long getIdPere() {
		return idPere;
	}

	public void setIdPere(long idPere) {
		this.idPere = idPere;
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
		return lieunaissPere;
	}

	public void setLieuNaissPere(String lieuNaissPere) {
		this.lieunaissPere = lieuNaissPere;
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

	public Pere(String nomPere, String prenomsPere, String datenaissPere, String lieuNaissPere, String professionPere,
			String adressePere) {
		this.nomPere = nomPere;
		this.prenomsPere = prenomsPere;
		this.datenaissPere = datenaissPere;
		this.lieunaissPere = lieuNaissPere;
		this.professionPere = professionPere;
		this.adressePere = adressePere;
	}

	public Pere() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
