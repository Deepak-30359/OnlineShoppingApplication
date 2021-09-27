package com.shopping.services;

import java.util.List;
import com.shopping.entities.Address;

public interface IAddressService {
	public Address addAddress(Address add);
	public Address updateAddress(Address add);
	public boolean removeAddressByaddressId(int addressId);
	public List<Address> viewAllAddress();
	public Address viewAddressByaddressId(int addressId);

}
