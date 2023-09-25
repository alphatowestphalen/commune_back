package com.back.commune.model;



import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;

import java.util.List;


import javax.persistence.*;

import com.back.commune.model.auth.User;
import com.back.commune.model.deces.ActeDeces;
import com.back.commune.utils.AuditTrailListener;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;


@Entity
@Table(name="premierCopie")
@Getter
@Setter
@NoArgsConstructor
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
}
