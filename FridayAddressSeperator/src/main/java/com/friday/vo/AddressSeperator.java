package com.friday.vo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.apache.log4j.Logger;

import com.friday.AddressResponse;


public class AddressSeperator {
	
	private static Logger logger = Logger.getLogger(AddressSeperator.class);
	

	public static AddressResponse seperateAddress(String addressLine) {
		
		logger.info("Started executing Class: AddressSeperator Method:seperateAddress()\n");
		
		AddressResponse addressResponse = new AddressResponse();
		
		StringTokenizer addressDelimiter = new StringTokenizer(addressLine, ", .");
		
		ArrayList<String> streetList = new ArrayList<String>();
		ArrayList<String> houseNoList = new ArrayList<String>();
		
		while(addressDelimiter.hasMoreTokens()) {
			
			String currentToken = addressDelimiter.nextToken();
			
			char tokenFirstChar = currentToken.charAt(0);

			if(isNumber(tokenFirstChar) || currentToken.equalsIgnoreCase("No") || currentToken.length() == 1) {
				houseNoList.add(currentToken);
			}else {
				streetList.add(currentToken);
			}
			
		}
		logger.info("Class: AddressSeperator Method:seperateAddress()\nHouse Number List: " + houseNoList +"\nStreet List: " +streetList);
		
		addressResponse = buildJSONObject(houseNoList, streetList);
		return addressResponse;
	}

	private static AddressResponse buildJSONObject(ArrayList<String> houseNoList, ArrayList<String> streetList) {
		
		String streetName = "";
		String houseNumber = "";
		String numberIdentifier = "";
		boolean numberFound = false;
		AddressResponse addressResponse = new AddressResponse();
		
		logger.info("Started executing Class: AddressSeperator Method:buildJSONObject()\n");
		
		Iterator<String> houseNoIterator = houseNoList.iterator();
		while(houseNoIterator.hasNext()) {
			
			if(houseNoList.size() == 1 || numberFound)
			houseNumber += houseNoIterator.next() + " ";
			else {
				numberFound = true;
				
				numberIdentifier = houseNoIterator.next();
				
				if(isNumber(numberIdentifier.charAt(0)) && houseNoList.get(1).length() == 1) {
					houseNumber += numberIdentifier + " ";
				}
			}
			
		}
		if(!"".equals(numberIdentifier) && houseNoList.get(1).length() != 1)
		{
			streetList.add(numberIdentifier);
		}
		Iterator<String> streetNameIterator = streetList.iterator();
		while(streetNameIterator.hasNext()) {
			streetName += streetNameIterator.next() + " ";
		}
		
		logger.info("Class: AddressSeperator Method:buildJSONObject()\n houseNumber: " +houseNumber + "\nStreet Name:" +streetName);
		
		addressResponse.setHouseNumber(houseNumber.trim());
		addressResponse.setStreet(streetName.trim());
		return addressResponse;
				
	}
	

	private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

}

