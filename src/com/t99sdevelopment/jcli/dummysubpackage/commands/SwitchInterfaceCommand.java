package com.t99sdevelopment.jcli.dummysubpackage.commands;

import com.t99sdevelopment.jcli.dummysubpackage.ConsoleManager;
import com.t99sdevelopment.jcli.dummysubpackage.InterfaceManager;
import com.t99sdevelopment.jcli.dummysubpackage.exceptions.InterfaceDoesNotExistException;

public class SwitchInterfaceCommand implements Command {
	
	private final String[] invocationStrings = {"switchinterface"};
	
	@Override
	public void execute(String[] args) {
		
		if (args.length != 1) ConsoleManager.printWarn(args.length + " arguments were passed, rather than 1.");
		
		try {
			
			/*
			 * The below three lines need to occur in this order to ensure that if the 'InterfaceDoesNotExistException'
			 * is thrown, it will be thrown before we disconnect the Interface that we're currently inside.
			 */
			
			InterfaceManager.getInterfaceForName(args[0]);
			InterfaceManager.getCurrentInterface().disconnect();
			InterfaceManager.getInterfaceForName(args[0]).connect();
			
		} catch (InterfaceDoesNotExistException e) {
			
			ConsoleManager.printError("An Interface with the name '" + args[0] + "' does not exist in the InterfaceManager's registry.");
			
		}
		
	}
	
	@Override
	public String[] getInvocationStrings() {
		
		return invocationStrings;
		
	}
	
}