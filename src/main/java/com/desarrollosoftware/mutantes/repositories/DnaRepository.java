package com.desarrollosoftware.mutantes.repositories;

import com.desarrollosoftware.mutantes.models.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DnaRepository extends JpaRepository<Dna, Long> {

    @Query("SELECT d.mutant, COUNT(d) FROM Dna d GROUP BY d.mutant")
    List<Object[]> countMutantCondition();

}
