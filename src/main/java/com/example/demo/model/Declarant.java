package com.example.demo.model;


import javax.persistence.*;

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
	private String datenaissDeclarant;
	
	@Column(name = "lieunaissDeclarant")
	private String lieunaissDeclarant;
	
	@Column(name = "adresseDeclarant")
	private String adresseDeclarant;
	
	@Column(name = "professionDeclarant")
	private String professionDeclarant;

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

	public String getDatenaissDeclarant() {
		return datenaissDeclarant;
	}

	public void setDatenaissDeclarant(String datenaissDeclarant) {
		this.datenaissDeclarant = datenaissDeclarant;
	}

	public String getLieuNaissDeclarant() {
		return lieunaissDeclarant;
	}

	public void setLieuNaissDeclarant(String lieuNaissDeclarant) {
		this.lieunaissDeclarant = lieuNaissDeclarant;
	}

	public String getAdressDeclarant() {
		return adresseDeclarant;
	}

	public void setAdressDeclarant(String adressDeclarant) {
		this.adresseDeclarant = adressDeclarant;
	}

	public String getProfessionDeclarant() {
		return professionDeclarant;
	}

	public void setProfessionDeclarant(String professionDeclarant) {
		this.professionDeclarant = professionDeclarant;
	}

	public Declarant(String nomDeclarant, String prenomsDeclarant, String datenaissDeclarant, String lieuNaissDeclarant,
			String adressDeclarant, String professionDeclarant) {
		this.nomDeclarant = nomDeclarant;
		this.prenomsDeclarant = prenomsDeclarant;
		this.datenaissDeclarant = datenaissDeclarant;
		this.lieunaissDeclarant = lieuNaissDeclarant;
		this.adresseDeclarant = adressDeclarant;
		this.professionDeclarant = professionDeclarant;
	}

	public Declarant() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
