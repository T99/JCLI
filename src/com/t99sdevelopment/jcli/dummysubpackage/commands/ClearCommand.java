package com.t99sdevelopment.jcli.dummysubpackage.commands;

import com.t99sdevelopment.jcli.dummysubpackage.PrintManager;
import com.t99sdevelopment.jcli.dummysubpackage.util.EnvironmentHelper;
import com.t99sdevelopment.jcli.dummysubpackage.util.StandardizedOutputs;

public class ClearCommand implements Command {
	
	String[] invocationStrings = {"clear"};
	
	@Override
	public void execute(Arguments args) {
		
		if (args.size() != 0) {
			
			StandardizedOutputs.incorrectNumberOfArgumentsProvided(0, args.size());
			return;
			
		}
		
		if (EnvironmentHelper.isRunningInIntelliJ()) PrintManager.printError("Cannot clear the screen within IntelliJ.");
		else {
			
			switch (EnvironmentHelper.getEnvironment()) {
				
				case WINDOWS:
					PrintManager.printWarn("Screen clearing support has not yet been added for Windows.");
					break;
					
				case LINUX: case MAC: case SOLARIS:
					System.out.print("\033[H\033[2J");
					System.out.flush();
					break;
				
			}
			
		}
		
	}
	
	@Override
	public String[] getInvocationStrings() {
		
		return invocationStrings;
	}
	
}