package com.desarrollosoftware.mutantes.mapper;

import com.desarrollosoftware.mutantes.dto.DnaRequest;
import com.desarrollosoftware.mutantes.dto.DnaResponse;
import com.desarrollosoftware.mutantes.models.Dna;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DnaMapper {

    DnaResponse dnaToDnaResponse(Dna dna);

    @Mapping(target = "mutant", ignore = true)
    Dna dnaRequestToDna(DnaRequest dnaRequest);


}
