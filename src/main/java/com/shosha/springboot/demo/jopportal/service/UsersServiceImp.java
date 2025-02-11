package com.shosha.springboot.demo.jopportal.service;

import com.shosha.springboot.demo.jopportal.entity.Users;
import com.shosha.springboot.demo.jopportal.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Slf4j
@Service
public class UsersServiceImp implements UsersService {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersServiceImp(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users createUser(Users user) {
        user.setIsActive(true);
        user.setRegistrationDate(new Date(System.currentTimeMillis()));
        log.info("User created: " + user);
        return usersRepository.save(user);
    }

    @Override
    public Optional<Users> findUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
}
