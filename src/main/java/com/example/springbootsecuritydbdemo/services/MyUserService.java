package com.example.springbootsecuritydbdemo.services;

import com.example.springbootsecuritydbdemo.exceptions.NotFoundException;
import com.example.springbootsecuritydbdemo.models.MyUser;
import com.example.springbootsecuritydbdemo.repositories.MyUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserService {

    private final MyUserRepository myUserRepository;

    public MyUserService(MyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }

    public List<MyUser> getAllUser() {
        return myUserRepository.findAll();
    }

    public MyUser getUser(Long id) {
        return myUserRepository.findById(id)
                .orElseThrow(() -> {
            throw new NotFoundException("User Not Found");
        });
    }
}
