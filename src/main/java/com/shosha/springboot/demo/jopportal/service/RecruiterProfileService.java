package com.shosha.springboot.demo.jopportal.service;

import com.shosha.springboot.demo.jopportal.entity.RecruiterProfile;

import java.util.Optional;

public interface RecruiterProfileService {
    Optional<RecruiterProfile> getOne(Integer id);
}
