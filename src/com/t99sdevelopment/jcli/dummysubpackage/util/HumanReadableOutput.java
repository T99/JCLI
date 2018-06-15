package com.t99sdevelopment.jcli.dummysubpackage.util;

public class HumanReadableOutput {
	
	public static String humanReadableArray(Object[] objects) {
	
		StringBuilder hrArray = new StringBuilder();
		
		for (Object object: objects) {
			
			hrArray.append(object.toString());
			hrArray.append(", ");
			
		}
		
		return hrArray.toString().substring(0, hrArray.length() - 2);
	
	}
	
}
