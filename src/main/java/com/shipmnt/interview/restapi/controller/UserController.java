package com.shipmnt.interview.restapi.controller;

import com.shipmnt.interview.restapi.entity.*;
import com.shipmnt.interview.restapi.service.UserConnectionService;
import com.shipmnt.interview.restapi.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;
    private final UserConnectionService userConnectionService;

    public UserController(UserService userService, UserConnectionService userConnectionService) {
        this.userService = userService;
        this.userConnectionService = userConnectionService;
    }


    @PostMapping("/users")
    public User createUser(@RequestBody User user){
       return userService.save(user);
   }

   @PostMapping("/connect")
    public ConnectionRequestDTO sendConnectionRequest(@RequestHeader("current_user_id") Long senderId, @RequestBody ConnectionRequestDTO connectionRequestDTO){
        UserConnection userConnection = new UserConnection();
       User receiver = userService.findById(connectionRequestDTO.getToUserId());
       User sender = userService.findById(connectionRequestDTO.getFromUserId());
        userConnection.setReceiver(receiver);
        userConnection.setSender(sender);
        userConnection.setStatus(ConnectionStatus.PENDING);
       userConnection = userConnectionService.save(userConnection);

       ConnectionRequestDTO response = new ConnectionRequestDTO();
       response.setId(userConnection.getId());
       response.setToUserId(userConnection.getReceiver().getId());
       response.setFromUserId(userConnection.getSender().getId());
       return response;
   }

   @PatchMapping("/connect/respond")
    public ConnectionRespondDTO sendConnectionRespond(@RequestHeader("current_user_id") Long senderId, @RequestBody ConnectionRespondDTO connectionRespondDTO){
        UserConnection userConnection = userConnectionService.findById(connectionRespondDTO.getId());
        userConnection.setStatus(connectionRespondDTO.getStatus());
       ConnectionRespondDTO response = new ConnectionRespondDTO();
       response.setId(userConnection.getId());
       response.setToUserId(userConnection.getReceiver().getId());
       response.setFromUserId(userConnection.getSender().getId());
       response.setStatus(userConnection.getStatus());
       return response;
   }



}
