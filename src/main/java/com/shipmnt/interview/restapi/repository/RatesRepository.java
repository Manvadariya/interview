package com.shipmnt.interview.restapi.repository;

import com.shipmnt.interview.restapi.entity.Rates;
import com.shipmnt.interview.restapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatesRepository extends JpaRepository<Rates, Long> {

}
