package com.t99sdevelopment.jcli.dummysubpackage;

import com.t99sdevelopment.jcli.dummysubpackage.commands.*;
import com.t99sdevelopment.jcli.dummysubpackage.exceptions.CommandDoesNotExistException;
import com.t99sdevelopment.jcli.dummysubpackage.util.MultiKeyCommandBiMap;
import com.t99sdevelopment.jcli.dummysubpackage.util.StandardizedOutputs;

public class CommandManager {
	
	private static MultiKeyCommandBiMap commandMap = new MultiKeyCommandBiMap();
	
	public static void registerAllCommands() {
		
		registerCommand(new ClearCommand());
		registerCommand(new DebugCommand());
		registerCommand(new ExitCommand());
		registerCommand(new HelpCommand());
		registerCommand(new InterfaceCommand());
		
	}
	
	private static void registerCommand(Command command) {
		
		commandMap.addCommand(command, command.getInvocationStrings());
		
		try {
			
			PrintManager.printDebug("The CommandManager stored the '" + command.getClass().getSimpleName() + "' with the '" + commandMap.getPriorityInvocationString(command) + "' invocation string.");
			
		} catch (CommandDoesNotExistException e) {
			
			PrintManager.printError("This should be impossible -- the command should have been successfully added on the previous line.");
			
		}
		
	}
	
	public static String[] getAllCommands() {
		
		return commandMap.getAllPriorityInvocationStrings();
		
	}
	
	static boolean invoke(String inputCommand, Arguments args) {
		
		try {
			
			Command command = commandMap.getCommand(inputCommand);
			
			command.execute(args);
			PrintManager.printDebug("The CommandManager successfully invoked the '" + command.getClass().getSimpleName() + "' command with the '" + inputCommand + "' invocation string.");
			return true;
			
		} catch (CommandDoesNotExistException e) {
			
			StandardizedOutputs.commandDoesNotExist(inputCommand);
			return false;
			
		}
		
	}
	
}
