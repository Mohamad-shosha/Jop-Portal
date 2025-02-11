package com.shosha.springboot.demo.jopportal.repository;

import com.shosha.springboot.demo.jopportal.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByEmail(String username);
}
