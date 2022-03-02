package com.example.springbootsecuritydbdemo.repositories;

import com.example.springbootsecuritydbdemo.models.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Long> {

    Optional<MyUser> findMyUserByUsername(String username);
}
