package com.example.demo.model;

import java.time.Instant;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="jugement")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="idJugement")
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
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPremierCopie")
	
	private PremierCopie premierCopie;
	
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

	

	public PremierCopie getPremierCopie() {
		return premierCopie;
	}

	public void setPremierCopie(PremierCopie premierCopie) {
		this.premierCopie = premierCopie;
	}

	
	public Jugement(String infoChangement, String numJugement, Instant createdDate, PremierCopie premierCopie) {
		this.infoChangement = infoChangement;
		this.numJugement = numJugement;
		this.createdDate = createdDate;
		this.premierCopie = premierCopie;
	}

	public Jugement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
