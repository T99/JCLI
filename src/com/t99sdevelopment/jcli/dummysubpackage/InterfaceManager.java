package com.t99sdevelopment.jcli.dummysubpackage;

import com.t99sdevelopment.jcli.dummysubpackage.exceptions.InterfaceDoesNotExistException;

import java.util.HashMap;
import java.util.Map;

public class InterfaceManager {
	
	private static Interface currentInterface = null;
	private static Map<String, Interface> interfaceMap = new HashMap<>();
	
	public static boolean registerInterface(String name, Interface i) {
		
		if (interfaceMap.containsKey(name)) {
			
			ConsoleManager.printDebug("The InterfaceManager failed to register a new Interface with the name: '" + name + "' due to that name being a duplicate.");
			return false;
			
		}
		else {
			
			interfaceMap.put(name, i);
			ConsoleManager.printDebug("The InterfaceManager successfully registered a new Interface with the name: '" + name + "'.");
			return true;
			
		}
		
	}
	
	public static boolean deregisterInterface(String name) {
		
		if (interfaceMap.containsKey(name)) {
			
			interfaceMap.remove(name);
			ConsoleManager.printDebug("InterfaceManager successfully removed the '" + name + "' Interface from the registry.");
			return true;
			
		} else {
			
			ConsoleManager.printDebug("InterfaceManager failed to removed the '" + name + "' Interface from the registry because it did not exist.");
			return false;
			
		}
		
	}
	
	static boolean updateInterfaceName(String oldName, String newName) {
		
		if (interfaceMap.containsKey(oldName)) {
			
			interfaceMap.put(newName, interfaceMap.get(oldName));
			interfaceMap.remove(oldName);
			ConsoleManager.printDebug("The InterfaceManager renamed the '" + oldName + "' Interface to '" + newName + "'.");
			return true;
			
		} else {
			
			ConsoleManager.printDebug("The InterfaceManager failed to rename an Interface because it could not find an Interface by the name: '" + oldName + "'.");
			return false;
			
		}
		
	}
	
	public static boolean checkInterfaceRegistration(String name) {
		
		return interfaceMap.containsKey(name);
		
	}
	
	public static boolean checkInterfaceRegistration(String name, Interface i) {
		
		return (interfaceMap.containsKey(name) && interfaceMap.get(name).equals(i));
		
	}
	
	public static Interface getCurrentInterface() {
		
		return currentInterface;
		
	}
	
	public static Interface getInterfaceForName(String name) throws InterfaceDoesNotExistException {
		
		if (interfaceMap.containsKey(name)) return interfaceMap.get(name);
		else throw new InterfaceDoesNotExistException("An interface with the name '" + name + "' does not exist in the interface registry.");
		
	}
	
	public static String[] getAllRegisteredInterfaces() {
		
		return interfaceMap.keySet().toArray(new String[0]);
		
	}
	
	static boolean setCurrentInterface(Interface i) {
		
		if (currentInterface != null && currentInterface.equals(i)) { // Just leave this line. This is correct.
			
			ConsoleManager.printDebug("The InterfaceManager failed to update the current Interface because the given '" + i.getName() + "' Interface was already the current Interface.");
			return false;
			
		}
		
		if (currentInterface == null) {
			
			currentInterface = i;
			ConsoleManager.printDebug("The InterfaceManager set the current Interface to '" + i.getName() + "'.");
			return true;
			
		} else if (currentInterface.doesAllowSuggestedYield()) {
			
			currentInterface.suggestYield(); // TODO - I'm not even sure I need this functionality anymore :\
			ConsoleManager.printDebug("The InterfaceManager suggested that the '" + currentInterface.getName() + "' Interface yield to the '" + i.getName() + "' Interface.");
			currentInterface = i;
			ConsoleManager.printDebug("The InterfaceManager set the current Interface to '" + i.getName() + "'.");
			return true;
			
		} else return false;
		
	}
	
	static boolean removeCurrentInterface(Interface i) {
		
		if (currentInterface.equals(i)) {
			
			currentInterface = null;
			ConsoleManager.printDebug("The InterfaceManager removed the '" + i.getName() + "' Interface as the current Interface.");
			return true;
			
		} else {
			
			ConsoleManager.printDebug("The InterfaceManager failed to remove the '" + i.getName() + "' Interface as the current Interface because it was not the current Interface.");
			return false;
			
		}
		
	}
	
	static boolean checkIfCurrentInterface(Interface i) {
		
		return currentInterface.equals(i);
		
	}
	
}