package com.back.commune.model;



import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;

import java.util.List;


import javax.persistence.*;

import com.back.commune.model.auth.User;
import com.back.commune.utils.AuditTrailListener;
import org.springframework.data.annotation.CreatedDate;


@Entity
@Table(name="premierCopie")
@EntityListeners(AuditTrailListener.class)
public class PremierCopie implements Serializable{

	@Id
	@Column(name = "idPremierCopie")
	private String idPremierCopie;

	@Column(name = "description")
	private String description;

	@Column(name = "mention")
	private String mention;

	@Column(name = "datePCopie")
	private String datePCopie;

	@Column(name = "datePremierCopie")
	private String datePremierCopie;

	@CreatedDate
	private Instant createdDate;

	@Column(name = "deleted")
	private boolean deleted = Boolean.FALSE;

	@ManyToOne()
    @JoinColumn(name ="idDeclarant")
    private Declarant declarant;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private User createdBy;

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

	 @OneToOne(mappedBy = "premierCopie", cascade = CascadeType.ALL, orphanRemoval = true)
	 private Jugement jugement;

	 @OneToOne(mappedBy = "premierCopie", cascade = CascadeType.ALL , orphanRemoval = true)
	 private ActeDeces acteDeces;

	 @Column(name = "numero")
	 private Long numero;

	 @Column(name = "anneeActuelle")
	 private int anneeActuelle;

	 @Column(name = "isnotSingle")
	 private boolean isnotSingle = Boolean.FALSE;

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }


    public String getIdPremierCopie() {
		return idPremierCopie;
	}

	public void setIdPremierCopie(String idPremierCopie) {
		this.idPremierCopie = idPremierCopie;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public int getAnneeActuelle() {
		return anneeActuelle;
	}

	public void setAnneeActuelle(int anneeActuelle) {
		this.anneeActuelle = anneeActuelle;
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



    public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public List<Mention> getMentions() {
		return mentions;
	}

	public void setMentions(List<Mention> mentions) {
		this.mentions = mentions;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


	public boolean isIsnotSingle() {
		return isnotSingle;
	}

	public void setIsnotSingle(boolean isnotSingle) {
		this.isnotSingle = isnotSingle;
	}

	public PremierCopie(String idPremierCopie, String description, String mention, String datePCopie,
			String datePremierCopie, Declarant declarant, Maire maire, Mere mere, Pere pere, Enfant enfant,
			PieceJustificative pieceJustificative, Instant createdDate, long numero, int anneeActuelle) {
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
		this.createdDate = createdDate;
		this.numero = numero;
		this.anneeActuelle = anneeActuelle;
	}

	public PremierCopie() {
		super();
		// TODO Auto-generated constructor stub
	}



}