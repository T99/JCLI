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
			
		}
		
	}
	
	static boolean invoke(String inputCommand, String[] args) {
		
		if (commandMap.containsKey(inputCommand)) {
			
			try {
				
				commandMap.get(inputCommand).execute(args);
				
			} catch (Exception e) {
				
				System.out.println("ERROR: " + e.getMessage());
				
			}
			
			return true;
			
		} else return false;
		
	}
	
}
