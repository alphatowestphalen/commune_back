package com.example.demo.model;



import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;


import javax.persistence.*;



import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;






@Entity
@Table(name="premierCopie")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="idPremierCopie")
public class PremierCopie implements Serializable{
	
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

	@ElementCollection
	private List<Mention> mentions = new ArrayList<Mention>();


	@OneToMany(mappedBy = "premierecopie", cascade = CascadeType.ALL, orphanRemoval = true)
	private	List<Adoption> adoption = new ArrayList<>();
	 
	 @OneToMany(mappedBy = "premierecopie", cascade = CascadeType.ALL, orphanRemoval = true)
	private	List<Reconnaissance> reconnaissance = new ArrayList<>();
	
	
	 @OneToOne(mappedBy = "premierCopie", cascade = CascadeType.ALL, orphanRemoval = true)
	 private Jugement jugement;
	
	 @OneToOne(mappedBy = "premierCopie", cascade = CascadeType.ALL , orphanRemoval = true)
	 private ActeDeces acteDeces;

	

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
	
	public List<Reconnaissance> getReconnaissance() {
		return reconnaissance;
	}

	public void setReconnaissance(List<Reconnaissance> reconnaissance) {
		this.reconnaissance = reconnaissance;
	}

	public List<Adoption> getAdoption() {
		return adoption;
	}

	public void setAdoption(List<Adoption> adoption) {
		this.adoption = adoption;
	}

	public Jugement getJugement() {
		return jugement;
	}

	public void setJugement(Jugement jugement) {
		this.jugement = jugement;
	}

	public ActeDeces getActeDeces() {
		return acteDeces;
	}

	public void setActeDeces(ActeDeces acteDeces) {
		this.acteDeces = acteDeces;
	}


    public List<Mention> getMentions() {
		return mentions;
	}

	public void setMentions(List<Mention> mentions) {
		this.mentions = mentions;
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

	
}
