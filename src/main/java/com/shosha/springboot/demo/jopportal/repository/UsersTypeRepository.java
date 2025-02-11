package com.shosha.springboot.demo.jopportal.repository;

import com.shosha.springboot.demo.jopportal.entity.UsersType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersTypeRepository  extends JpaRepository<UsersType, Integer> {
}
