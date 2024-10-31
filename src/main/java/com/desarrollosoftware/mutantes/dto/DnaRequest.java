package com.desarrollosoftware.mutantes.dto;

import com.desarrollosoftware.mutantes.validator.ValidDna;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DnaRequest {

    @ValidDna
    private String[] dna;

}
