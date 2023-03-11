package com.example.demo.model;

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
	private String datenaissHomme;

	@Column(name = "lieunaiss")
	private String lieunaissHomme;

	@Column(name = "adresse")
	private String adresseHomme;

	@Column(name = "type")
	private String typeHomme;

	// @Column(name = "idPere")
	// private Long idPere;

	// @Column(name = "idMere")
	// private Long idMere;

	@ManyToOne()
	@JoinColumn(name = "idMere")
	private Mere mereHomme;

	@ManyToOne()
	@JoinColumn(name = "idPere")
	private Pere pereHomme;

	@ManyToOne()
	@JoinColumn(name = "idTemoin")
	private Temoin temoinHomme;

	@ManyToOne
	@JoinColumn(name = "idPremierCopie")
	private PremierCopie premierecopie;

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

	public Temoin getTemoinHomme() {
		return temoinHomme;
	}

	public void setTemoinHomme(Temoin temoinHomme) {
		this.temoinHomme = temoinHomme;
	}

	public PremierCopie getPremierecopie() {
		return premierecopie;
	}

	public void setPremierecopie(PremierCopie premierecopie) {
		this.premierecopie = premierecopie;
	}

	public Homme() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Homme( String nationaliteHomme, String nomHomme, String prenomsHomme, String professionHomme,
			String datenaissHomme, String lieunaissHomme, String adresseHomme, String typeHomme, Mere mereHomme,
			Pere pereHomme, Temoin temoinHomme, PremierCopie premierecopie) {
		
		this.nationaliteHomme = nationaliteHomme;
		this.nomHomme = nomHomme;
		this.prenomsHomme = prenomsHomme;
		this.professionHomme = professionHomme;
		this.datenaissHomme = datenaissHomme;
		this.lieunaissHomme = lieunaissHomme;
		this.adresseHomme = adresseHomme;
		this.typeHomme = typeHomme;
		this.mereHomme = mereHomme;
		this.pereHomme = pereHomme;
		this.temoinHomme = temoinHomme;
		this.premierecopie = premierecopie;
	}
 
}
