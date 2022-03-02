package com.example.springbootsecuritydbdemo.bootstrap;

import com.example.springbootsecuritydbdemo.models.MyUser;
import com.example.springbootsecuritydbdemo.repositories.MyUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final MyUserRepository myUserRepository;


    public DataLoader(MyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        MyUser dan = new MyUser("user", new BCryptPasswordEncoder().encode("123"), "USER", "");
        MyUser admin = new MyUser("admin", new BCryptPasswordEncoder().encode("123"), "ADMIN", "ACCESS_TEST1,ACCESS_TEST2");
        MyUser manager = new MyUser("manager", new BCryptPasswordEncoder().encode("123"), "MANAGER", "ADMIN:READ");

        List<MyUser> users = Arrays.asList(dan, admin, manager);

        // Save to db
        this.myUserRepository.saveAll(users);
    }
}
