package com.t99sdevelopment.jcli.dummysubpackage.util;

public class HumanReadableOutput {
	
	public static String humanReadableArray(Object[] objects) {
	
		StringBuilder hrArray = new StringBuilder();
		String delimiter = ", ";
		
		for (Object object: objects) {
			
			hrArray.append(object.toString());
			hrArray.append(delimiter);
			
		}
		
		return hrArray.toString().substring(0, hrArray.length() - delimiter.length());
	
	}
	
}
