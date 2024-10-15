package com.desarrollosoftware.mutantes.dto;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StatsResponse {

    private Long countMutantDna;

    private Long countHumanDna;

    double ratio;
}
