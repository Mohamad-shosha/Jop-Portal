package com.shosha.springboot.demo.jopportal.repository;

import com.shosha.springboot.demo.jopportal.entity.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerProfileRepository extends JpaRepository<JobSeekerProfile, Integer> {
}
