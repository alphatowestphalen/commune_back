package com.example.demo.model;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      },
		      mappedBy = "adoptions")
	@JsonIgnore
	private Set<PremierCopie> premierCopies = new HashSet<>();

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

	public Set<PremierCopie> getPremierCopies() {
		return premierCopies;
	}

	public void setPremierCopies(Set<PremierCopie> premierCopies) {
		this.premierCopies = premierCopies;
	}

	public Adoption(String parentAdoptif, String dateAdoption, String heureAdoption, String numAdoption, Set<PremierCopie> premierCopies) {
		this.parentAdoptif = parentAdoptif;
		this.dateAdoption = dateAdoption;
		this.heureAdoption = heureAdoption;
		this.numAdoption = numAdoption;
		this.premierCopies = premierCopies;
	}

	public Adoption() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
