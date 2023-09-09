package com.example.demo.model;

import java.time.Instant;
import java.util.ArrayList;

import javax.persistence.*;

import com.example.demo.model.auth.User;
import org.hibernate.annotations.CreationTimestamp;
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


	@Column(name = "numJugement")
	private String numJugement;

	@Column(name = "decretJuridique")
	private String decretJuridique;

	@Column(name = "dateDecret")
	private String dateDecret;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private User createdBy;

	@Column(name= "typeJugement")
	private String typeJugement;

	@Column(name= "infoChangement")
	private ArrayList<String> infoChangement = new ArrayList<>();

	@CreationTimestamp
	private Instant createdDate;

	@OneToOne
	@JoinColumn(name = "idPremierCopie")
	private PremierCopie premierCopie;

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public long getIdJugement() {
		return idJugement;
	}

	public void setIdJugement(long idJugement) {
		this.idJugement = idJugement;
	}

	public String getNumJugement() {
		return numJugement;
	}

	public void setNumJugement(String numJugement) {
		this.numJugement = numJugement;
	}

	public String getDecretJuridique() {
		return decretJuridique;
	}

	public void setDecretJuridique(String decretJuridique) {
		this.decretJuridique = decretJuridique;
	}

	public String getDateDecret() {
		return dateDecret;
	}

	public void setDateDecret(String dateDecret) {
		this.dateDecret = dateDecret;
	}

	public String getTypeJugement() {
		return typeJugement;
	}

	public void setTypeJugement(String typeJugement) {
		this.typeJugement = typeJugement;
	}

	public ArrayList<String> getInfoChangement() {
		return infoChangement;
	}

	public void setInfoChangement(ArrayList<String> infoChangement) {
		this.infoChangement = infoChangement;
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

	public Jugement(String numJugement, String decretJuridique, String dateDecret, String typeJugement,
			ArrayList<String> infoChangement, PremierCopie premierCopie) {
		this.numJugement = numJugement;
		this.decretJuridique = decretJuridique;
		this.dateDecret = dateDecret;
		this.typeJugement = typeJugement;
		this.infoChangement = infoChangement;
		this.premierCopie = premierCopie;
	}

	public Jugement() {
		super();
		// TODO Auto-generated constructor stub
	}


}
