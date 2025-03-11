package com.shosha.springboot.demo.jopportal.service;

import com.shosha.springboot.demo.jopportal.entity.RecruiterProfile;

import java.util.Optional;

/**
 * The interface Recruiter profile service.
 */
public interface RecruiterProfileService {
    /**
     * Gets one.
     *
     * @param id the id
     * @return the one
     */
    Optional<RecruiterProfile> getOne(Integer id);
}
