package com.shipmnt.interview.restapi.service;

import com.shipmnt.interview.restapi.entity.UserConnection;
import com.shipmnt.interview.restapi.exception.ResourceNotFoundException;
import com.shipmnt.interview.restapi.repository.UserConnectionRepository;
import org.springframework.stereotype.Service;

@Service
public class UserConnectionService {

    private final UserConnectionRepository userConnectionRepository;

    public UserConnectionService(UserConnectionRepository userConnectionRepository) {
        this.userConnectionRepository = userConnectionRepository;
    }


    public UserConnection save(UserConnection userConnection){
        return userConnectionRepository.save(userConnection);
    }

    public UserConnection findById(Long id){
        return userConnectionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not exit with this is" + id ));
    }
}
