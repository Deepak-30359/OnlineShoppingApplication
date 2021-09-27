package com.shopping.services;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopping.entities.User;
import com.shopping.dao.ILoginRepository;


@Service
public class LoginServiceImpl implements ILoginService{
	@Autowired
	private ILoginRepository repository;
	
	@Override
	public User addUser(User user) {
		return repository.save(user);
	}
	
	@Override
	public boolean removeUser(User user) {
		repository.findById(user.getUserId()).orElseThrow(
				() -> new EntityNotFoundException("No user found, check id"));
		repository.deleteById(user.getUserId());
		return true;
		
	}
	
	@Override
	public User validateUser(User user) {
		return repository.save(user);
		//return null;
		
	}
	
	@Override
	public User signOut(User user) {
		return repository.save(user);
		//return null;
	}

}
