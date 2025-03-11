package com.shosha.springboot.demo.jopportal.service;

import com.shosha.springboot.demo.jopportal.entity.UsersType;
import com.shosha.springboot.demo.jopportal.repository.UsersTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Users type service imp.
 */
@Service
public class UsersTypeServiceImp implements UsersTypeService {
    private final UsersTypeRepository usersTypeRepository;

    /**
     * Instantiates a new Users type service imp.
     *
     * @param usersTypeRepository the users type repository
     */
    @Autowired
    public UsersTypeServiceImp(UsersTypeRepository usersTypeRepository) {
        this.usersTypeRepository = usersTypeRepository;
    }

    public List<UsersType> findAll() {
        return usersTypeRepository.findAll();
    }
}
