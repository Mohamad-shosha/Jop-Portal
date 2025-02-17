package com.shosha.springboot.demo.jopportal.service;

import com.shosha.springboot.demo.jopportal.entity.JobSeekerProfile;
import com.shosha.springboot.demo.jopportal.entity.RecruiterProfile;
import com.shosha.springboot.demo.jopportal.entity.Users;
import com.shosha.springboot.demo.jopportal.repository.JobSeekerProfileRepository;
import com.shosha.springboot.demo.jopportal.repository.RecruiterProfileRepository;
import com.shosha.springboot.demo.jopportal.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Slf4j
@Service
public class UsersServiceImp {

    private final UsersRepository usersRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsersServiceImp(UsersRepository usersRepository, JobSeekerProfileRepository jobSeekerProfileRepository,
                           RecruiterProfileRepository recruiterProfileRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Users addNew(Users users) {
        users.setIsActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        Users savedUser = usersRepository.save(users);
        log.info("User saved: {}", savedUser);
        int userTypeId = users.getUserTypeId().getUserTypeId();

        if (userTypeId == 1) {
            recruiterProfileRepository.save(new RecruiterProfile(savedUser));
        } else {
            jobSeekerProfileRepository.save(new JobSeekerProfile(savedUser));
        }

        return savedUser;
    }

    public Optional<Users> getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

}
