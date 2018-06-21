package com.t99sdevelopment.jcli.dummysubpackage.commands;

import com.t99sdevelopment.jcli.dummysubpackage.PrintManager;
import com.t99sdevelopment.jcli.dummysubpackage.InterfaceFactory;
import com.t99sdevelopment.jcli.dummysubpackage.InterfaceManager;
import com.t99sdevelopment.jcli.dummysubpackage.exceptions.InterfaceDoesNotExistException;
import com.t99sdevelopment.jcli.dummysubpackage.util.StandardizedOutputs;
import com.t99sdevelopment.jcli.dummysubpackage.util.HumanReadableOutput;

import java.util.HashSet;
import java.util.Set;

public class InterfaceCommand implements Command {
	
	private final String[] invocationStrings = {"interface"};
	
	@Override
	public void execute(Arguments args) {
		
		if (args.size() == 0) {
			
			StandardizedOutputs.tooFewArgumentsProvided(1, 0);
			return;
			
		}
		
		String arg = args.poll();
		
		switch (arg) {
			
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
			
			default:
				StandardizedOutputs.invalidArgument(arg);
				break;
		}
		
	}
	
	private void switchInterface(Arguments args) {
		
		if (args.size() != 1) {
			
			StandardizedOutputs.incorrectNumberOfArgumentsProvided(1, args.size());
			return;
			
		}
		
		
		
		try {
			
			if (InterfaceManager.getCurrentInterface().equals(InterfaceManager.getInterfaceForName(args.get(0)))) {
				
				PrintManager.printInfo("You're already using the '" + args.get(0) + "' Interface.");
				return;
				
			}
			
			/*
			 * The below three lines need to occur in this order to ensure that if the 'InterfaceDoesNotExistException'
			 * is thrown, it will be thrown before we disconnect the Interface that we're currently inside.
			 */
			
			InterfaceManager.getInterfaceForName(args.get(0));
			InterfaceManager.getCurrentInterface().disconnect();
			InterfaceManager.getInterfaceForName(args.get(0)).connect();
			
		} catch (InterfaceDoesNotExistException e) {
			
			PrintManager.printWarn("An Interface with the name '" + args.get(0) + "' does not exist in the InterfaceManager's registry.");
			
		}
		
	}
	
	private void listInterfaces(Arguments args) {
		
		if (args.size() != 0) StandardizedOutputs.incorrectNumberOfArgumentsProvided(0, args.size());
		
		PrintManager.printInfo("Current registered Interfaces: " + HumanReadableOutput.humanReadableArray(InterfaceManager.getAllRegisteredInterfaces()) + ".");
		
	}
	
	private void renameInterface(Arguments args) {
		
		if (args.size() == 1) {
			
			InterfaceManager.getCurrentInterface().setName(args.get(0));
			
		} else if (args.size() == 2) {
			
			try {
				
				InterfaceManager.getInterfaceForName(args.get(0)).setName(args.get(1));
				
			} catch (InterfaceDoesNotExistException e) {
				
				PrintManager.printWarn("An Interface with the name '" + args.get(0) + "' could not be found in the InterfaceManager's registry.");
				
			}
			
		} else {
			
			StandardizedOutputs.incorrectNumberOfArgumentsProvided(1, args.size());
			
		}
		
	}
	
	private void deleteInterfaces(Arguments args) {
		
		if (args.size() == 0) {
			
			StandardizedOutputs.tooFewArgumentsProvided(1, 0);
			return;
			
		}
		
		Set<String> unfoundInterfaces = new HashSet<>();
		
		for (String i: args.getRemainingArguments()) {
			
			try {
				
				if (InterfaceManager.getInterfaceForName(i).equals(InterfaceManager.getCurrentInterface())) {
					
					PrintManager.printWarn("You cannot delete the Interface you are currently using!");
					continue;
					
				}
				
			} catch (InterfaceDoesNotExistException ignored) {}
			
			if (!InterfaceManager.deregisterInterface(i)) {
				
				unfoundInterfaces.add(i);
				
			}
			
		}
		
		if (unfoundInterfaces.size() > 0) {
			
			StandardizedOutputs.interfaceDoesNotExist(unfoundInterfaces.toArray(new String[0]));
			
		}
		
	}
	
	private void createInterfaces(Arguments args) {
		
		if (args.size() == 0) {
			
			StandardizedOutputs.tooFewArgumentsProvided(1, 0);
			return;
			
		}
		
		Set<String> preexistingInterfaces = new HashSet<>();
		
		for (String i: args.getRemainingArguments()) {
			
			try {
				
				if (InterfaceManager.getInterfaceForName(i) != null) {
					
					preexistingInterfaces.add(i);
					
				}
				
			} catch (InterfaceDoesNotExistException e) {
				
				InterfaceFactory.createInterface(i);
				
			}
			
		}
		
		if (preexistingInterfaces.size() > 0) {
			
			String preexistingInterfacesString = HumanReadableOutput.humanReadableArray(preexistingInterfaces.toArray(new String[0]));
			PrintManager.printWarn("The following Interfaces already exist: " + preexistingInterfacesString + ".");
			
		}
		
	}
	
	@Override
	public String[] getInvocationStrings() {
		
		return invocationStrings;
		
	}
	
}