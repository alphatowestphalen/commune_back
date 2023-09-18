package com.back.commune.model.mariage;

import java.time.Instant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.back.commune.model.Maire;
import com.back.commune.model.Temoin;
import com.back.commune.model.auth.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="mariage")
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "typeMariage")
public class Mariage {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idMariage")
	private Long idMariage;

	@Column(name = "description")
	private String description;

	@Column(name = "dateMariage")
	private String dateMariage;

	@Column(name = "heureMariage")
	private String heureMariage;

	@Column(name = "numeroCopieMariage")
    private String numeroCopieMariage;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "temoin_femme_id",nullable = false)
    protected Temoin temoinFemme;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "temoin_homme_id", nullable = false)
    protected Temoin temoinHomme;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private User createdBy;


	@ManyToOne()
	@JoinColumn(name ="idMaire")
	private Maire maire;

	@CreationTimestamp
	private Instant createdDate;
    public Mariage(Mariage mariage) {
        this.idMariage = mariage.getIdMariage();
        this.description = mariage.getDescription();
        this.dateMariage = mariage.getDateMariage();
        this.heureMariage = mariage.getHeureMariage();
        this.numeroCopieMariage = mariage.getNumeroCopieMariage();
        this.maire = mariage.getMaire();
    }
    public Mariage(Long idMariage, String description, String dateMariage, String heureMariage, String numeroCopieMariage, Maire maire) {
        this.idMariage = idMariage;
        this.description = description;
        this.dateMariage = dateMariage;
        this.heureMariage = heureMariage;
        this.numeroCopieMariage = numeroCopieMariage;
        this.maire = maire;
    }
}
