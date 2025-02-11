package com.shosha.springboot.demo.jopportal.service;

import com.shosha.springboot.demo.jopportal.entity.Users;

import java.util.Optional;

public interface UsersService {
    Users createUser(Users user);
    Optional<Users> findUserByEmail(String username);
}
