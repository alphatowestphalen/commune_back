package com.example.demo.model;

import java.time.Instant;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="bulletinNaissance")
public class BulletinNaissance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBulletinNaissance")
	private long idBulletinNaissance;
	
	@Column(name = "idPremierCopie")
	private long idPremierCopie;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "nomPersonne")
	private String nomPersonne;
	
	@Column(name = "prenomsPersonne")
	private String prenomsPersonne;
	
	@Column(name = "dateNaissPersonne")
	private String dateNaissPersonne;
	
	@Column(name = "lieuNaissPersonne")
	private String lieuNaissPersonne;
	
	@Column(name = "nomPere")
	private String nomPere;
	
	@Column(name = "prenomsPere")
	private String prenomsPere;
	
	@Column(name = "nomMere")
	private String nomMere;
	
	@Column(name = "prenomsMere")
	private String prenomsMere;
	
	@Column(name = "dateCopie")
	private String dateCopie;
	
	@CreatedDate
	private Instant createdDate;

	public long getIdBulletinNaissance() {
		return idBulletinNaissance;
	}

	public void setIdBulletinNaissance(long idBulletinNaissance) {
		this.idBulletinNaissance = idBulletinNaissance;
	}

	public long getIdPremierCopie() {
		return idPremierCopie;
	}

	public void setIdPremierCopie(long idPremierCopie) {
		this.idPremierCopie = idPremierCopie;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNomPersonne() {
		return nomPersonne;
	}

	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}

	public String getPrenomsPersonne() {
		return prenomsPersonne;
	}

	public void setPrenomsPersonne(String prenomsPersonne) {
		this.prenomsPersonne = prenomsPersonne;
	}

	public String getDateNaissPersonne() {
		return dateNaissPersonne;
	}

	public void setDateNaissPersonne(String dateNaissPersonne) {
		this.dateNaissPersonne = dateNaissPersonne;
	}

	public String getLieuNaissPersonne() {
		return lieuNaissPersonne;
	}

	public void setLieuNaissPersonne(String lieuNaissPersonne) {
		this.lieuNaissPersonne = lieuNaissPersonne;
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

	public String getDateCopie() {
		return dateCopie;
	}

	public void setDateCopie(String dateCopie) {
		this.dateCopie = dateCopie;
	}

	
	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	
	public BulletinNaissance(long idPremierCopie, String type, String nomPersonne, String prenomsPersonne,
			String dateNaissPersonne, String lieuNaissPersonne, String nomPere, String prenomsPere, String nomMere,
			String prenomsMere, String dateCopie, Instant createdDate) {
		this.idPremierCopie = idPremierCopie;
		this.type = type;
		this.nomPersonne = nomPersonne;
		this.prenomsPersonne = prenomsPersonne;
		this.dateNaissPersonne = dateNaissPersonne;
		this.lieuNaissPersonne = lieuNaissPersonne;
		this.nomPere = nomPere;
		this.prenomsPere = prenomsPere;
		this.nomMere = nomMere;
		this.prenomsMere = prenomsMere;
		this.dateCopie = dateCopie;
		this.createdDate = createdDate;
	}

	public BulletinNaissance() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
