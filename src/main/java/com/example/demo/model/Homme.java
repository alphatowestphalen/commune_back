package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="homme")
public class Homme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idHomme")
	private long idHomme;

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
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "idPere")
	private Long idPere;
	
	@Column(name = "idMere")
	private Long idMere;
	
	@ManyToOne()
	  @JoinColumn(name = "idTemoin")
	  private Temoin temoin;
	
	public long getIdHomme() {
		return idHomme;
	}

	public void setIdHomme(long idHomme) {
		this.idHomme = idHomme;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getIdPere() {
		return idPere;
	}

	public void setIdPere(Long idPere) {
		this.idPere = idPere;
	}

	public Long getIdMere() {
		return idMere;
	}

	public void setIdMere(Long idMere) {
		this.idMere = idMere;
	}

	public Temoin getTemoin() {
		return temoin;
	}

	public void setTemoin(Temoin temoin) {
		this.temoin = temoin;
	}

	public Homme() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Homme(String nationalite, String nom, String prenoms, String profession, String datenaiss, String lieunaiss,
			String adresse, String type, Long idPere, Long idMere, Temoin temoin) {
		this.nationalite = nationalite;
		this.nom = nom;
		this.prenoms = prenoms;
		this.profession = profession;
		this.datenaiss = datenaiss;
		this.lieunaiss = lieunaiss;
		this.adresse = adresse;
		this.type = type;
		this.idPere = idPere;
		this.idMere = idMere;
		this.temoin = temoin;
	}

	

	
}
