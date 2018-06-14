package com.t99sdevelopment.jcli.dummysubpackage;

import java.util.HashMap;
import java.util.Map;

public class InterfaceManager {
	
	private static Interface currentInterface = null;
	private static Map<String, Interface> interfaceMap = new HashMap<>();
	
	static boolean registerNewInterface(String name, Interface i) {
		
		if (interfaceMap.containsKey(name)) return false;
		else {
			
			interfaceMap.put(name, i);
			return true;
			
		}
		
	}
	
	static boolean updateInterfaceName(String oldName, String newName) {
		
		if (interfaceMap.containsKey(oldName)) {
			
			interfaceMap.put(newName, interfaceMap.get(oldName));
			interfaceMap.remove(oldName);
			return true;
			
		} else return false;
		
	}
	
	static boolean checkInterfaceRegistration(String name) {
		
		return interfaceMap.containsKey(name);
		
	}
	
	static boolean checkInterfaceRegistration(String name, Interface i) {
		
		return (interfaceMap.containsKey(name) && interfaceMap.get(name).equals(i));
		
	}
	
	public static Interface getCurrentInterface() {
		
		return currentInterface;
		
	}
	
	public static Interface getInterfaceForName(String name) throws IllegalArgumentException {
		
		if (interfaceMap.containsKey(name)) return interfaceMap.get(name);
		else throw new IllegalArgumentException("An interface with the name '" + name + "' does not exist in the interface registry.");
		
	}
	
	static boolean setCurrentInterface(Interface i) {
		
		if (currentInterface != null && currentInterface.equals(i)) return false;
		else {
			
			if (currentInterface == null) {
				
				currentInterface = i;
				return true;
				
			} else if (currentInterface.doesAllowSuggestedYield()) {
				
				currentInterface.suggestYield();
				currentInterface = i;
				return true;
				
			} else return false;
			
		}
		
	}
	
	static boolean removeCurrentInterface(Interface i) {
		
		if (currentInterface.equals(i)) {
			
			currentInterface = null;
			return true;
			
		} else return false;
		
	}
	
	static boolean checkIfCurrentInterface(Interface i) {
		
		return currentInterface.equals(i);
		
	}
	
}