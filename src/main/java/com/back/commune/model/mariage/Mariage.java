package com.back.commune.model.mariage;

import java.time.Instant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.back.commune.model.Maire;
import com.back.commune.model.Temoin;
import com.back.commune.model.auth.User;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="mariage")
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

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Long getIdMariage() {
		return idMariage;
	}

	public void setIdMariage(Long idMariage) {
		this.idMariage = idMariage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateMariage() {
		return dateMariage;
	}

	public void setDateMariage(String dateMariage) {
		this.dateMariage = dateMariage;
	}

	public String getHeureMariage() {
		return heureMariage;
	}

	public void setHeureMariage(String heureMariage) {
		this.heureMariage = heureMariage;
	}


	public Maire getMaire() {
		return maire;
	}

	public void setMaire(Maire maire) {
		this.maire = maire;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

    public String getNumeroCopieMariage() {
        return numeroCopieMariage;
    }

    public void setNumeroCopieMariage(String numeroCopieMariage) {
        this.numeroCopieMariage = numeroCopieMariage;
    }

    public Mariage() {
	}

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

    public Temoin getTemoinFemme() {
        return temoinFemme;
    }

    public void setTemoinFemme(Temoin temoinFemme) {
        this.temoinFemme = temoinFemme;
    }

    public Temoin getTemoinHomme() {
        return temoinHomme;
    }

    public void setTemoinHomme(Temoin temoinHomme) {
        this.temoinHomme = temoinHomme;
    }
}
