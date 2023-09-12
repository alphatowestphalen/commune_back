package com.back.commune.request;

import java.time.Instant;
import java.util.ArrayList;

import org.springframework.data.annotation.CreatedDate;

public class JugementRequest {

	 private String numJugement;

     private String idPremierCopie;

	 private String decretJuridique;

	 private String dateDecret;

	 private String typeJugement;


	 private ArrayList<String> infoChangement;

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

    public String getIdPremierCopie() {
        return idPremierCopie;
    }

    public void setIdPremierCopie(String idPremierCopie) {
        this.idPremierCopie = idPremierCopie;
    }
}
