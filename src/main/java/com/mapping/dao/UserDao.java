package com.mapping.dao;

import com.mapping.entity.User;
import com.mapping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public User findById(Long id){
        Optional<User> optional=userRepository.findById(id);
        return optional.orElse(null);
    }
    public List<User>  findAll(){
        return userRepository.findAll();
    }

    public User findByMobile(String mobile) {
        return userRepository.findByMobile(mobile);
    }

    public User findByEmail(String email){
        return  userRepository.findByEmail(email);
    }
}
