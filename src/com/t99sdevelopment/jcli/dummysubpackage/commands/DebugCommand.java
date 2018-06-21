package com.t99sdevelopment.jcli.dummysubpackage.commands;

import com.t99sdevelopment.jcli.dummysubpackage.PrintManager;
import com.t99sdevelopment.jcli.dummysubpackage.util.StandardizedOutputs;

public class DebugCommand implements Command {
	
	String[] invocationStrings = {"debug"};
	
	@Override
	public void execute(Arguments args) {
		
		if (args.size() == 0) {
			
			PrintManager.toggleDebug();
			return;
			
		}
		
		String arg = args.poll();
		
		switch (arg) {
			
			case "toggle":
				PrintManager.toggleDebug();
				break;
				
			case "on":
				PrintManager.setDebug(true);
				break;
				
			case "off":
				PrintManager.setDebug(false);
				break;
				
			default:
				StandardizedOutputs.invalidArgument(arg);
				break;
			
		}
		
	}
	
	@Override
	public String[] getInvocationStrings() {
		
		return invocationStrings;
		
	}
}
