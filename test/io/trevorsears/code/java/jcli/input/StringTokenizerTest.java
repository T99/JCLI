package io.trevorsears.code.java.jcli.input;

import io.trevorsears.code.java.jcli.exceptions.MalformedInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringTokenizerTest {
	
	void testEquals(String input, String[] expectedOutput) {
		
		System.out.println("With input string:\t\t\t" + input);
		System.out.print("We expect an output of:\t\t[");
		
		for (int index = 0; index < expectedOutput.length; index++) {
			
			System.out.print("'" + expectedOutput[index] + "'");
			if (index < expectedOutput.length - 1) System.out.print(", ");
			
		}
		
		System.out.println("]");
		
		try {
			
			String[] actualOutput = StringTokenizer.tokenize(input).toArray(new String[0]);
			
			System.out.print("And received an output of:\t[");
			
			for (int index = 0; index < actualOutput.length; index++) {
				
				System.out.print("'" + actualOutput[index] + "'");
				if (index < actualOutput.length - 1) System.out.print(", ");
				
			}
			
			System.out.println("]");
			
			assertArrayEquals(expectedOutput, actualOutput);
			
		} catch (MalformedInputException e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	@Test
	void T01_SingleWord() {
	
		testEquals("input", new String[] {"input"});
	
	}
	
	@Test
	void T02_Sentence() {
		
		testEquals("Hello Johnny boy.", new String[] {"Hello", "Johnny", "boy."});
		
	}
	
	@Test
	void T03_NonWordString() {
		
		testEquals("~ ` ! @ # $ % ^ & * ( ) _ - + = [ { ] } \\ | : ; \" ' < , > . ? /", new String[] {"~", "`", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "-", "+", "=", "[", "{", "]", "}", "|", ":", ";", "\"", "'", "<", ",", ">", ".", "?", "/"});
		
	}
	
	@Test
	void T04_LongSentence() {
		
		testEquals("Today\\'s message consists of a long string of words that really have no consequence: tomato, bird, pedal, stove, backpack, router, lanyard.", new String[] {"Today's", "message", "consists", "of", "a", "long", "string", "of", "words", "that", "really", "have", "no", "consequence:", "tomato,", "bird,", "pedal,", "stove,", "backpack,", "router,", "lanyard."});
		
	}
	
	@Test
	void T05_EscapedWhitespace() {
		
		testEquals("Hello\\ there!", new String[] {"Hello there!"});
		
	}
	
	@Test
	void T06_EscapedDelimiter() {
		
		testEquals("Hello\\\" there!", new String[] {"Hello\"", "there!"});
		
	}
	
	@Test
	void T07_EscapedEscapeCharacter() {
		
		testEquals("Hello\\\\ there!", new String[] {"Hello\\", "there!"});
		
	}
	
	@Test
	void T08_DelimitedStringWithDoubleQuote() {
		
		testEquals("Hello \"there Johnny boy!\"", new String[] {"Hello", "there Johnny boy!"});
		
	}
	
	@Test
	void T09_DelimitedStringWithSingleQuote() {
		
		testEquals("Hello 'there Johnny boy!'", new String[] {"Hello", "there Johnny boy!"});
		
	}
	
	@Test
	void T10_DelimitedStringWithGraveQuote() {
		
		testEquals("Hello `there Johnny boy!`", new String[] {"Hello", "there Johnny boy!"});
		
	}
	
	@Test
	void T11_ExtraSpacesInsideString() {
		
		testEquals("This  is   a test", new String[] {"This", "is", "a", "test"});
		
	}
	
	@Test
	void T12_ExtraSpacesAroundString() {
		
		testEquals("   Hello there   ", new String[] {"Hello", "there"});
		
	}
	
	@Test
	void T13_ExtraSpacesInsideAndOutsideString() {
		
		testEquals(" what  even is      this   ", new String[] {"what", "even", "is", "this"});
		
	}
	
}