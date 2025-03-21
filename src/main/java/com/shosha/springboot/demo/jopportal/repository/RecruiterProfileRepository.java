package com.shosha.springboot.demo.jopportal.repository;

import com.shosha.springboot.demo.jopportal.entity.RecruiterProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Recruiter profile repository.
 */
@Repository
public interface RecruiterProfileRepository extends JpaRepository<RecruiterProfile, Integer> {
}
