package com.turkcell.intro.web.repository;

import com.turkcell.intro.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> { }
