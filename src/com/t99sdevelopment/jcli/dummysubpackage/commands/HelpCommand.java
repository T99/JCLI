package com.t99sdevelopment.jcli.dummysubpackage.commands;

import com.t99sdevelopment.jcli.dummysubpackage.CommandManager;
import com.t99sdevelopment.jcli.dummysubpackage.PrintManager;
import com.t99sdevelopment.jcli.dummysubpackage.util.HumanReadableOutput;

public class HelpCommand implements Command {
	
	String[] invocationStrings = {"help", "?"};
	
	@Override
	public void execute(Arguments args) {
	
		if (args.size() == 0) listCommands(args);
	
	}
	
	private void listCommands(Arguments args) {
		
		PrintManager.printInfo("Current registered commands: " + HumanReadableOutput.humanReadableArray(CommandManager.getAllCommands()) + ".");
	
	}
	
	@Override
	public String[] getInvocationStrings() {
		
		return invocationStrings;
		
	}
	
}