package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personne")
public class Personne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPersonne")
	private long idPersonne;
	
	@Column(name = "datenaissPersonne")
	private Date datenaissPersonne;
	
	@Column(name = "heurenaissPersonne")
	private String heurenaissPersonne;
	
	@Column(name = "lieuNaissPersonne")
	private String lieuNaissPersonne;
	
	@Column(name = "nomPersonne")
	private String nomPersonne;
	
	@Column(name = "prenomsPersonne")
	private String prenomsPersonne;
	
	@Column(name = "sexePersonne")
	private String sexePersonne;

	public long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(long idPersonne) {
		this.idPersonne = idPersonne;
	}

	public Date getDatenaissPersonne() {
		return datenaissPersonne;
	}

	public void setDatenaissPersonne(Date datenaissPersonne) {
		this.datenaissPersonne = datenaissPersonne;
	}

	public String getHeurenaissPersonne() {
		return heurenaissPersonne;
	}

	public void setHeurenaissPersonne(String heurenaissPersonne) {
		this.heurenaissPersonne = heurenaissPersonne;
	}

	public String getLieuNaissPersonne() {
		return lieuNaissPersonne;
	}

	public void setLieuNaissPersonne(String lieuNaissPersonne) {
		this.lieuNaissPersonne = lieuNaissPersonne;
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

	public String getSexePersonne() {
		return sexePersonne;
	}

	public void setSexePersonne(String sexePersonne) {
		this.sexePersonne = sexePersonne;
	}

	public Personne(Date datenaissPersonne, String heurenaissPersonne, String lieuNaissPersonne, String nomPersonne,
			String prenomsPersonne, String sexePersonne) {
		this.datenaissPersonne = datenaissPersonne;
		this.heurenaissPersonne = heurenaissPersonne;
		this.lieuNaissPersonne = lieuNaissPersonne;
		this.nomPersonne = nomPersonne;
		this.prenomsPersonne = prenomsPersonne;
		this.sexePersonne = sexePersonne;
	}

	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
