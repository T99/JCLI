package com.t99sdevelopment.jcli.dummysubpackage;

import com.t99sdevelopment.jcli.dummysubpackage.commands.Arguments;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandInterpreter {
	
	static boolean interpret(String inputString) {
		
		String[] input = groupDelimitedStrings(normalize(inputString));
		String command = input[0];
		Arguments args = new Arguments(Arrays.copyOfRange(input, 1, input.length));
		
		ConsoleManager.printDebug("The CommandInterpreter received the raw input: '" + inputString + "'.");
		ConsoleManager.printDebug("The CommandInterpreter derived the command as: '" + command + "'.");
		// TODO - Add args to debug?
		
		return CommandManager.invoke(command, args);
		
	}
	
	public static String[] normalize(String input) {
		
		ArrayList<String> substrings = new ArrayList<>();
		
		input = input.trim();
		
		int beginningDelimeter = 0;
		
		for (int i = 1; i < input.length(); i++) {
			
			char currentChar = input.substring(i, i + 1).charAt(0);
			
			if (currentChar == ' ') {
				
				substrings.add(input.substring(beginningDelimeter, i));
				
				if (input.length() - 1 != i) beginningDelimeter = i + 1;
				
			} else if (i == input.length() - 1) substrings.add(input.substring(beginningDelimeter, i + 1));
			
		}
		
		return substrings.toArray(new String[0]);
		
	}
	
	public static String[] groupDelimitedStrings(String[] input) {
		
		ArrayList<String> strings = new ArrayList<>();
		ArrayList<String> validDelimiters = new ArrayList<>(Arrays.asList("\"", "'", "`"));
		
		int beginningDelimitedString = 0;
		boolean delimitedMode = false;
		String delimiter = null;
		
		for (int i = 0; i < input.length; i++) {
			
			if (input[i].length() >= 2) {
				
				if (!delimitedMode) {
					
					String firstCharacter = input[i].substring(0, 1);
					
					if (validDelimiters.contains(firstCharacter)) {
						
						beginningDelimitedString = i;
						delimitedMode = true;
						delimiter = firstCharacter;
						i--;
						
					} else {
						
						strings.add(input[i]);
						
					}
					
				} else {
					
					if (input[i].substring(input[i].length() - 1, input[i].length()).equals(delimiter)) {
						
						StringBuilder delimitedString = new StringBuilder();
						
						for (int k = beginningDelimitedString; k <= i; k++) {
							
							delimitedString.append(input[k]);
							if (k != i) delimitedString.append(" ");
							
						}
						
						strings.add(delimitedString.toString().substring(1, delimitedString.length() - 1));
						
						delimitedMode = false;
						delimiter = null;
						
					}
					
				}
				
			}
			
		}
		
		return strings.toArray(new String[0]);
		
	}
	
}