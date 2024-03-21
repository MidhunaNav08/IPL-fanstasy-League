package com.Match.IPL;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Match.IPL.entity.UserEntity;
import com.Match.IPL.model.UserDTO;
import com.Match.IPL.repository.UserRepository;
import com.Match.IPL.utils.UserUtils;

@SpringBootTest
class IplApplicationTests {

	@Autowired
	UserRepository userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	 void testRegister() {
		UserDTO user = new UserDTO();
		user.setPassword(passwordEncoder.encode("abc123"));
		user.setEmail("sahu@gmail.com");
		user.setMobile_number("9536706590");
		user.setName("sahu");
		user.setUsername("SAHU");
		UserEntity userEntity = new UserEntity();
		userEntity = UserUtils.convertTouserEntity(user);
		userRepo.save(userEntity);	
		assertThat(2).isEqualTo(3);
	}
}
