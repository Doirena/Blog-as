package com.dovile.userlogin.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dovile.userlogin.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}
