package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="mariage")
public class Mariage {

	@Id
	@Column(name = "idMariage")
	private String idMariage; 
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "dateMariage")
	private String dateMariage;
	
	@Column(name = "heureMariage")
	private String heureMariage;
	
	@ManyToOne()
	  @JoinColumn(name ="idHomme")
	private Homme homme;
	
	@ManyToOne()
	  @JoinColumn(name ="idFemme")
	private Femme femme;
	
	@ManyToOne()
	  @JoinColumn(name ="idTemoin")
	private Temoin temoin;

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public Temoin getTemoin() {
		return temoin;
	}

	public void setTemoin(Temoin temoin) {
		this.temoin = temoin;
	}

	public Mariage(String description, String date, String dateMariage, String heureMariage, Homme homme, Femme femme,
			Temoin temoin) {
		this.description = description;
		this.date = date;
		this.dateMariage = dateMariage;
		this.heureMariage = heureMariage;
		this.homme = homme;
		this.femme = femme;
		this.temoin = temoin;
	}

	public Mariage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
