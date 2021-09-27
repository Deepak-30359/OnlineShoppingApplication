package com.shopping;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.shopping.dao.ILoginRepository;
import com.shopping.entities.User;
import com.shopping.services.LoginServiceImpl;

@ExtendWith(MockitoExtension.class)
 class ILoginServiceTest {
	@Mock
	private ILoginRepository loginRepository;
	@InjectMocks
	private LoginServiceImpl loginService;
	
	//add user
		@Test
		void saveUserTest() {
			User user = new User(1,"abc123","Admin");
			when(loginRepository.save(user)).thenReturn(user);
			User savedUser = loginService.addUser(user);
			assertThat(savedUser).isNotNull();
			assertEquals("Admin",savedUser.getRole());
		}
		
}
