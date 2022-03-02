package com.example.springbootsecuritydbdemo.controllers;

import com.example.springbootsecuritydbdemo.models.MyUser;
import com.example.springbootsecuritydbdemo.security.UserPrincipalService;
import com.example.springbootsecuritydbdemo.services.MyUserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin/management")
public class Management {

    private final MyUserService myUserService;

    public Management(MyUserService myUserService) {
        this.myUserService = myUserService;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MyUser> getAllUsers() {
        return myUserService.getAllUser();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MyUser getUser(@PathVariable Long id) {
        return myUserService.getUser(id);
    }
}
