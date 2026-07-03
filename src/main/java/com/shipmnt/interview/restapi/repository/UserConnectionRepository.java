package com.shipmnt.interview.restapi.repository;

import com.shipmnt.interview.restapi.entity.User;
import com.shipmnt.interview.restapi.entity.UserConnection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserConnectionRepository extends JpaRepository<UserConnection, Long> {

}
