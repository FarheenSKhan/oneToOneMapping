package com.mapping.service;

import com.mapping.dao.UserDao;
import com.mapping.entity.ResponseStructure;
import com.mapping.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public ResponseEntity<ResponseStructure<User>> saveUser (User user){
        ResponseStructure<User> responseStructure = new ResponseStructure<>();
        User user1 = userDao.findByMobile(user.getMobile());
        if(user1!=null){
            responseStructure.setStatus(HttpStatus.CONFLICT.value());
            responseStructure.setMessage("User already exists");
            responseStructure.setData(null);
            return new ResponseEntity<>(responseStructure, HttpStatus.CONFLICT);
        }else {
            if (user.getAadharCard() != null) {

                user.getAadharCard().setUser(user);
            }
            userDao.saveUser(user);
            responseStructure.setStatus(HttpStatus.CREATED.value());
            responseStructure.setMessage("User saved successfully");
            responseStructure.setData(user);
            return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<ResponseStructure<User>> deleteUser(Long id){
        ResponseStructure<User> responseStructure=new ResponseStructure<>();
        User user =userDao.findById(id);
        if(user == null){
            responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            responseStructure.setMessage("User not found");
            responseStructure.setData(null);
            return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        }else {
            userDao.deleteUser(user);
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("User deleted successfully");
            responseStructure.setData(user);
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        }
    }
   public ResponseEntity<ResponseStructure<List<User>>> findAll(){
        ResponseStructure<List<User>> responseStructure=new ResponseStructure<>();

        responseStructure.setStatus(HttpStatus.OK.value());
        responseStructure.setMessage("All Users found successfully");
        responseStructure.setData(userDao.findAll());
        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
   }

   public ResponseEntity<ResponseStructure<User>> findById(Long id){
        ResponseStructure<User> responseStructure=new ResponseStructure<>();
        User user=userDao.findById(id);
        if(user == null){
            responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            responseStructure.setMessage("User not found");
            responseStructure.setData(null);
            return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        }else{
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("User found by id");
            responseStructure.setData(user);
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        }
    }

     public ResponseEntity<ResponseStructure<User>> findByEmail(String email){
        ResponseStructure<User> responseStructure=new ResponseStructure<>();
        User user=userDao.findByEmail(email);
        if(user == null){
            responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            responseStructure.setMessage("User not found");
            responseStructure.setData(null);
            return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        }else{
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("User found by email");
            responseStructure.setData(user);
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        }
     }
     public ResponseEntity<ResponseStructure<User>> findByMobile(String mobile){
        ResponseStructure<User> responseStructure=new ResponseStructure<>();
        User user=userDao.findByMobile(mobile);
        if(user == null){
            responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            responseStructure.setMessage("User not found");
            responseStructure.setData(null);
            return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        }else{
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("User found by mobile");
            responseStructure.setData(user);
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        }
     }

     public ResponseEntity<ResponseStructure<User>> updateUser(User user){
        ResponseStructure<User> responseStructure=new ResponseStructure<>();
        User user1=userDao.findById(user.getId());
        if(user1 == null){
            responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            responseStructure.setMessage("User not found");
            responseStructure.setData(null);
            return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        }else{
            if (user.getAadharCard()!= null) {
                user.getAadharCard().setUser(user);
            }
            userDao.updateUser(user);
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("User updated successfully");
            responseStructure.setData(user);
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        }
     }





}

