package com.t99sdevelopment.jcli.dummysubpackage.util;

import com.t99sdevelopment.jcli.dummysubpackage.commands.Command;
import com.t99sdevelopment.jcli.dummysubpackage.exceptions.CommandDoesNotExistException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MultiKeyCommandBiMap {
	
	Map<ArrayList<String>, Command> stringToCommandMap = new HashMap<>();
	Map<Command, ArrayList<String>> commandToStringMap = new HashMap<>();
	
	public boolean addCommand(Command command, String... invocationStrings) {
		
		if (isDuplicate(command) || containsDuplicate(invocationStrings)) return false;
		
		stringToCommandMap.put(new ArrayList<>(Arrays.asList(invocationStrings)), command);
		commandToStringMap.put(command, new ArrayList<>(Arrays.asList(invocationStrings)));
		
		return true;
		
	}
	
	public String getPriorityInvocationString(Command command) throws CommandDoesNotExistException {
		
		return getInvocationStrings(command)[0];
		
	}
	
	public String getPriorityInvocationString(String invocationString) throws CommandDoesNotExistException {
		
		return getInvocationStrings(invocationString)[0];
		
	}
	
	public String[] getAllPriorityInvocationStrings() {
		
		ArrayList<String> priorityInvocationStrings = new ArrayList<>();
		
		for (ArrayList<String> invocationStringList: stringToCommandMap.keySet()) {
			
			priorityInvocationStrings.add(invocationStringList.get(0));
			
		}
		
		return priorityInvocationStrings.toArray(new String[0]);
		
	}
	
	public String[] getInvocationStrings(Command command) throws CommandDoesNotExistException {
		
		try {
			
			return commandToStringMap.get(command).toArray(new String[0]);
			
		} catch (NullPointerException e) {
			
			throw new CommandDoesNotExistException();
			
		}
		
	}
	
	public String[] getInvocationStrings(String invocationString) throws CommandDoesNotExistException {
		
		for (ArrayList<String> invocationStrings: stringToCommandMap.keySet()) {
		
			if (invocationStrings.contains(invocationString)) {
				
				return invocationStrings.toArray(new String[0]);
				
			}
		
		}
		
		throw new CommandDoesNotExistException();
		
	}
	
	public Command getCommand(String invocationString) throws CommandDoesNotExistException {
		
		for (ArrayList<String> invocationStringList: stringToCommandMap.keySet()) {
			
			if (invocationStringList.contains(invocationString)) {
				
				return stringToCommandMap.get(invocationStringList);
				
			}
			
		}
		
		throw new CommandDoesNotExistException();
		
	}
	
	private boolean isDuplicate(Command command) {
		
		for (Command cmd: commandToStringMap.keySet()) {
			
			if (cmd.equals(command)) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	private boolean containsDuplicate(String... invocationStrings) {
		
		for (String invocationString: invocationStrings) {
			
			for (ArrayList<String> invocationStringList: stringToCommandMap.keySet()) {
				
				if (invocationStringList.contains(invocationString)) {
					
					return true;
					
				}
				
			}
			
		}
		
		return false;
		
	}
	
}