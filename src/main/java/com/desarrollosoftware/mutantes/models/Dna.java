package com.desarrollosoftware.mutantes.models;


import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Dna extends Base implements Serializable {

    private String[] dna;
    private Boolean mutant;

}
