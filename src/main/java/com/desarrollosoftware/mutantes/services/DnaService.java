package com.desarrollosoftware.mutantes.services;

import com.desarrollosoftware.mutantes.dto.DnaRequest;
import com.desarrollosoftware.mutantes.dto.DnaResponse;
import com.desarrollosoftware.mutantes.mapper.DnaMapper;
import com.desarrollosoftware.mutantes.models.Dna;
import com.desarrollosoftware.mutantes.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DnaService {

    @Autowired
    public DnaRepository dnaRepository;

    @Autowired
    public DnaAnalysisService analysisService;

    @Autowired
    public DnaMapper dnaMapper;

    public List<Dna> getAll() {

        return dnaRepository.findAll();
    }

    public DnaResponse analyzeDna(DnaRequest dnaRequest) {

        Dna dna = dnaMapper.dnaRequestToDna(dnaRequest);

        dna.setMutant(analysisService.isMutant(dna.getDna()));

        return dnaMapper.dnaToDnaResponse(dnaRepository.save(dna));
    }

    public List<DnaResponse> analyzeDna(List<DnaRequest> dnaList) {

        List<DnaResponse> dnaResponseList = new ArrayList<>();
        for (DnaRequest dnaRequest : dnaList) {

            dnaResponseList.add(analyzeDna(dnaRequest));

        }
        return dnaResponseList;
    }



}
