package com.back.commune.DTO;

import com.back.commune.model.Femme;
import com.back.commune.model.Homme;
import com.back.commune.model.Maire;
import com.back.commune.model.auth.User;
import lombok.Data;

import java.time.Instant;

@Data
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
