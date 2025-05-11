package com.harvard.libraryManagement.service;

import com.harvard.libraryManagement.dto.UserCreationRequest;
import com.harvard.libraryManagement.dto.UserCreationResponse;
import com.harvard.libraryManagement.enums.Operator;
import com.harvard.libraryManagement.enums.UserFilter;
import com.harvard.libraryManagement.entity.UserEntity;
import com.harvard.libraryManagement.enums.UserType;
import com.harvard.libraryManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

     @Autowired
     private UserRepository userRepo;

     public UserCreationResponse addStudent(UserCreationRequest request){
         UserEntity user = request.toUser();
         user.setUserType(UserType.STUDENT);
         UserEntity userFromDb = userRepo.save(user);

        return  UserCreationResponse.builder()
                  .userName(userFromDb.getName())
                  .emailId(userFromDb.getEmail())
                  .address(userFromDb.getAddress())
                  .mobileNo(userFromDb.getPhoneNo())
                  .build();
     }

     public List<UserEntity> filter(UserFilter filterBy, Operator operator, String value){
         switch(filterBy){
             case NAME :
                 switch (operator){
                     case EQUALS :
                         return userRepo.findByName(value);
                     case LIKE:
                         return userRepo.findByNameContains(value);
                         //if we want to use findByLike then we need to pass the value in
                         // % symbol ===> "%"+value+"%"
                 }
             case EMAIL:
                 switch(operator){
                     case EQUALS :
                         return userRepo.findByEmail(value);
                     case LIKE:
                         return userRepo.findByEmailContains(value);
                 }
             case PHONE:
                 switch (operator){
                     case EQUALS :
                         return userRepo.findByPhoneNo(value);
                     case LIKE:
                         return userRepo.findByPhoneNoContains(value);
                 }
         }
         return new ArrayList<>();
     }



}
