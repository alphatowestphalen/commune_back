package com.back.commune.model;

import javax.persistence.*;

@Entity
@Table(name="enfant")
public class Enfant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEnfant")
	private long idEnfant;

	@Column(name = "nomEnfant")
	private String nomEnfant;

	@Column(name = "prenomsEnfant")
	private String prenomsEnfant;

	@Column(name = "datenaissEnfant")
	private String datenaissEnfant;

	@Column(name = "lieunaissEnfant")
	private String lieunaissEnfant;

	@Column(name = "heurenaissEnfant")
	private String heurenaissEnfant;

	@Column(name = "sexeEnfant")
	private String sexeEnfant;

	@Column(name = "dateEnfant")
	private String dateEnfant;

	public long getIdEnfant() {
		return idEnfant;
	}

	public void setIdEnfant(long idEnfant) {
		this.idEnfant = idEnfant;
	}

	public String getNomEnfant() {
		return nomEnfant;
	}

	public void setNomEnfant(String nomEnfant) {
		this.nomEnfant = nomEnfant;
	}

	public String getPrenomsEnfant() {
		return prenomsEnfant;
	}

	public void setPrenomsEnfant(String prenomsEnfant) {
		this.prenomsEnfant = prenomsEnfant;
	}

	public String getDatenaissEnfant() {
		return datenaissEnfant;
	}

	public void setDatenaissEnfant(String datenaissEnfant) {
		this.datenaissEnfant = datenaissEnfant;
	}

	public String getLieunaissEnfant() {
		return lieunaissEnfant;
	}

	public void setLieunaissEnfant(String lieunaissEnfant) {
		this.lieunaissEnfant = lieunaissEnfant;
	}

	public String getHeurenaissEnfant() {
		return heurenaissEnfant;
	}

	public void setHeurenaissEnfant(String heurenaissEnfant) {
		this.heurenaissEnfant = heurenaissEnfant;
	}

	public String getSexeEnfant() {
		return sexeEnfant;
	}

	public void setSexeEnfant(String sexeEnfant) {
		this.sexeEnfant = sexeEnfant;
	}

	public String getDateEnfant() {
		return dateEnfant;
	}

	public void setDateEnfant(String dateEnfant) {
		this.dateEnfant = dateEnfant;
	}

	public Enfant(String nomEnfant, String prenomsEnfant, String datenaissEnfant, String lieunaissEnfant,
			String heurenaissEnfant, String sexeEnfant, String dateEnfant) {
		this.nomEnfant = nomEnfant;
		this.prenomsEnfant = prenomsEnfant;
		this.datenaissEnfant = datenaissEnfant;
		this.lieunaissEnfant = lieunaissEnfant;
		this.heurenaissEnfant = heurenaissEnfant;
		this.sexeEnfant = sexeEnfant;
		this.dateEnfant = dateEnfant;
	}

	public Enfant() {
		super();
		// TODO Auto-generated constructor stub
	}




}
