package com.shosha.springboot.demo.jopportal.repository;

import com.shosha.springboot.demo.jopportal.entity.UsersType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Users type repository.
 */
@Repository
public interface UsersTypeRepository  extends JpaRepository<UsersType, Integer> {
}
