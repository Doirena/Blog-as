package com.dovile.userlogin;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dovile.userlogin.entities.User;
import com.dovile.userlogin.repos.UserRepository;

@SpringBootTest
class UserloginApplicationTests {
//	@Test
//	void contextLoads() {
//	}
	
	@Autowired
	private UserRepository userRepository;

	
	@Test
	public void testCreateUser() {

		User user = new User();
		user.setEmail("email2@gmail");
		user.setPassword("test");
		User saveUser = userRepository.save(user);
		assertThat(saveUser.getEmail()).isNotNull();
		
	}

}
