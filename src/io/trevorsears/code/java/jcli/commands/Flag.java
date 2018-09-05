/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 10:47 PM -- August 31st, 2018.
 * Classpath: io.trevorsears.code.java.jcli.commands.Flag
 */

package io.trevorsears.code.java.jcli.commands;

public class Flag implements Helpable {
	
	private final Character character;
	private final String extendedName;
	private final String helpText;
	
	public Flag(Character character, String extendedName, String helpText) {
		
		this.character = character;
		this.extendedName = formatExtendedName(extendedName);
		this.helpText = helpText;
		
	}
	
	private static String formatExtendedName(String input) {
		
		input = input.toLowerCase().trim();
		StringBuilder output = new StringBuilder();
		
		boolean firstLetterEncountered = false;
		boolean lastCharacterWasDash = false;
		
		for (char character: input.toCharArray()) {
		
			if (Character.isLetter(character)) {
				
				output.append(character);
				firstLetterEncountered = true;
				lastCharacterWasDash = false;
				
			} else if (character == ' ' || character == '-') {
				
				if (firstLetterEncountered && !lastCharacterWasDash) {
					
					output.append("-");
					lastCharacterWasDash = true;
					
				}
				
			} else {
			
				throw new RuntimeException("Invalid/non-processable character in 'extendedName' of Flag object.");
			
			}
		
		}
		
		return output.toString();
		
	}
	
	public char getSimpleFlag() {
		
		return character;
		
	}
	
	public String getExtendedFlag() {
		
		return extendedName;
		
	}
	
	@Override
	public String getHelpText() {
		
		return helpText;
		
	}
	
}