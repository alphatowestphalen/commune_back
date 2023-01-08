package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="declarant")
public class Declarant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDeclarant")
	private long idDeclarant;
	
	
	@Column(name = "nomDeclarant")
	private String nomDeclarant;
	
	@Column(name = "prenomsDeclarant")
	private String prenomsDeclarant;
	
	@Column(name = "datenaissDeclarant")
	private Date datenaissDeclarant;
	
	@Column(name = "lieuNaissDeclarant")
	private String lieuNaissDeclarant;
	
	@Column(name = "adressDeclarant")
	private String adressDeclarant;

	public long getIdDeclarant() {
		return idDeclarant;
	}

	public void setIdDeclarant(long idDeclarant) {
		this.idDeclarant = idDeclarant;
	}

	public String getNomDeclarant() {
		return nomDeclarant;
	}

	public void setNomDeclarant(String nomDeclarant) {
		this.nomDeclarant = nomDeclarant;
	}

	public String getPrenomsDeclarant() {
		return prenomsDeclarant;
	}

	public void setPrenomsDeclarant(String prenomsDeclarant) {
		this.prenomsDeclarant = prenomsDeclarant;
	}

	public Date getDatenaissDeclarant() {
		return datenaissDeclarant;
	}

	public void setDatenaissDeclarant(Date datenaissDeclarant) {
		this.datenaissDeclarant = datenaissDeclarant;
	}

	public String getLieuNaissDeclarant() {
		return lieuNaissDeclarant;
	}

	public void setLieuNaissDeclarant(String lieuNaissDeclarant) {
		this.lieuNaissDeclarant = lieuNaissDeclarant;
	}

	public String getAdressDeclarant() {
		return adressDeclarant;
	}

	public void setAdressDeclarant(String adressDeclarant) {
		this.adressDeclarant = adressDeclarant;
	}

	public Declarant(String nomDeclarant, String prenomsDeclarant, Date datenaissDeclarant, String lieuNaissDeclarant,
			String adressDeclarant) {
		this.nomDeclarant = nomDeclarant;
		this.prenomsDeclarant = prenomsDeclarant;
		this.datenaissDeclarant = datenaissDeclarant;
		this.lieuNaissDeclarant = lieuNaissDeclarant;
		this.adressDeclarant = adressDeclarant;
	}

	public Declarant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
