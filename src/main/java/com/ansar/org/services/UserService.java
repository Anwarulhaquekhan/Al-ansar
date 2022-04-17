package com.ansar.org.services;

import java.util.List;

import com.ansar.org.domain.Role;
import com.ansar.org.domain.User;

public interface UserService {
	
	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String rolename);
	User getUser(String username);
	List<User> getUsers();

}
