package com.back.commune.mapper;

import com.back.commune.model.deces.ActeDeces;
import com.back.commune.model.deces.Defunt;
import com.back.commune.request.DecesRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActeDeDecesMapper {

    Defunt convertToDefunt(DecesRequest decesRequest);

    ActeDeces convertToActeDeDeces(DecesRequest decesRequest);
}
