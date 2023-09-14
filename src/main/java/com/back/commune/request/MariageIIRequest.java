package com.back.commune.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class MariageIIRequest extends  MariageRequest{
    private String idPremierCopieHomme;
    private String idPremierCopieFemme;
}
