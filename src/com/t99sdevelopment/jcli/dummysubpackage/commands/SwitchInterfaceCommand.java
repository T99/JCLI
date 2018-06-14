package com.t99sdevelopment.jcli.dummysubpackage.commands;

import com.t99sdevelopment.jcli.dummysubpackage.InterfaceManager;

public class SwitchInterfaceCommand implements Command {
	
	private final String[] invocationStrings = {"switchinterface"};
	
	@Override
	public void execute(String[] args) throws IllegalArgumentException {
		
		if (args.length != 1) throw new IllegalArgumentException(args.length + " arguments were passed, rather than 1.");
		
		InterfaceManager.getCurrentInterface().disconnect();
		
		try {
			
			InterfaceManager.getInterfaceForName(args[0]).connect();
			
		} catch (IllegalArgumentException e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	@Override
	public String[] getInvocationStrings() {
		
		return invocationStrings;
		
	}
	
}