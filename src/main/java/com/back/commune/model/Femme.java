package com.back.commune.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
@Table(name="femme")
@JsonInclude(Include.NON_NULL)
public class Femme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFemme")
	private long idFemme;

	@Column(name = "nationalite")
	private String nationaliteFemme;

	@Column(name = "nom")
	private String nomFemme;

	@Column(name = "prenoms")
	private String prenomsFemme;

	@Column(name = "profession")
	private String professionFemme;

	@Column(name = "datenaiss")
	private String dateNaissFemme;

	@Column(name = "lieunaiss")
	private String lieuNaissFemme;

	@Column(name = "adresse")
	private String adresseFemme;

	@Column(name = "type")
	private String typeFemme;

	@ManyToOne()
	@JoinColumn(name = "idMere")
	private Mere mereFemme;

	@ManyToOne()
	@JoinColumn(name = "idPere")
	private Pere pereFemme;

	public long getIdFemme() {
		return idFemme;
	}

	public void setIdFemme(long idFemme) {
		this.idFemme = idFemme;
	}



	public String getNationaliteFemme() {
		return nationaliteFemme;
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

	public String getDateNaissFemme() {
		return dateNaissFemme;
	}

	public void setDateNaissFemme(String dateNaissFemme) {
		this.dateNaissFemme = dateNaissFemme;
	}

	public String getLieuNaissFemme() {
		return lieuNaissFemme;
	}

	public void setLieuNaissFemme(String lieuNaissFemme) {
		this.lieuNaissFemme = lieuNaissFemme;
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


	public Mere getMereFemme() {
		return mereFemme;
	}

	public void setMereFemme(Mere mereFemme) {
		this.mereFemme = mereFemme;
	}

	public Pere getPereFemme() {
		return pereFemme;
	}

	public void setPereFemme(Pere pereFemme) {
		this.pereFemme = pereFemme;
	}

	public Femme( String nationaliteFemme, String nomFemme, String prenomsFemme, String professionFemme,
			String dateNaissFemme, String lieuNaissFemme, String adresseFemme, String typeFemme, Mere mereFemme,
			Pere pereFemme) {

		this.nationaliteFemme = nationaliteFemme;
		this.nomFemme = nomFemme;
		this.prenomsFemme = prenomsFemme;
		this.professionFemme = professionFemme;
		this.dateNaissFemme = dateNaissFemme;
		this.lieuNaissFemme = lieuNaissFemme;
		this.adresseFemme = adresseFemme;
		this.typeFemme = typeFemme;
		this.mereFemme = mereFemme;
		this.pereFemme = pereFemme;
	}

	public Femme() {
		super();
		// TODO Auto-generated constructor stub
	}


}
