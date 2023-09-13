package com.back.commune.DTO;

import com.back.commune.model.Femme;
import com.back.commune.model.Homme;
import com.back.commune.model.Maire;
import com.back.commune.model.auth.User;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.Instant;

public class MariageDTO {

    private Homme homme;
    private Femme femme;
    private String idMariage;
    private String description;
    private String dateMariage;
    private String heureMariage;
    private Long numero;
    private int annee;
    private User createdBy;
    private Maire maire;
    private Instant createdDate;

}
