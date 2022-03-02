package com.example.springbootsecuritydbdemo.controllers;

import com.example.springbootsecuritydbdemo.security.UserPrincipalService;
import com.example.springbootsecuritydbdemo.security.jwt.UsernameAndPasswordAuthRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class Login {

    private final AuthenticationManager authenticationManager;
    private final UserPrincipalService userPrincipalService;

    public Login(AuthenticationManager authenticationManager, UserPrincipalService userPrincipalService) {
        this.authenticationManager = authenticationManager;
        this.userPrincipalService = userPrincipalService;
    }


    @PostMapping
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UsernameAndPasswordAuthRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userPrincipalService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
