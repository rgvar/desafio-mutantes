package com.desarrollosoftware.mutantes.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DnaResponse {
    private Long id;
    private String[] dna;
    private Boolean mutant;
}
