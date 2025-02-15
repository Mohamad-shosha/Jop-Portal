package com.shosha.springboot.demo.jopportal.service;

import com.shosha.springboot.demo.jopportal.entity.Users;

import java.util.Optional;

public interface UsersService {
    Users addNew(Users user);
    Optional<Users> getUserByEmail(String username);
}
