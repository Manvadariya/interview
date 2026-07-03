package com.shipmnt.interview.restapi.service;

import com.shipmnt.interview.restapi.entity.User;
import com.shipmnt.interview.restapi.exception.ResourceNotFoundException;
import com.shipmnt.interview.restapi.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not exit with this is" + id ));
    }
}
