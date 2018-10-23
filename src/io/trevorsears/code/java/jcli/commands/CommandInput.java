/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 10:47 PM -- August 31st, 2018.
 * Classpath: io.trevorsears.code.java.jcli.commands.CommandInput
 */

package io.trevorsears.code.java.jcli.commands;

import java.util.ArrayList;
import java.util.HashMap;

public class CommandInput {
	
	private ArrayList<String> generalInput;
	private HashMap<Flag, String> flagMap;
	
	public CommandInput(String... generalInput) {
		
		this.generalInput = new ArrayList<>();
		for (String string: generalInput) this.generalInput.add(string);
		this.flagMap = new HashMap<>();
		
	}
	
	public void addGeneralInput(String string) {
		
		generalInput.add(string);
		
	}
	
	public String[] getGeneralInput() {
		
		return generalInput.toArray(new String[0]);
		
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
		
		for (int index = 0; index < generalInput.size(); index++) {
			
			stringBuilder.append(generalInput.get(index));
			
			if (index < generalInput.size() - 1) stringBuilder.append(", ");
			
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