/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 10:47 PM -- August 31st, 2018.
 * Classpath: io.trevorsears.code.java.jcli.commands.CommandInput
 */

package io.trevorsears.code.java.jcli.commands;

import java.util.HashMap;

public class CommandInput {
	
	private final String[] generalInput;
	private HashMap<Flag, String> flagMap;
	
	public CommandInput(String[] generalInput) {
		
		this.generalInput = generalInput;
		this.flagMap = new HashMap<>();
		
	}
	
	public String[] getGeneralInput() {
		
		return generalInput;
		
	}
	
	public void addFlag(Flag flag, String string) {
		
		flagMap.put(flag, string);
		
	}
	
	public String getFlag(Flag flag) {
		
		return flagMap.get(flag);
		
	}
	
	@Override
	public String toString() {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("General input:\t[");
		
		for (int index = 0; index < generalInput.length; index++) {
			
			stringBuilder.append(generalInput[index]);
			
			if (index < generalInput.length - 1) stringBuilder.append(", ");
			
		}
		
		stringBuilder.append("]");
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("Flags:");
		stringBuilder.append(System.lineSeparator());
		
		for (Flag flag: flagMap.keySet()) {
			
			stringBuilder.append("\t");
			stringBuilder.append(flag.getSimpleFlag());
			stringBuilder.append("\t");
			stringBuilder.append(flagMap.get(flag));
			stringBuilder.append(System.lineSeparator());
			
		}
		
		return stringBuilder.toString();
		
	}
	
}