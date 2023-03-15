package com.example.demo.model;

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
	private String datenaissFemme;
	
	@Column(name = "lieunaiss")
	private String lieunaissFemme;
	
	@Column(name = "adresse")
	private String adresseFemme;
	
	@Column(name = "type")
	private String typeFemme;
	
	// @Column(name = "idPere")
	// private Long idPereFemme;
	
	// @Column(name = "idMere")
	// private Long idMereFemme;
	
	@ManyToOne()
	@JoinColumn(name = "idMere")
	private Mere mereFemme;

	@ManyToOne()
	@JoinColumn(name = "idPere")
	private Pere pereFemme;
	
	@ManyToOne()
	  @JoinColumn(name = "idTemoin")
	  private Temoin temoinFemme;
	
	  @ManyToOne
	  @JoinColumn(name="idPremierCopie")
	  private PremierCopie premierecopie;

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

	public Temoin getTemoinFemme() {
		return temoinFemme;
	}

	public void setTemoinFemme(Temoin temoinFemme) {
		this.temoinFemme = temoinFemme;
	}

	public PremierCopie getPremierecopie() {
		return premierecopie;
	}



	public void setPremierecopie(PremierCopie premierecopie) {
		this.premierecopie = premierecopie;
	}

	

	

	public Femme( String nationaliteFemme, String nomFemme, String prenomsFemme, String professionFemme,
			String datenaissFemme, String lieunaissFemme, String adresseFemme, String typeFemme, Mere mereFemme,
			Pere pereFemme, Temoin temoinFemme, PremierCopie premierecopie) {
	
		this.nationaliteFemme = nationaliteFemme;
		this.nomFemme = nomFemme;
		this.prenomsFemme = prenomsFemme;
		this.professionFemme = professionFemme;
		this.datenaissFemme = datenaissFemme;
		this.lieunaissFemme = lieunaissFemme;
		this.adresseFemme = adresseFemme;
		this.typeFemme = typeFemme;
		this.mereFemme = mereFemme;
		this.pereFemme = pereFemme;
		this.temoinFemme = temoinFemme;
		this.premierecopie = premierecopie;
	}

	public Femme() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
