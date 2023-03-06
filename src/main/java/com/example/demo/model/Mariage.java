package com.example.demo.model;

import java.time.Instant;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="mariage")
public class Mariage {

	@Id
	@Column(name = "idMariage")
	private String idMariage; 
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "dateMariage")
	private String dateMariage;
	
	@Column(name = "heureMariage")
	private String heureMariage;
	
	@Column(name = "numero")
	 private Long numero;
	 
	 @Column(name = "annee")
	 private int annee;
	
	@ManyToOne()
	  @JoinColumn(name ="idHomme")
	private Homme homme;
	
	@ManyToOne()
	  @JoinColumn(name ="idFemme")
	private Femme femme;
	
	@ManyToOne()
	  @JoinColumn(name ="idMaire")
	private Maire maire;

	@CreatedDate
	private Instant createdDate;


	@ManyToOne
	@JoinColumn(name="idPremierCopie")
	private PremierCopie premierecopie;
	
	public String getIdMariage() {
		return idMariage;
	}



	public void setIdMariage(String idMariage) {
		this.idMariage = idMariage;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getDateMariage() {
		return dateMariage;
	}



	public void setDateMariage(String dateMariage) {
		this.dateMariage = dateMariage;
	}



	public String getHeureMariage() {
		return heureMariage;
	}



	public void setHeureMariage(String heureMariage) {
		this.heureMariage = heureMariage;
	}



	public Homme getHomme() {
		return homme;
	}



	public void setHomme(Homme homme) {
		this.homme = homme;
	}



	public Femme getFemme() {
		return femme;
	}



	public void setFemme(Femme femme) {
		this.femme = femme;
	}



	public Maire getMaire() {
		return maire;
	}



	public void setMaire(Maire maire) {
		this.maire = maire;
	}



	public Instant getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}



	public Long getNumero() {
		return numero;
	}



	public void setNumero(Long numero) {
		this.numero = numero;
	}



	public int getAnnee() {
		return annee;
	}



	public void setAnnee(int annee) {
		this.annee = annee;
	}



	public PremierCopie getPremierecopie() {
		return premierecopie;
	}



	public void setPremierecopie(PremierCopie premierecopie) {
		this.premierecopie = premierecopie;
	}



	public Mariage(String idMariage, String description, String dateMariage, String heureMariage, Homme homme,
			Femme femme, Maire maire, Instant createdDate, long numero, int annee, PremierCopie premierecopie) {
		this.idMariage = idMariage;
		this.description = description;
		this.dateMariage = dateMariage;
		this.heureMariage = heureMariage;
		this.homme = homme;
		this.femme = femme;
		this.maire = maire;
		this.createdDate = createdDate;
		this.numero = numero;
		this.annee = annee;
		this.premierecopie = premierecopie;
	}



	public Mariage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
