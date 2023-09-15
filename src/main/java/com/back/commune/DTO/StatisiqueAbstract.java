package com.back.commune.DTO;

import com.back.commune.DTO.resulSet.CountByUser;
import com.back.commune.model.auth.User;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class StatisiqueAbstract {
    private Long nombre;
    private List<CountByUser> nombreParUtilisateur;
}
