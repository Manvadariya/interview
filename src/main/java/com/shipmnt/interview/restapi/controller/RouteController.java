package com.shipmnt.interview.restapi.controller;

import com.shipmnt.interview.restapi.entity.ConnectionRequestDTO;
import com.shipmnt.interview.restapi.entity.Rates;
import com.shipmnt.interview.restapi.entity.RatesDTO;
import com.shipmnt.interview.restapi.repository.RatesRepository;
import com.shipmnt.interview.restapi.service.RatesService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RouteController {
    private final RatesService ratesService;
    private final EntityManager entityManager;

    public RouteController(RatesService ratesService, EntityManager entityManager) {
        this.ratesService = ratesService;
        this.entityManager = entityManager;
    }


    @PostMapping("/rates")
    public Rates addRates(@RequestHeader("current_user_id") Long senderId,@Valid @RequestBody Rates rates){
        return ratesService.save(rates);
    }

//    @PostMapping("/rates/search")
//    public List<Rates> findRates(@RequestHeader("current_user_id") Long senderId,@Valid @RequestBody RatesDTO ratesDTO){
//        // finding ratesDTO.fromLocation == ... ratesDTO.toLocation = ...
//        TypedQuery<Rates> query = entityManager.createQuery("select r form Rates as r  where r.fromLocation = " + ratesDTO.getFromLocation() + "and r.toLocation =" + ratesDTO.getToLocation());
//        return query.getResultList();
//    }
 }