package com.ansar.org.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ansar.org.domain.Role;
import com.ansar.org.domain.User;
import com.ansar.org.repository.RoleRepo;
import com.ansar.org.repository.UserRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor @Transactional @Slf4j
public class UserServicesImpl implements UserService, UserDetailsService {
	
	private final UserRepo userRepo;
	private final RoleRepo roleRepo;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUserName(username);
		if(user == null) {
			log.error("User not found in the database");
		}else {
			log.info("User found in the database: {}", username);
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
	}

	@Override
	public User saveUser(User user) {
		log.info("saving new user {} to the database", user.getFirstName());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		log.info("saving new role {} to the database", role.getName());
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String rolename) {
		log.info("Adding role {} to the user", rolename,username);
		User user = userRepo.findByUserName(username);
		Role role = roleRepo.findByName(rolename);
		user.getRoles().add(role);
		
	}

	@Override
	public User getUser(String username) {
		log.info("Adding role {} to the user",username);
		return userRepo.findByUserName(username);
	}

	@Override
	public List<User> getUsers(){
		log.info("Fetching all users");
		return userRepo.findAll(); 
	}

	
	
}