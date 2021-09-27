package com.shopping.services;

import com.shopping.entities.User;

public interface ILoginService {
	public User addUser(User user);
	public boolean removeUser(User user);
	public User validateUser(User user);
	public User signOut(User user);
	
}
