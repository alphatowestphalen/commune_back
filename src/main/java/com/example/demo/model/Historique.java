package com.example.demo.model;

import java.time.Instant;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="historique")
public class Historique {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idHistorique")
	private long idHistorique;
	
	@Column(name = "entity")
	private String entity;
	
	@Column(name = "idEntity")
	private String idEntity;
	
	@Column(name = "oldValue")
	private String oldValue;
	
	@Column(name = "newValue")
	private String newValue;
	
	@Column(name = "action")
	private String action;
	
	@CreatedDate
	private Instant createdDate;

	public long getIdHistorique() {
		return idHistorique;
	}

	public void setIdHistorique(long idHistorique) {
		this.idHistorique = idHistorique;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getIdEntity() {
		return idEntity;
	}

	public void setIdEntity(String idEntity) {
		this.idEntity = idEntity;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	
	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	
	public Historique(String idEntity, String entity,  String oldValue, String newValue, String action,
			Instant createdDate) {
		this.entity = entity;
		this.idEntity = idEntity;
		this.oldValue = oldValue;
		this.newValue = newValue;
		this.action = action;
		this.createdDate = createdDate;
	}

	public Historique() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
