package com.shosha.springboot.demo.jopportal.service;

import com.shosha.springboot.demo.jopportal.entity.Users;

import java.util.Optional;

/**
 * The interface Users service.
 */
public interface UsersService {
    /**
     * Add new users.
     *
     * @param user the user
     * @return the users
     */
    Users addNew(Users user);

    /**
     * Gets user by email.
     *
     * @param username the username
     * @return the user by email
     */
    Optional<Users> getUserByEmail(String username);

    /**
     * Gets current user profile.
     *
     * @return the current user profile
     */
    Object getCurrentUserProfile();
}
