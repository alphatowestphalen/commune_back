package com.example.demo.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="adoption")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="idAdoption")
public class Adoption implements Serializable{
	
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
	
	@Column(name= "type")
	private ArrayList<String> pereAdoptif = new ArrayList<>();
	
	@Column(name= "type")
	private ArrayList<String> mereAdoptif = new ArrayList<>();
	

	@ManyToOne
	@JoinColumn(name="idPremierCopie")
	private PremierCopie premierecopie;
	

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





	public ArrayList<String> getPereAdoptif() {
		return pereAdoptif;
	}

	public void setPereAdoptif(ArrayList<String> pereAdoptif) {
		this.pereAdoptif = pereAdoptif;
	}

	public ArrayList<String> getMereAdoptif() {
		return mereAdoptif;
	}

	public void setMereAdoptif(ArrayList<String> mereAdoptif) {
		this.mereAdoptif = mereAdoptif;
	}

	public PremierCopie getPremierecopie() {
		return premierecopie;
	}

	public void setPremierecopie(PremierCopie premierecopie) {
		this.premierecopie = premierecopie;
	}

	public Adoption() {
		super();
		
	}

	public Adoption(String parentAdoptif, String dateAdoption, String heureAdoption, String numAdoption,
			Instant createdDate, ArrayList<String> pereAdoptif, ArrayList<String> mereAdoptif,
			PremierCopie premierecopie) {
		super();
		this.parentAdoptif = parentAdoptif;
		this.dateAdoption = dateAdoption;
		this.heureAdoption = heureAdoption;
		this.numAdoption = numAdoption;
		this.createdDate = createdDate;
		this.pereAdoptif = pereAdoptif;
		this.mereAdoptif = mereAdoptif;
		this.premierecopie = premierecopie;
	}

	

	
	


	
	

}
