package com.friday.rest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.friday.Address;
import com.friday.AddressRequest;
import com.friday.AddressResponse;
import com.friday.vo.AddressSeperator;

@Path("/address/parser")
public class JSONService {
	
	private Logger logger = Logger.getLogger(JSONService.class);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Address getAddressInJSON() {

		logger.info("Executing Class: JSONService Method: getAddressInJSON \n");
		
		Address address = new Address();
		address.setAddressLine("Friday Address Seperator");

		return address;

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AddressResponse createAddressInJSON(AddressRequest address) {

		
		AddressResponse addressResponse = new AddressResponse();
		
		logger.info("Class: JSONService Method: createAddressInJSON \nBefore calling AddressSeperator.seperateAddress() method");
		
		try {
			addressResponse = AddressSeperator.seperateAddress(address.getAddress());
		
		logger.info("Class: JSONService Method: createAddressInJSON \nAddressSeperator.seperateAddress() method execution completed");
		
		addressResponse.setStatus("Success");
		
		}catch(Exception e) {
		
			addressResponse.setStatus("Failure");
			addressResponse.setErrorMessage(e.getMessage());		
			logger.error("\nException in Class: JSONService Method: createAddressInJSON\nException Message: " + e.getMessage());
			
		}
		
		logger.info("Class: JSONService Method: createAddressInJSON \nStreet Name: " + addressResponse.getStreet()+ "\nHouse Number:  " + addressResponse.getHouseNumber());
		
		return addressResponse;
		
	}
}
