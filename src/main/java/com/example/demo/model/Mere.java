package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mere")
public class Mere {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
	@Column(name = "NomMere")
	private String NomMere;
	
	@Column(name = "PrenomsMere")
	private String PrenomsMere;
	
	@Column(name = "DatenaissMere")
	private Date DatenaissMere;
	
	@Column(name = "LieuNaissMere")
	private String LieuNaissMere;
	
	@Column(name = "ProfessionMere")
	private String ProfessionMere;
	
	@Column(name = "AdresseMere")
	private String AdresseMere;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getNomMere() {
		return NomMere;
	}

	public void setNomMere(String nomMere) {
		NomMere = nomMere;
	}

	public String getPrenomsMere() {
		return PrenomsMere;
	}

	public void setPrenomsMere(String prenomsMere) {
		PrenomsMere = prenomsMere;
	}

	public Date getDatenaissMere() {
		return DatenaissMere;
	}

	public void setDatenaissMere(Date datenaissMere) {
		DatenaissMere = datenaissMere;
	}

	public String getLieuNaissMere() {
		return LieuNaissMere;
	}

	public void setLieuNaissMere(String lieuNaissMere) {
		LieuNaissMere = lieuNaissMere;
	}

	public String getProfessionMere() {
		return ProfessionMere;
	}

	public void setProfessionMere(String professionMere) {
		ProfessionMere = professionMere;
	}

	public String getAdresseMere() {
		return AdresseMere;
	}

	public void setAdresseMere(String adresseMere) {
		AdresseMere = adresseMere;
	}

	public Mere(String nomMere, String prenomsMere, Date datenaissMere, String lieuNaissMere, String professionMere,
			String adresseMere) {
		NomMere = nomMere;
		PrenomsMere = prenomsMere;
		DatenaissMere = datenaissMere;
		LieuNaissMere = lieuNaissMere;
		ProfessionMere = professionMere;
		AdresseMere = adresseMere;
	}

	public Mere() {
		super();
	}

	@Override
	public String toString() {
		return "Mere [Id=" + Id + ", NomMere=" + NomMere + ", PrenomsMere=" + PrenomsMere + ", DatenaissMere="
				+ DatenaissMere + ", LieuNaissMere=" + LieuNaissMere + ", ProfessionMere=" + ProfessionMere
				+ ", AdresseMere=" + AdresseMere + "]";
	}
	
	

}
