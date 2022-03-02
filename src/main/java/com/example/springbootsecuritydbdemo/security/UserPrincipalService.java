package com.example.springbootsecuritydbdemo.security;

import com.example.springbootsecuritydbdemo.models.MyUser;
import com.example.springbootsecuritydbdemo.repositories.MyUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPrincipalService implements UserDetailsService {

    private final MyUserRepository myUserRepository;

    public UserPrincipalService(MyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = myUserRepository.
                findMyUserByUsername(username)
                .orElse(null);

        if (myUser == null) {
            System.out.println("----not found----");
            throw new UsernameNotFoundException("user " + username + " Not Found");
        }

        return new UserPrincipal(myUser);

    }
}
