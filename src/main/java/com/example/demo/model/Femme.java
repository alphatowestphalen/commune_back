package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="femme")
public class Femme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFemme")
	private long idFemme;

	@Column(name = "nationalite")
	private String nationalite;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenoms")
	private String prenoms;
	
	@Column(name = "profession")
	private String profession;
	
	@Column(name = "datenaiss")
	private String datenaiss;
	
	@Column(name = "lieunaiss")
	private String lieunaiss;
	
	@Column(name = "adresse")
	private String adresse;
	
	@ManyToOne()
	  @JoinColumn(name = "idMere")
	  private Mere mere;
	
	@ManyToOne()
	  @JoinColumn(name = "idPere")
	  private Pere pere;

	public long getIdFemme() {
		return idFemme;
	}

	public void setIdFemme(long idFemme) {
		this.idFemme = idFemme;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenoms() {
		return prenoms;
	}

	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getDatenaiss() {
		return datenaiss;
	}

	public void setDatenaiss(String datenaiss) {
		this.datenaiss = datenaiss;
	}

	public String getLieunaiss() {
		return lieunaiss;
	}

	public void setLieunaiss(String lieunaiss) {
		this.lieunaiss = lieunaiss;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Mere getMere() {
		return mere;
	}

	public void setMere(Mere mere) {
		this.mere = mere;
	}

	public Pere getPere() {
		return pere;
	}

	public void setPere(Pere pere) {
		this.pere = pere;
	}

	public Femme(String nationalite, String nom, String prenoms, String profession, String datenaiss, String lieunaiss,
			String adresse, Mere mere, Pere pere) {
		this.nationalite = nationalite;
		this.nom = nom;
		this.prenoms = prenoms;
		this.profession = profession;
		this.datenaiss = datenaiss;
		this.lieunaiss = lieunaiss;
		this.adresse = adresse;
		this.mere = mere;
		this.pere = pere;
	}

	public Femme() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
