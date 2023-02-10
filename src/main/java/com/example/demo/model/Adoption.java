package com.example.demo.model;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="adoption")
public class Adoption {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAdoption")
	private long idAdoption;
	
	@Column(name = "parentAdoptif")
	private String parentAdoptif;
	
	@Column(name = "dateAdoption")
	private String dateAdoption;
	
	@Column(name = "heureAdoption")
	private String heureAdoption;
	
	@Column(name = "numAdoption")
	private String numAdoption;
	
	@CreatedDate
	private Instant createdDate;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPremierCopie")
	@JsonManagedReference
	private PremierCopie premierCopie;

	public long getIdAdoption() {
		return idAdoption;
	}

	public void setIdAdoption(long idAdoption) {
		this.idAdoption = idAdoption;
	}

	public String getParentAdoptif() {
		return parentAdoptif;
	}

	public void setParentAdoptif(String parentAdoptif) {
		this.parentAdoptif = parentAdoptif;
	}

	public String getDateAdoption() {
		return dateAdoption;
	}

	public void setDateAdoption(String dateAdoption) {
		this.dateAdoption = dateAdoption;
	}

	public String getHeureAdoption() {
		return heureAdoption;
	}

	public void setHeureAdoption(String heureAdoption) {
		this.heureAdoption = heureAdoption;
	}

	public String getNumAdoption() {
		return numAdoption;
	}

	public void setNumAdoption(String numAdoption) {
		this.numAdoption = numAdoption;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	

	public PremierCopie getPremierCopie() {
		return premierCopie;
	}

	public void setPremierCopie(PremierCopie premierCopie) {
		this.premierCopie = premierCopie;
	}

	
	public Adoption(String parentAdoptif, String dateAdoption, String heureAdoption, String numAdoption,
			Instant createdDate, PremierCopie premierCopie) {
		this.parentAdoptif = parentAdoptif;
		this.dateAdoption = dateAdoption;
		this.heureAdoption = heureAdoption;
		this.numAdoption = numAdoption;
		this.createdDate = createdDate;
		this.premierCopie = premierCopie;
	}

	public Adoption() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
