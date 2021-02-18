package com.friday.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.friday.AddressRequest;
import com.friday.rest.JSONService;

public class JSONServiceTest {
	
	AddressRequest addressRequest = new AddressRequest();		
	
	JSONService jsonService = new JSONService();
	
	String street = "";
	String houseNumber = "";

	@Test
	public void address1TestPass() {
		
		addressRequest.setAddress("WinterAllee 3");
		street = jsonService.createAddressInJSON(addressRequest).getStreet();
		houseNumber = jsonService.createAddressInJSON(addressRequest).getHouseNumber();
		
		assertEquals("Address 1 pass", "WinterAllee", street);
		assertEquals("Address 1 pass", "3", houseNumber);
	}
	
	@Test
	public void address2TestPass() {
		
		addressRequest.setAddress("Musterstrasse 45");
		street = jsonService.createAddressInJSON(addressRequest).getStreet();
		houseNumber = jsonService.createAddressInJSON(addressRequest).getHouseNumber();
		
		assertEquals("Address 1 pass", "Musterstrasse", street);
		assertEquals("Address 1 pass", "45", houseNumber);
	}
	
	@Test
	public void address3TestPass() {
		
		addressRequest.setAddress("Blaufeldweg 123B");
		street = jsonService.createAddressInJSON(addressRequest).getStreet();
		houseNumber = jsonService.createAddressInJSON(addressRequest).getHouseNumber();
		
		assertEquals("Address 1 pass", "Blaufeldweg", street);
		assertEquals("Address 1 pass", "123B", houseNumber);
	}

	@Test
	public void address4TestPass() {
		
		addressRequest.setAddress("Am Bächle 23");
		street = jsonService.createAddressInJSON(addressRequest).getStreet();
		houseNumber = jsonService.createAddressInJSON(addressRequest).getHouseNumber();
		
		assertEquals("Address 1 pass", "Am Bächle", street);
		assertEquals("Address 1 pass", "23", houseNumber);
	}
	
	@Test
	public void address5TestPass() {
		
		addressRequest.setAddress("Auf der Vogelwiese 23 b");
		street = jsonService.createAddressInJSON(addressRequest).getStreet();
		houseNumber = jsonService.createAddressInJSON(addressRequest).getHouseNumber();
		
		assertEquals("Address 1 pass", "Auf der Vogelwiese", street);
		assertEquals("Address 1 pass", "23 b", houseNumber);
	}
	
	@Test
	public void address6TestPass() {
		
		addressRequest.setAddress("4, rue de la revolution");
		street = jsonService.createAddressInJSON(addressRequest).getStreet();
		houseNumber = jsonService.createAddressInJSON(addressRequest).getHouseNumber();
		
		assertEquals("Address 1 pass", "rue de la revolution", street);
		assertEquals("Address 1 pass", "4", houseNumber);
	}
	
	@Test
	public void address7TestPass() {
		
		addressRequest.setAddress("200 Broadway Av");
		street = jsonService.createAddressInJSON(addressRequest).getStreet();
		houseNumber = jsonService.createAddressInJSON(addressRequest).getHouseNumber();
		
		assertEquals("Address 1 pass", "Broadway Av", street);
		assertEquals("Address 1 pass", "200", houseNumber);
	}
	
	@Test
	public void address8TestPass() {
		
		addressRequest.setAddress("Calle Aduana, 29");
		street = jsonService.createAddressInJSON(addressRequest).getStreet();
		houseNumber = jsonService.createAddressInJSON(addressRequest).getHouseNumber();
		
		assertEquals("Address 1 pass", "Calle Aduana", street);
		assertEquals("Address 1 pass", "29", houseNumber);
	}
	
	@Test
	public void address9TestPass() {
		
		addressRequest.setAddress("Calle 39 No 1540");
		street = jsonService.createAddressInJSON(addressRequest).getStreet();
		houseNumber = jsonService.createAddressInJSON(addressRequest).getHouseNumber();
		
		assertEquals("Address 1 pass", "Calle 39", street);
		assertEquals("Address 1 pass", "No 1540", houseNumber);
	}

}
