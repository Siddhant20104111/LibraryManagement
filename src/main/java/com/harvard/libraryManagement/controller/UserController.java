package com.harvard.libraryManagement.controller;


import com.harvard.libraryManagement.dto.UserCreationRequest;
import com.harvard.libraryManagement.dto.UserCreationResponse;
import com.harvard.libraryManagement.enums.Operator;
import com.harvard.libraryManagement.enums.UserFilter;
import com.harvard.libraryManagement.entity.UserEntity;
import com.harvard.libraryManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addStudent")
    public UserCreationResponse createUser(@RequestBody @Validated UserCreationRequest user){
         return userService.addStudent(user);
    }

    @GetMapping("/filter")
    public List<UserEntity> filterUser(@RequestParam("filterBy") UserFilter filterBy,
                                          @RequestParam("operator") Operator operator,
                                          @RequestParam("value") String value
                                                  ){
          return userService.filter(filterBy,operator,value);
    }

}
