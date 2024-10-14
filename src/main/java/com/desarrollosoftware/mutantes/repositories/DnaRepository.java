package com.desarrollosoftware.mutantes.repositories;

import com.desarrollosoftware.mutantes.models.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaRepository extends JpaRepository<Dna, Long> {

}
