package com.example.demo.request;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;

public class JugementRequest {

	 private String infoChangement;
	 
	 private String numJugement;
	 
	 @CreatedDate
		private Instant createdDate;

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
	 
	 
	
}
