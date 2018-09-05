/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 9:51 PM -- September 01st, 2018.
 * Classpath: io.trevorsears.code.java.jcli.InputInterpreter
 */

package io.trevorsears.code.java.jcli;

import io.trevorsears.code.java.jcli.commands.Command;
import io.trevorsears.code.java.jcli.commands.CommandInput;

import java.util.ArrayList;
import java.util.Arrays;

class InputInterpreter {
	
	private static final ArrayList<Character> validDelimiters = new ArrayList<>(Arrays.asList('\'', '"', '`'));
	
	static CommandInput interpret(String input) {
		
		Command command;
		CommandInput commandInput;
		StringCharacterNavigator scn = new StringCharacterNavigator(input);
		
		
		
		return null;
		
	}
	
	static class StringCharacterNavigator {
		
		private int index = 0;
		private String iterationContent;
		
		StringCharacterNavigator(String iterationContent) {
			
			this.iterationContent = iterationContent;
			
		}
		
		boolean increment() {
			
			if (hasNext()) {
				
				index++;
				return true;
				
			} else return false;
			
		}
		
		boolean decrement() {
			
			if (hasLast()) {
				
				index--;
				return false;
				
			} else return false;
			
		}
		
		boolean hasNext() {
			
			return (index <= iterationContent.length() - 1);
			
		}
		
		Character getNext() {
			
			if (hasNext()) return iterationContent.substring(index, index + 1).charAt(0);
			else return null;
			
		}
		
		boolean hasLast() {
			
			return (index >= 1);
			
		}
		
		Character getLast() {
			
			if (hasLast()) return iterationContent.substring(index - 1, index).charAt(0);
			else return null;
			
		}
		
	}
	
}