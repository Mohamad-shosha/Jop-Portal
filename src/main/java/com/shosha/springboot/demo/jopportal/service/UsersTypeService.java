package com.shosha.springboot.demo.jopportal.service;

import com.shosha.springboot.demo.jopportal.entity.UsersType;

import java.util.List;

/**
 * The interface Users type service.
 */
public interface UsersTypeService {
    /**
     * Find all list.
     *
     * @return the list
     */
    List<UsersType> findAll();
}
