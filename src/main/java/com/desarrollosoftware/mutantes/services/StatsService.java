package com.desarrollosoftware.mutantes.services;

import com.desarrollosoftware.mutantes.dto.StatsResponse;
import com.desarrollosoftware.mutantes.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class StatsService {

    @Autowired
    public DnaRepository dnaRepository;

    public StatsResponse getStats() {
        List<Object[]> count = dnaRepository.countMutantCondition();
        Long mutantCount;
        Long humanCount;
        if ((Boolean) count.get(0)[0]) {
            mutantCount = (Long) count.get(0)[1];
            humanCount = (Long) count.get(1)[1];
        } else {
            mutantCount = (Long) count.get(1)[1];
            humanCount = (Long) count.get(0)[1];
        }

        double ratio = Math.round((mutantCount / (double) humanCount) * 100) / 100.0;
        return new StatsResponse(mutantCount, humanCount, ratio);
    }

}
