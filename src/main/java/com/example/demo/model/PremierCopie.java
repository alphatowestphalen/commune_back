package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="premierCopie")
public class PremierCopie {
	
	@Id
	@Column(name = "idPremierCopie")
	private long idPremierCopie;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "mention")
	private String mention;
	
	@Column(name = "datePCopie")
	private String datePCopie;
	
	@Column(name = "datePremierCopie")
	private String datePremierCopie;
	
	@ManyToOne()
	  @JoinColumn(name ="idDeclarant")
	 private Declarant declarant;
	
	@ManyToOne()
	  @JoinColumn(name = "idMaire")
	  private Maire maire;
	
	@ManyToOne()
	  @JoinColumn(name = "idMere")
	  private Mere mere;
	
	@ManyToOne()
	  @JoinColumn(name = "idPere")
	  private Pere pere;
	
	@ManyToOne()
	  @JoinColumn(name = "idEnfant")
	  private Enfant enfant;
	
	@ManyToOne()
	  @JoinColumn(name = "idPieceJustificative")
	  private PieceJustificative pieceJustificative;
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      })
	  @JoinTable(name = "premierCopie_reconnaissances",
	        joinColumns = { @JoinColumn(name = "idPremierCopie") },
	        inverseJoinColumns = { @JoinColumn(name = "idReconnaissance") })
	  private Set<Reconnaissance> reconnaissances = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      })
	  @JoinTable(name = "premierCopie_adoptions",
	        joinColumns = { @JoinColumn(name = "idPremierCopie") },
	        inverseJoinColumns = { @JoinColumn(name = "idAdoption") })
	  private Set<Adoption> adoptions = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      })
	  @JoinTable(name = "premierCopie_jugements",
	        joinColumns = { @JoinColumn(name = "idPremierCopie") },
	        inverseJoinColumns = { @JoinColumn(name = "idJugement") })
	  private Set<Jugement> jugements = new HashSet<>();

	public long getIdPremierCopie() {
		return idPremierCopie;
	}

	public void setIdPremierCopie(long idPremierCopie) {
		this.idPremierCopie = idPremierCopie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMention() {
		return mention;
	}

	public void setMention(String mention) {
		this.mention = mention;
	}

	public String getDatePCopie() {
		return datePCopie;
	}

	public void setDatePCopie(String datePCopie) {
		this.datePCopie = datePCopie;
	}

	public String getDatePremierCopie() {
		return datePremierCopie;
	}

	public void setDatePremierCopie(String datePremierCopie) {
		this.datePremierCopie = datePremierCopie;
	}

	public Declarant getDeclarant() {
		return declarant;
	}

	public void setDeclarant(Declarant declarant) {
		this.declarant = declarant;
	}

	public Maire getMaire() {
		return maire;
	}

	public void setMaire(Maire maire) {
		this.maire = maire;
	}

	public Mere getMere() {
		return mere;
	}

	public void setMere(Mere mere) {
		this.mere = mere;
	}

	public Pere getPere() {
		return pere;
	}

	public void setPere(Pere pere) {
		this.pere = pere;
	}

	public Enfant getEnfant() {
		return enfant;
	}

	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}

	public PieceJustificative getPieceJustificative() {
		return pieceJustificative;
	}

	public void setPieceJustificative(PieceJustificative pieceJustificative) {
		this.pieceJustificative = pieceJustificative;
	}

	
	
	public Set<Reconnaissance> getReconnaissances() {
		return reconnaissances;
	}

	public void setReconnaissances(Set<Reconnaissance> reconnaissances) {
		this.reconnaissances = reconnaissances;
	}

	
	public Set<Adoption> getAdoptions() {
		return adoptions;
	}

	public void setAdoptions(Set<Adoption> adoptions) {
		this.adoptions = adoptions;
	}

	
	public Set<Jugement> getJugements() {
		return jugements;
	}

	public void setJugements(Set<Jugement> jugements) {
		this.jugements = jugements;
	}

	public PremierCopie(long idPremierCopie, String description, String mention, String datePCopie,
			String datePremierCopie, Declarant declarant, Maire maire, Mere mere, Pere pere, Enfant enfant,
			PieceJustificative pieceJustificative) {
		this.idPremierCopie = idPremierCopie;
		this.description = description;
		this.mention = mention;
		this.datePCopie = datePCopie;
		this.datePremierCopie = datePremierCopie;
		this.declarant = declarant;
		this.maire = maire;
		this.mere = mere;
		this.pere = pere;
		this.enfant = enfant;
		this.pieceJustificative = pieceJustificative;
	}

	public PremierCopie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addReconnaissance(Reconnaissance reconnaissance) {
	    this.reconnaissances.add(reconnaissance);
	    reconnaissance.getPremierCopies().add(this);
	  }
	  
	  public void removeReconnaissance(long idReconnaissance) {
		  Reconnaissance reconnaissance = this.reconnaissances.stream().filter(r -> r.getIdReconnaissance() == idReconnaissance).findFirst().orElse(null);
	    if (reconnaissance != null) {
	      this.reconnaissances.remove(reconnaissance);
	      reconnaissance.getPremierCopies().remove(this);
	    }
	  }
	  
	  public void addAdoption(Adoption adoption) {
		    this.adoptions.add(adoption);
		    adoption.getPremierCopies().add(this);
		  }
		  
		  public void removeAdoption(long idAdoption) {
			  Adoption adoption = this.adoptions.stream().filter(r -> r.getIdAdoption() == idAdoption).findFirst().orElse(null);
		    if (adoption != null) {
		      this.adoptions.remove(adoption);
		      adoption.getPremierCopies().remove(this);
		    }
		  }
	 
		  public void addJugement(Jugement jugement) {
			    this.jugements.add(jugement);
			    jugement.getPremierCopies().add(this);
			  }
			  
			  public void removeJugement(long idJugement) {
				  Jugement jugement = this.jugements.stream().filter(r -> r.getIdJugement() == idJugement).findFirst().orElse(null);
			    if (jugement != null) {
			      this.jugements.remove(jugement);
			      jugement.getPremierCopies().remove(this);
			    }
			  }

}
