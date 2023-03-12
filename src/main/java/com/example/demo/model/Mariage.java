package com.example.demo.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="mariage")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="idMariage")
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

	//  @Column(name= "type")
	//  private ArrayList<String> type = new ArrayList<>();
	
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
	@JoinColumn(name="idPremierCopieHomme")
	private PremierCopie premierecopieHomme;

	@ManyToOne
	@JoinColumn(name="idPremierCopieFemme")
	private PremierCopie premierecopieFemme;



	
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

	// public ArrayList<String> getType() {
	// 	return type;
	// }



	// public void setType(ArrayList<String> type) {
	// 	this.type = type;
	// }
	

	


	public Mariage(String idMariage, String description, String dateMariage, String heureMariage, Homme homme,
			Femme femme, Maire maire, Instant createdDate, long numero, int annee , PremierCopie premierecopieHomme, PremierCopie premierecopieFemme) {
		this.idMariage = idMariage;
		this.description = description;
		this.dateMariage = dateMariage;
		this.heureMariage = heureMariage;
	 //   this.type = type;
		this.homme = homme;
		this.femme = femme;
		this.maire = maire;
		this.createdDate = createdDate;
		this.numero = numero;
		this.annee = annee;
		this.premierecopieHomme = premierecopieHomme;
		this.premierecopieFemme = premierecopieFemme;
		
	}

	


	public PremierCopie getPremierecopieHomme() {
		return premierecopieHomme;
	}



	public void setPremierecopieHomme(PremierCopie premierecopieHomme) {
		this.premierecopieHomme = premierecopieHomme;
	}



	public PremierCopie getPremierecopieFemme() {
		return premierecopieFemme;
	}



	public void setPremierecopieFemme(PremierCopie premierecopieFemme) {
		this.premierecopieFemme = premierecopieFemme;
	}



	public Mariage() {
	}





	
	
}
