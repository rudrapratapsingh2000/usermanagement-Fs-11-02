package com.usermanagement.controller;

import com.usermanagement.model.UserModels;
import com.usermanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/userapp")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/adduser")
    public String addUser(@RequestBody @Valid UserModels user){
        return userService.addUser(user);
    }
    @GetMapping("/finduser/number/{number}")
    public UserModels getuser(@PathVariable Integer number){
        return userService.getUser(number);
    }

    @GetMapping("/findalluser")
    public List<UserModels> getAllUser(){
        return userService.getAllUser();
    }

    @DeleteMapping("/deleteuser/number/{number}")
    public String deleteUser(@PathVariable Integer number){
        return userService.deleteUser(number);
    }

    @PutMapping("/updateuser/number/{number}")
    public String updateUser(@PathVariable Integer number, @RequestBody UserModels user){
        return userService.updateUserInfo(number,user);
    }
}
