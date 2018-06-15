package com.t99sdevelopment.jcli.dummysubpackage;

import com.t99sdevelopment.jcli.dummysubpackage.commands.Command;
import com.t99sdevelopment.jcli.dummysubpackage.commands.SwitchInterfaceCommand;

import java.util.Map;
import java.util.HashMap;

public class CommandManager {
	
	private static Map<String, Command> commandMap = new HashMap<>();
	
	public static void registerAllCommands() {
		
		registerCommand(new SwitchInterfaceCommand());
		
	}
	
	private static void registerCommand(Command command) {
		
		for (String invocationString: command.getInvocationStrings()) {
			
			commandMap.put(invocationString, command);
			ConsoleManager.printDebug("The CommandManager stored the '" + command.getClass().getSimpleName() + "' with the '" + invocationString + "' invocation string.");
			
		}
		
	}
	
	static boolean invoke(String inputCommand, String[] args) {
		
		if (commandMap.containsKey(inputCommand)) {
			
			commandMap.get(inputCommand).execute(args);
			ConsoleManager.printDebug("The CommandManager successfully invoked the '" + commandMap.get(inputCommand).getClass().getSimpleName() + "' command with the '" + inputCommand + "' invocation string.");
			return true;
			
		} else {
			
			ConsoleManager.printError("A command with the invocation string: '" + inputCommand + "' does not exit.");
			return false;
			
		}
		
	}
	
}
