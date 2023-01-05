package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personne")
public class Personne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
	@Column(name = "DatenaissPersonne")
	private Date DatenaissPersonne;
	
	@Column(name = "HeurenaissPersonne")
	private String HeurenaissPersonne;
	
	@Column(name = "LieuNaissPersonne")
	private String LieuNaissPersonne;
	
	@Column(name = "NomPersonne")
	private String NomPersonne;
	
	@Column(name = "PrenomsPersonne")
	private String PrenomsPersonne;
	
	@Column(name = "SexePersonne")
	private String SexePersonne;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Date getDatenaissPersonne() {
		return DatenaissPersonne;
	}

	public void setDatenaissPersonne(Date datenaissPersonne) {
		DatenaissPersonne = datenaissPersonne;
	}

	public String getHeurenaissPersonne() {
		return HeurenaissPersonne;
	}

	public void setHeurenaissPersonne(String heurenaissPersonne) {
		HeurenaissPersonne = heurenaissPersonne;
	}

	public String getLieuNaissPersonne() {
		return LieuNaissPersonne;
	}

	public void setLieuNaissPersonne(String lieuNaissPersonne) {
		LieuNaissPersonne = lieuNaissPersonne;
	}

	public String getNomPersonne() {
		return NomPersonne;
	}

	public void setNomPersonne(String nomPersonne) {
		NomPersonne = nomPersonne;
	}

	public String getPrenomsPersonne() {
		return PrenomsPersonne;
	}

	public void setPrenomsPersonne(String prenomsPersonne) {
		PrenomsPersonne = prenomsPersonne;
	}

	public String getSexePersonne() {
		return SexePersonne;
	}

	public void setSexePersonne(String sexePersonne) {
		SexePersonne = sexePersonne;
	}

	public Personne(Date datenaissPersonne, String heurenaissPersonne, String lieuNaissPersonne, String nomPersonne,
			String prenomsPersonne, String sexePersonne) {
		super();
		DatenaissPersonne = datenaissPersonne;
		HeurenaissPersonne = heurenaissPersonne;
		LieuNaissPersonne = lieuNaissPersonne;
		NomPersonne = nomPersonne;
		PrenomsPersonne = prenomsPersonne;
		SexePersonne = sexePersonne;
	}

	public Personne() {
		super();
	}

	@Override
	public String toString() {
		return "Personne [Id=" + Id + ", DatenaissPersonne=" + DatenaissPersonne + ", HeurenaissPersonne="
				+ HeurenaissPersonne + ", LieuNaissPersonne=" + LieuNaissPersonne + ", NomPersonne=" + NomPersonne
				+ ", PrenomsPersonne=" + PrenomsPersonne + ", SexePersonne=" + SexePersonne + "]";
	}
	
	

}
