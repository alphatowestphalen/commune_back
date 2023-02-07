package com.example.demo.model;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="jugement")
public class Jugement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idJugement")
	private long idJugement;
	
	@Column(name = "infoChangement")
	private String infoChangement;
	
	@Column(name = "numJugement")
	private String numJugement;
	
	@CreatedDate
	private Instant createdDate;
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      },
		      mappedBy = "jugements")
	@JsonIgnore
	private Set<PremierCopie> premierCopies = new HashSet<>();

	public long getIdJugement() {
		return idJugement;
	}

	public void setIdJugement(long idJugement) {
		this.idJugement = idJugement;
	}

	public String getInfoChangement() {
		return infoChangement;
	}

	public void setInfoChangement(String infoChangement) {
		this.infoChangement = infoChangement;
	}

	public String getNumJugement() {
		return numJugement;
	}

	public void setNumJugement(String numJugement) {
		this.numJugement = numJugement;
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

	public Jugement(String infoChangement, String numJugement, Instant createdDate, Set<PremierCopie> premierCopies) {
		this.infoChangement = infoChangement;
		this.numJugement = numJugement;
		this.createdDate = createdDate;
		this.premierCopies = premierCopies;
	}

	public Jugement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
