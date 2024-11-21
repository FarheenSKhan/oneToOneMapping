package com.mapping.controller;

import com.mapping.entity.ResponseStructure;
import com.mapping.entity.User;
import com.mapping.repository.UserRepository;
import com.mapping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/save")
    public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody  User user){
        return userService.saveUser(user);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<ResponseStructure<User>> deleteUser(@RequestParam Long id){
        return userService.deleteUser(id);
    }

    @GetMapping("/GetAllUsers")
    public ResponseEntity<ResponseStructure<List<User>>> findAll(){
        return userService.findAll();
    }
    @GetMapping("/GetById")
    public ResponseEntity<ResponseStructure<User>>  findById(@RequestParam Long id){
        return userService.findById(id);
    }

    @GetMapping("/GetByEmail")
    public ResponseEntity<ResponseStructure<User>> findByEmail(@RequestParam String email){
        return userService.findByEmail(email);
    }
    @GetMapping("/GetByMobile")
    public ResponseEntity<ResponseStructure<User>> findByMobile(@RequestParam String mobile){
        return userService.findByMobile(mobile);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user){
        return  userService.updateUser(user);
    }

}
