package com.shosha.springboot.demo.jopportal.service;

import com.shosha.springboot.demo.jopportal.entity.RecruiterProfile;
import com.shosha.springboot.demo.jopportal.repository.RecruiterProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The type Recruiter profile service imp.
 */
@Service
public class RecruiterProfileServiceImp implements RecruiterProfileService {

    private final RecruiterProfileRepository recruiterProfileRepository;

    /**
     * Instantiates a new Recruiter profile service imp.
     *
     * @param recruiterProfileRepository the recruiter profile repository
     */
    @Autowired
    public RecruiterProfileServiceImp(RecruiterProfileRepository recruiterProfileRepository) {
        this.recruiterProfileRepository = recruiterProfileRepository;
    }

    public Optional<RecruiterProfile> getOne(Integer id) {
        return recruiterProfileRepository.findById(id);
    }

    /**
     * Add new recruiter profile.
     *
     * @param recruiterProfile the recruiter profile
     * @return the recruiter profile
     */
    public RecruiterProfile addNew(RecruiterProfile recruiterProfile) {
        return recruiterProfileRepository.save(recruiterProfile);
    }
}