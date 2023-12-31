package com.back.commune.model;


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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idMere")
	private long idMere;

	@Column(name = "nomMere")
	private String nomMere;

	@Column(name = "prenomsMere")
	private String prenomsMere;

	@Column(name = "datenaissMere")
	private String dateNaissMere;

	@Column(name = "lieunaissMere")
	private String lieuNaissMere;

	@Column(name = "professionMere")
	private String professionMere;

	@Column(name = "adresseMere")
	private String adresseMere;

	public long getIdMere() {
		return idMere;
	}

	public void setIdMere(long idMere) {
		this.idMere = idMere;
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

	public String getDateNaissMere() {
		return dateNaissMere;
	}

	public void setDateNaissMere(String dateNaissMere) {
		this.dateNaissMere = dateNaissMere;
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

	public Mere(String nomMere, String prenomsMere, String dateNaissMere, String lieuNaissMere, String professionMere,
			String adresseMere) {
		this.nomMere = nomMere;
		this.prenomsMere = prenomsMere;
		this.dateNaissMere = dateNaissMere;
		this.lieuNaissMere = lieuNaissMere;
		this.professionMere = professionMere;
		this.adresseMere = adresseMere;
	}

	public Mere() {
		super();
		// TODO Auto-generated constructor stub
	}



}
