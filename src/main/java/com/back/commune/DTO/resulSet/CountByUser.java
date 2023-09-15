package com.back.commune.DTO.resulSet;

import com.back.commune.model.auth.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountByUser {
    private User user;
    private Long count;
}
