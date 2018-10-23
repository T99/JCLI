/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 4:06 PM -- September 17th, 2018.
 * Classpath: io.trevorsears.code.java.jcli.input.StringTokenizer
 */

package io.trevorsears.code.java.jcli.input;

import io.trevorsears.code.java.jcli.exceptions.MalformedInputException;

import java.util.ArrayList;

public class StringTokenizer {
	
	public static ArrayList<String> tokenize(String string) throws MalformedInputException {
		
		if (string.length() == 0) return new ArrayList<>();
		
		ArrayList<String> tokens = new ArrayList<>();
		CharacterNode node = CharacterNode.constructCharacterNodeString(string);
		Character delimitedBy = null;
		
		while (true) {
			
			if (node.isWhitespace() || !node.hasChild()) {
				
				String expectedInput = node.consume(' ').trim();
				if (expectedInput.length() > 0) tokens.add(expectedInput);
				
			}
			
			if (node.isDelimiter()) {
				
				delimitedBy = node.getCharacter();
				
				do {
					
					node = node.getChild();
					if (node == null) throw new MalformedInputException("An unclosed delimiter occurred in the input string: '" + delimitedBy + "'.");
					
				} while (node.getCharacter() != delimitedBy);
				
				// TODO - Make the following more appropriate/automatic.
				String output = node.consume(delimitedBy);
				tokens.add(output.substring(1, output.length() - 1));
				
				delimitedBy = null;
				
			}
			
			if (node.hasChild()) node = node.getChild();
			else break;
			
		}
		
		return tokens;
		
	}
	
}