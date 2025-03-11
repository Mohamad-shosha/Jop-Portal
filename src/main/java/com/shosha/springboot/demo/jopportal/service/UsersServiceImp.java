package com.shosha.springboot.demo.jopportal.service;

import com.shosha.springboot.demo.jopportal.entity.JobSeekerProfile;
import com.shosha.springboot.demo.jopportal.entity.RecruiterProfile;
import com.shosha.springboot.demo.jopportal.entity.Users;
import com.shosha.springboot.demo.jopportal.repository.JobSeekerProfileRepository;
import com.shosha.springboot.demo.jopportal.repository.RecruiterProfileRepository;
import com.shosha.springboot.demo.jopportal.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * The type Users service imp.
 */
@Slf4j
@Service
public class UsersServiceImp {

    private final UsersRepository usersRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Instantiates a new Users service imp.
     *
     * @param usersRepository            the users repository
     * @param jobSeekerProfileRepository the job seeker profile repository
     * @param recruiterProfileRepository the recruiter profile repository
     * @param passwordEncoder            the password encoder
     */
    @Autowired
    public UsersServiceImp(UsersRepository usersRepository, JobSeekerProfileRepository jobSeekerProfileRepository,
                           RecruiterProfileRepository recruiterProfileRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Add new users.
     *
     * @param users the users
     * @return the users
     */
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

    /**
     * Gets current user profile.
     *
     * @return the current user profile
     */
    public Object getCurrentUserProfile() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String username = authentication.getName();
            Users users = usersRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("Could not found " + "user"));
            int userId = users.getUserId();
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("Recruiter"))) {
                return recruiterProfileRepository.findById(userId).orElse(new RecruiterProfile());
            } else {
                return jobSeekerProfileRepository.findById(userId).orElse(new JobSeekerProfile());
            }
        }

        return null;
    }

    /**
     * Gets user by email.
     *
     * @param email the email
     * @return the user by email
     */
    public Optional<Users> getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

}
