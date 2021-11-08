package com.nus.iss.service;

import com.nus.iss.config.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private static final String PASSWORD = "password";
    private static final String USERNAME = "john";

    @Autowired
    private WebSecurityConfig securityConfig;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals(USERNAME)){
            return new User(USERNAME, securityConfig.passwordEncoder().encode(PASSWORD), new ArrayList<>());
        }else
            throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
