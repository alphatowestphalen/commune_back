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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
	@Column(name = "NomDeclarant")
	private String NomDeclarant;
	
	@Column(name = "PrenomsDeclarant")
	private String PrenomsDeclarant;
	
	@Column(name = "DatenaissDeclarant")
	private Date DatenaissDeclarant;
	
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getNomDeclarant() {
		return NomDeclarant;
	}

	public void setNomDeclarant(String nomDeclarant) {
		NomDeclarant = nomDeclarant;
	}

	public String getPrenomsDeclarant() {
		return PrenomsDeclarant;
	}

	public void setPrenomsDeclarant(String prenomsDeclarant) {
		PrenomsDeclarant = prenomsDeclarant;
	}

	public Date getDatenaissDeclarant() {
		return DatenaissDeclarant;
	}

	public void setDatenaissDeclarant(Date datenaissDeclarant) {
		DatenaissDeclarant = datenaissDeclarant;
	}

	public String getLieuNaissDeclarant() {
		return LieuNaissDeclarant;
	}

	public void setLieuNaissDeclarant(String lieuNaissDeclarant) {
		LieuNaissDeclarant = lieuNaissDeclarant;
	}

	public String getAdressDeclarant() {
		return AdressDeclarant;
	}

	public void setAdressDeclarant(String adressDeclarant) {
		AdressDeclarant = adressDeclarant;
	}

	@Column(name = "LieuNaissDeclarant")
	private String LieuNaissDeclarant;
	
	@Column(name = "AdressDeclarant")
	private String AdressDeclarant;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public Declarant(String nomDeclarant, String prenomsDeclarant, Date datenaissDeclarant, String lieuNaissDeclarant,
			String adressDeclarant) {
		NomDeclarant = nomDeclarant;
		PrenomsDeclarant = prenomsDeclarant;
		DatenaissDeclarant = datenaissDeclarant;
		LieuNaissDeclarant = lieuNaissDeclarant;
		AdressDeclarant = adressDeclarant;
	}

	public Declarant() {
		super();
	}
	
	
	

}
