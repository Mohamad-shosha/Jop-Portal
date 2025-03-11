package com.shosha.springboot.demo.jopportal.repository;

import com.shosha.springboot.demo.jopportal.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Users repository.
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    /**
     * Find by email optional.
     *
     * @param username the username
     * @return the optional
     */
    Optional<Users> findByEmail(String username);
}
