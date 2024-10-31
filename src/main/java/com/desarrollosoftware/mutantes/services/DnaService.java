package com.desarrollosoftware.mutantes.services;

import com.desarrollosoftware.mutantes.dto.DnaShortResponse;
import com.desarrollosoftware.mutantes.models.exceptions.NotMutantException;
import com.desarrollosoftware.mutantes.dto.DnaRequest;
import com.desarrollosoftware.mutantes.dto.DnaResponse;
import com.desarrollosoftware.mutantes.mapper.DnaMapper;
import com.desarrollosoftware.mutantes.models.Dna;
import com.desarrollosoftware.mutantes.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DnaService {

    @Autowired
    public DnaRepository dnaRepository;

    @Autowired
    public DnaAnalysisService analysisService;

    @Autowired
    public DnaMapper dnaMapper;

    public DnaResponse analyzeDna(DnaRequest dnaRequest) {

        Dna dna = dnaMapper.dnaRequestToDna(dnaRequest);

        dna.setMutant(analysisService.isMutant(dna.getDna()));

        DnaResponse dnaResponse = dnaMapper.dnaToDnaResponse(dnaRepository.save(dna));

        if (!dna.getMutant()) {
            throw new NotMutantException("The DNA entered does not correspond to a mutant");
        } else
            return dnaResponse;
    }

    public List<DnaShortResponse> analyzeDna(List<DnaRequest> dnaList) {

        List<DnaShortResponse> dnaResponseList = new ArrayList<>();
        for (DnaRequest dnaRequest : dnaList) {

            Dna dna = dnaMapper.dnaRequestToDna(dnaRequest);

            dna.setMutant(analysisService.isMutant(dna.getDna()));

            dnaResponseList.add(dnaMapper.dnaToDnaShortResponse(dnaRepository.save(dna)));

        }
        return dnaResponseList;
    }



}
