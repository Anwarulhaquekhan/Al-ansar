package com.ansar.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansar.org.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
	Role findByName(String name);

}
