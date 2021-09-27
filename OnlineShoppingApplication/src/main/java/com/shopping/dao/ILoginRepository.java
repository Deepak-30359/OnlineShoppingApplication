package com.shopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shopping.entities.User;

public interface ILoginRepository extends JpaRepository<User,Integer>{

}
