package com.back.commune.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.back.commune.utils.AuditTrailListener;

@Entity
@Table(name="maire")
@EntityListeners(AuditTrailListener.class)
public class Maire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idMaire")
	private long idMaire;

	@Column(name = "nomMaire")
	private String nomMaire;

	@Column(name = "prenomsMaire")
	private String prenomsMaire;

	@Column(name = "fonction")
	private String fonction;



	public long getIdMaire() {
		return idMaire;
	}

	public void setIdMaire(long idMaire) {
		this.idMaire = idMaire;
	}

	public String getNomMaire() {
		return nomMaire;
	}

	public void setNomMaire(String nomMaire) {
		this.nomMaire = nomMaire;
	}

	public String getPrenomsMaire() {
		return prenomsMaire;
	}

	public void setPrenomsMaire(String prenomsMaire) {
		this.prenomsMaire = prenomsMaire;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}


	public Maire(String nomMaire, String prenomsMaire, String fonction) {
		this.nomMaire = nomMaire;
		this.prenomsMaire = prenomsMaire;
		this.fonction = fonction;
	}

	public Maire() {
		super();
		// TODO Auto-generated constructor stub
	}


}
