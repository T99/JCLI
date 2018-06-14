package com.t99sdevelopment.jcli.dummysubpackage.commands;

public interface Command {
	
	void execute(String[] args);
	
	String[] getInvocationStrings();
	
}