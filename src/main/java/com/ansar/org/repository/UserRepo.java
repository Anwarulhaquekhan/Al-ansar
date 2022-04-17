package com.ansar.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ansar.org.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	User findByUserName(String username);

}
