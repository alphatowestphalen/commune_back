package com.back.commune.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
@Table(name = "homme")
@JsonInclude(Include.NON_NULL)
public class Homme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idHomme")
	private long idHomme;

	@Column(name = "nationalite")
	private String nationaliteHomme;

	@Column(name = "nom")
	private String nomHomme;

	@Column(name = "prenoms")
	private String prenomsHomme;

	@Column(name = "profession")
	private String professionHomme;

	@Column(name = "datenaiss")
	private String dateNaissHomme;

	@Column(name = "lieunaiss")
	private String lieuNaissHomme;

	@Column(name = "adresse")
	private String adresseHomme;

	@Column(name = "type")
	private String typeHomme;

	@ManyToOne()
	@JoinColumn(name = "idMere")
	private Mere mereHomme;

	@ManyToOne()
	@JoinColumn(name = "idPere")
	private Pere pereHomme;

	public long getIdHomme() {
		return idHomme;
	}

	public void setIdHomme(long idHomme) {
		this.idHomme = idHomme;
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

	public String getDateNaissHomme() {
		return dateNaissHomme;
	}

	public void setDateNaissHomme(String dateNaissHomme) {
		this.dateNaissHomme = dateNaissHomme;
	}

	public String getLieuNaissHomme() {
		return lieuNaissHomme;
	}

	public void setLieuNaissHomme(String lieunaissHomme) {
		this.lieuNaissHomme = lieuNaissHomme;
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

	public Mere getMereHomme() {
		return mereHomme;
	}

	public void setMereHomme(Mere mereHomme) {
		this.mereHomme = mereHomme;
	}

	public Pere getPereHomme() {
		return pereHomme;
	}

	public void setPereHomme(Pere pereHomme) {
		this.pereHomme = pereHomme;
	}

	public Homme() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Homme( String nationaliteHomme, String nomHomme, String prenomsHomme, String professionHomme,
			String dateNaissHomme, String lieuNaissHomme, String adresseHomme, String typeHomme, Mere mereHomme,
			Pere pereHomme) {

		this.nationaliteHomme = nationaliteHomme;
		this.nomHomme = nomHomme;
		this.prenomsHomme = prenomsHomme;
		this.professionHomme = professionHomme;
		this.dateNaissHomme = dateNaissHomme;
		this.lieuNaissHomme = lieuNaissHomme;
		this.adresseHomme = adresseHomme;
		this.typeHomme = typeHomme;
		this.mereHomme = mereHomme;
		this.pereHomme = pereHomme;
	}

}
