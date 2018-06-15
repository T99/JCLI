package com.t99sdevelopment.jcli.dummysubpackage.commands;

public class ExitCommand implements Command {
	
	String[] invocationStrings = {"exit", "quit", "stop"};
	
	@Override
	public void execute(String[] args) {
	
	
	
	}
	
	@Override
	public String[] getInvocationStrings() {
		
		return invocationStrings;
		
	}
}
