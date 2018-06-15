package com.t99sdevelopment.jcli.dummysubpackage.commands;

import com.t99sdevelopment.jcli.dummysubpackage.ConsoleManager;
import com.t99sdevelopment.jcli.dummysubpackage.InterfaceFactory;
import com.t99sdevelopment.jcli.dummysubpackage.InterfaceManager;
import com.t99sdevelopment.jcli.dummysubpackage.exceptions.InterfaceDoesNotExistException;
import com.t99sdevelopment.jcli.dummysubpackage.util.HumanReadableOutput;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class InterfaceCommand implements Command {
	
	private final String[] invocationStrings = {"interface"};
	
	@Override
	public void execute(Arguments args) {
		
		String secondaryCommand = args.poll();
		
		switch (secondaryCommand) {
			
			case "switch":
				switchInterface(args);
				break;
				
			case "list":
				listInterfaces(args);
				break;
				
			case "rename":
				renameInterface(args);
				break;
				
			case "delete":
				deleteInterfaces(args);
				break;
				
			case "create":
				createInterfaces(args);
				break;
			
		}
		
	}
	
	private void switchInterface(Arguments args) {
		
		if (args.size() != 1) ConsoleManager.printError(args.size() + " args were passed, rather than 1.");
		
		try {
			
			/*
			 * The below three lines need to occur in this order to ensure that if the 'InterfaceDoesNotExistException'
			 * is thrown, it will be thrown before we disconnect the Interface that we're currently inside.
			 */
			
			InterfaceManager.getInterfaceForName(args.get(0));
			InterfaceManager.getCurrentInterface().disconnect();
			InterfaceManager.getInterfaceForName(args.get(0)).connect();
			
		} catch (InterfaceDoesNotExistException e) {
			
			ConsoleManager.printError("An Interface with the name '" + args.get(0) + "' does not exist in the InterfaceManager's registry.");
			
		}
		
	}
	
	private void listInterfaces(Arguments args) {
		
		if (args.size() != 0) ConsoleManager.printWarn("The 'interface list' command takes no further arguments. Extra arguments ignored.");
		
		ConsoleManager.printInfo("Current registered Interfaces: " + HumanReadableOutput.humanReadableArray(InterfaceManager.getAllRegisteredInterfaces()) + ".");
		
	}
	
	private void renameInterface(Arguments args) {
		
		if (args.size() == 1) {
			
			InterfaceManager.getCurrentInterface().setName(args.get(0));
			
		} else if (args.size() == 2) {
			
			try {
				
				InterfaceManager.getInterfaceForName(args.get(0)).setName(args.get(1));
				
			} catch (InterfaceDoesNotExistException e) {
				
				ConsoleManager.printError("An Interface with the name '" + args.get(0) + "' could not be found in the InterfaceManager's registry.");
				
			}
			
		} else {
			
			ConsoleManager.printError(args.size() + " args were passed, rather than 1.");
			
		}
		
	}
	
	private void deleteInterfaces(Arguments args) {
		
		Set<String> unfoundInterfaces = new HashSet<>();
		
		for (String i: args.getRemainingArguments()) {
			
			try {
				
				if (InterfaceManager.getInterfaceForName(i).equals(InterfaceManager.getCurrentInterface())) {
					
					ConsoleManager.printWarn("You cannot delete the Interface you are currently using!");
					continue;
					
				}
				
			} catch (InterfaceDoesNotExistException e) {
				
				ConsoleManager.printError("This should not be possible...");
				e.printStackTrace();
				
			}
			
			if (!InterfaceManager.deregisterInterface(i)) {
				
				unfoundInterfaces.add(i);
				
			}
			
		}
		
		if (unfoundInterfaces.size() > 0) {
			
			String unfoundInterfacesString = HumanReadableOutput.humanReadableArray(unfoundInterfaces.toArray(new String[0]));
			ConsoleManager.printError("Could not find the following Interfaces to delete them: " + unfoundInterfacesString + ".");
			
		}
		
	}
	
	private void createInterfaces(Arguments args) {
		
		Set<String> preexistingInterfaces = new HashSet<>();
		
		for (String i: args.getRemainingArguments()) {
			
			try {
				
				if (InterfaceManager.getInterfaceForName(i) != null) {
					
					preexistingInterfaces.add(i);
					continue;
					
				}
				
			} catch (InterfaceDoesNotExistException e) {
				
				InterfaceFactory.getInterface(i);
				
			}
			
		}
		
		if (preexistingInterfaces.size() > 0) {
			
			String preexistingInterfacesString = HumanReadableOutput.humanReadableArray(preexistingInterfaces.toArray(new String[0]));
			ConsoleManager.printError("The following Interfaces already exist: " + preexistingInterfacesString + ".");
			
		}
		
	}
	
	@Override
	public String[] getInvocationStrings() {
		
		return invocationStrings;
		
	}
	
}