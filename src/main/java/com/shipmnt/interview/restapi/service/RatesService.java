package com.shipmnt.interview.restapi.service;

import com.shipmnt.interview.restapi.entity.Rates;
import com.shipmnt.interview.restapi.exception.ResourceNotFoundException;
import com.shipmnt.interview.restapi.repository.RatesRepository;
import org.springframework.stereotype.Service;

@Service
public class RatesService {

    private final RatesRepository ratesRepository;

    public RatesService(RatesRepository ratesRepository) {
        this.ratesRepository = ratesRepository;
    }

    public Rates save(Rates rates){
        return ratesRepository.save(rates);
    }

    public Rates findById(Long id){
        return ratesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rates Not exit with this is" + id ));
    }
}
