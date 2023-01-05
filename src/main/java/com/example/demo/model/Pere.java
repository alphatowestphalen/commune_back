package com.example.demo.model;

import java.util.Date;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
	@Column(name = "NomPere")
	private String NomPere;
	
	@Column(name = "PrenomsPere")
	private String PrenomsPere;
	
	@Column(name = "DatenaissPere")
	private Date DatenaissPere;
	
	@Column(name = "LieuNaissPere")
	private String LieuNaissPere;
	
	@Column(name = "ProfessionPere")
	private String ProfessionPere;
	
	@Column(name = "AdressePere")
	private String AdressePere;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getNomPere() {
		return NomPere;
	}

	public void setNomPere(String nomPere) {
		NomPere = nomPere;
	}

	public String getPrenomsPere() {
		return PrenomsPere;
	}

	public void setPrenomsPere(String prenomsPere) {
		PrenomsPere = prenomsPere;
	}

	public Date getDatenaissPere() {
		return DatenaissPere;
	}

	public void setDatenaissPere(Date datenaissPere) {
		DatenaissPere = datenaissPere;
	}

	public String getLieuNaissPere() {
		return LieuNaissPere;
	}

	public void setLieuNaissPere(String lieuNaissPere) {
		LieuNaissPere = lieuNaissPere;
	}

	public String getProfessionPere() {
		return ProfessionPere;
	}

	public void setProfessionPere(String professionPere) {
		ProfessionPere = professionPere;
	}

	public String getAdressePere() {
		return AdressePere;
	}

	public void setAdressePere(String adressePere) {
		AdressePere = adressePere;
	}

	public Pere(String nomPere, String prenomsPere, Date datenaissPere, String lieuNaissPere, String professionPere,
			String adressePere) {
		NomPere = nomPere;
		PrenomsPere = prenomsPere;
		DatenaissPere = datenaissPere;
		LieuNaissPere = lieuNaissPere;
		ProfessionPere = professionPere;
		AdressePere = adressePere;
	}

	public Pere() {
		super();
	}

	@Override
	public String toString() {
		return "Pere [Id=" + Id + ", NomPere=" + NomPere + ", PrenomsPere=" + PrenomsPere + ", DatenaissPere="
				+ DatenaissPere + ", LieuNaissPere=" + LieuNaissPere + ", ProfessionPere=" + ProfessionPere
				+ ", AdressePere=" + AdressePere + "]";
	}
	
	

}
