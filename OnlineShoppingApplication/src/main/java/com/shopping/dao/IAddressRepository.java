package com.shopping.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.shopping.entities.Address;
public interface IAddressRepository extends JpaRepository<Address,Integer>{
	

}
