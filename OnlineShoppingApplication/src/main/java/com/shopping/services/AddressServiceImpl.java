package com.shopping.services;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.shopping.dao.IAddressRepository;
import com.shopping.entities.Address;

import java.util.List;
import javax.persistence.EntityNotFoundException;
@Service
public class AddressServiceImpl implements IAddressService{
	@Autowired
	private IAddressRepository repository;
	
	@Override
	public Address addAddress(Address add) {
		return repository.save(add);
	}
	
	@Override
	public Address updateAddress(Address add) {
		Address address =repository.findById(add.getAddressId()).orElseThrow(
				() -> new EntityNotFoundException("No address found by the id"));
		address.setAddressId(add.getAddressId());
		address.setBuildingName(add.getBuildingName());
		address.setCity(add.getCity());
		address.setCountry(add.getCountry());
		address.setPincode(add.getPincode());
		address.setState(add.getState());
		address.setStreetNo(add.getStreetNo());
		return repository.save(address);
	}
	
	@Override
	public boolean removeAddressByaddressId(int addressId) {
		repository.findById(addressId).orElseThrow(
				() -> new EntityNotFoundException("No address found, check id"));
		repository.deleteById(addressId);
		return true;
		
	}
	
	@Override
	public List<Address> viewAllAddress() {
		return (List<Address>)repository.findAll();
	}
	
	@Override
	public Address viewAddressByaddressId(int addressId) {
		return repository.findById(addressId).get();
	}
	

}
