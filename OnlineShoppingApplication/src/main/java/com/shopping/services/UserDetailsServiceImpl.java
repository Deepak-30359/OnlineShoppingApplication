package com.shopping.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.shopping.dao.UserRepository;
import com.shopping.entities.Role;
import com.shopping.entities.UserEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		System.out.println("In Authentication" + userName);
		UserEntity user = userRepository.findByUserName(userName);
		//System.out.println("In Authentication" + user.getUserName());
		if (user != null) {
			System.out.println("In Authentication-- if " + user.getUserName());
            return new User(user.getUserName(), user.getPassword(), createSimpleGrantedAuthorities(user.getRoles()));
        } else {
        	System.out.println("In Authentication+ ELSE PART" );
            throw new UsernameNotFoundException("User with "
                    + "user name "+ userName + " not found");
        }

	}
	
	private static List<SimpleGrantedAuthority> createSimpleGrantedAuthorities(Set<Role> roles){
		 List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		 authorities = roles.stream()
              .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
              .collect(Collectors.toList());
		 return authorities;
	}
}

