package com.t99sdevelopment.jcli.dummysubpackage.commands;

import com.t99sdevelopment.jcli.dummysubpackage.ConsoleManager;

public class ExitCommand implements Command {
	
	String[] invocationStrings = {"exit", "quit", "stop"};
	
	@Override
	public void execute(Arguments args) {
		
		ConsoleManager.printInfo("Exiting... goodbye!");
		System.exit(0);
	
	}
	
	@Override
	public String[] getInvocationStrings() {
		
		return invocationStrings;
		
	}
}
