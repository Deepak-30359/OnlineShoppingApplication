package com.shopping;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.shopping.dao.IAddressRepository;
import com.shopping.entities.Address;
import com.shopping.services.AddressServiceImpl;

@ExtendWith(MockitoExtension.class)
 class IAddressServiceTest {
	@Mock
	private IAddressRepository addressRepository;
	@InjectMocks
	private AddressServiceImpl addressService;
	
	@Test
	void getAllAddressTest() {
		List<Address> list = new ArrayList<Address>();
		Address address1 = new Address(1, "456b", "xyz234", "Seoul", "HanRiver", "Korea", "515372");
		Address address2 = new Address(2, "123a", "abc123", "Hyderabad", "Telangana", "India", "517506");
		Address address3 = new Address(3, "982c", "sun12", "Chennai", "TamilNadu", "India", "578542");
		list.add(address1);
		list.add(address2);
		list.add(address3);
		
		when(addressRepository.findAll()).thenReturn(list);
		List<Address> addressList = addressService.viewAllAddress();
		assertEquals(3, addressList.size());
		
	}
	
	//add address
	@Test
	void saveAddressTest() {
		Address address = new Address(1, "456b", "xyz234", "Seoul", "HanRiver", "Korea", "515372");
		when(addressRepository.save(address)).thenReturn(address);
		Address savedAddress = addressService.addAddress(address);
		assertThat(savedAddress).isNotNull();
		assertEquals("Seoul",savedAddress.getCity());
	}
	

}
