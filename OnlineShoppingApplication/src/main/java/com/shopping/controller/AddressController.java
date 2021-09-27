package com.shopping.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.net.URI;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.shopping.entities.Address;
import com.shopping.services.AddressServiceImpl;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	AddressServiceImpl addressService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Address> addAddress(@Valid @RequestBody Address add){
		Address add1 = addressService.addAddress(add);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{addressid}")
				.buildAndExpand(add1.getAddressId())
				.toUri();
		return ResponseEntity.created(location).body(add1);
	}
	
	@PutMapping
	public Address updateAddress(@RequestBody Address add) {
		return addressService.updateAddress(add);
	}
	
	@DeleteMapping("/{addressid}")
	public ResponseEntity<String> removeAddressByaddressId(@PathVariable int addressId){
		boolean flag = addressService.removeAddressByaddressId(addressId);
		if(flag)
			return new ResponseEntity<>("address removed successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("address not removed successfully", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping
	public List<Address> viewAllAddress(){
		return addressService.viewAllAddress();
	}
	
	@GetMapping("/{addressid}")
	public Address viewAddressByaddressId(@RequestParam int addressId) {
		System.out.println(addressId);
		return addressService.viewAddressByaddressId(addressId);
	}
	
	

}
