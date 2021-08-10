package com.desafiomercadolivre.zup.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<UserRequest> insertUser(@RequestBody @Valid UserRequest request){
        User user = request.toModel();
        if(userRepository.existsByLogin(request.getLogin())){
            return  ResponseEntity.badRequest().build();
        }
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }
}