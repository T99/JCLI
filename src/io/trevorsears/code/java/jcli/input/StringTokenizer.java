/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 4:06 PM -- September 17th, 2018.
 * Classpath: io.trevorsears.code.java.jcli.input.StringTokenizer
 */

package io.trevorsears.code.java.jcli.input;

import io.trevorsears.code.java.jcli.exceptions.MalformedInputException;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A utility class that takes in a string input and returns a 'tokenized' (intelligently split) version of the input,
 * with the collective 'tokens' returned as an array of strings.
 * 
 * @author Trevor Sears <trevorsears.main@gmail.com>
 * @version v0.1.0
 * @since v0.1.0
 */
public class StringTokenizer {
	
	/**
	 * The space character - the character on which to split tokens.
	 */
	private static final char SPLIT_CHARACTER = ' ';
	
	/**
	 * The backslash character - the character that indicates that the subsequent character should be read in literally.
	 */
	private static final char ESCAPE_CHARACTER = '\\';
	
	/**
	 * All of the characters that should be used to 'scope' strings, or rather to group those strings that would
	 * otherwise be split on spaces.
	 */
	private static final char[] SCOPING_CHARACTERS = {'"', '\'', '`'};
	
	/**
	 * Tokenizes a provided input string similar to the way in which many common command-line interpreters do so,
	 * allowing the escaping of characters via backslashes or the grouping of characters that would otherwise be split
	 * via spaces.
	 * 
	 * @param input The input string to tokenize.
	 * @return An array of strings representing the various tokens within the input string.
	 * @throws MalformedInputException If the input cannot be properly parsed. This is most commonly due to unclosed
	 * scoping characters (quotation marks).
	 */
	public static String[] tokenize(String input) throws MalformedInputException {
		
		if (input.length() == 0) return new String[0];
		
		ArrayList<String> tokens = new ArrayList<>();
		CharacterProcessor processor = new CharacterProcessor(input.trim());
		
		while (processor.hasNextCharacter()) {
			
			char nextCharacter = processor.getNextCharacter();
			
			if (nextCharacter == StringTokenizer.ESCAPE_CHARACTER) {
				
				processor.skip();
				
				if (processor.hasNextCharacter()) processor.consume();
				
			} else if (nextCharacter == StringTokenizer.SPLIT_CHARACTER) {
				
				if (processor.hasConsumedString()) tokens.add(processor.getConsumedString());
				
				processor.skip();
				
			} else if (StringTokenizer.isScopingCharacter(nextCharacter)) {
				
				processor.skip();
				
				boolean hasFoundMatchingScopingCharacter = false;
				
				while (processor.hasNextCharacter()) {
					
					char nextScopedCharacter = processor.getNextCharacter();
					
					if (nextScopedCharacter == StringTokenizer.ESCAPE_CHARACTER) {
						
						processor.skip();
						
						if (processor.hasNextCharacter()) processor.consume();
						
					} else if (nextScopedCharacter == nextCharacter) {
						
						processor.skip();
						hasFoundMatchingScopingCharacter = true;
						break;
						
					} else processor.consume();
					
				}
				
				if (!hasFoundMatchingScopingCharacter) {
					
					throw new MalformedInputException("An un-closed quotemark prevented the internal string " +
													  "tokenizer from successfully tokenizing the user's " +
													  "input.");
					
				} else if (processor.hasConsumedString()) tokens.add(processor.getConsumedString());
				
			} else processor.consume();
			
		}
		
		if (processor.hasConsumedString()) tokens.add(processor.getConsumedString());
		
		return tokens.toArray(new String[0]);
		
	}
	
	/**
	 * Returns true if a provided character is a recognized scoping character.
	 * 
	 * @param character The character to check.
	 * @return true if a provided character is a recognized scoping character.
	 */
	private static boolean isScopingCharacter(char character) {
		
		for (char scopingCharacter: StringTokenizer.SCOPING_CHARACTERS) {
			
			if (character == scopingCharacter) return true;
			
		}
		
		return false;
		
	}
	
	/**
	 * Processes string inputs character by character.
	 *
	 * @author Trevor Sears <trevorsears.main@gmail.com>
	 * @version v0.1.0
	 * @since v0.1.0
	 */
	private static class CharacterProcessor {
		
		/**
		 * A character array of the characters of the input string provided in the constructor.
		 */
		private char[] characters;
		
		/**
		 * A marker indicating where the consumed set of characters begins.
		 */
		private int tail;
		
		/**
		 * A marker indicating where the consumed set of characters ends.
		 */
		private int head;
		
		/**
		 * A queue of indices that should be skipped as specified by the {@link #skip()} method.
		 */
		private Queue<Integer> indicesToSkip;
		
		/**
		 * Initializes a new CharacterProcessor with the provided input string.
		 * 
		 * @param input The string that is going to be processed by this CharacterProcessor instance.
		 */
		public CharacterProcessor(String input) {
			
			this.characters = input.toCharArray();
			this.head = 0;
			this.tail = 0;
			this.indicesToSkip = new PriorityQueue<>();
			
		}
		
		/**
		 * Consumes a character of the input string, returning true if a character was actually successfully consumed.
		 *
		 * This method only returns false when there are no more characters to consume.
		 * 
		 * @return false if there are no more characters to consume.
		 */
		public boolean consume() {
			
			if (this.head < this.characters.length) {
				
				this.head++;
				return true;
				
			} else return false;
			
		}
		
		/**
		 * Skips the next character, ignoring it in the consumed string that is returned from
		 * {@link #getConsumedString()}.
		 * 
		 * This method only returns false when there are no more characters to skip.
		 * 
		 * @return false if there are no more characters to skip.
		 */
		public boolean skip() {
			
			if (this.head < this.characters.length) {
				
				if (this.tail == this.head) this.tail++;
				else this.indicesToSkip.add(this.head);
				
				this.head++;
				return true;
				
			} else return false;
			
		}
		
		/**
		 * Returns true if there is at least one more character that can be consumed or skipped.
		 * 
		 * @return true if there is at least one more character that can be consumed or skipped.
		 */
		public boolean hasNextCharacter() {
			
			return (this.head < this.characters.length);
			
		}
		
		/**
		 * Returns the next character that can either be consumed or skipped if there is one.
		 * 
		 * @return The next character that can either be consumed or skipped if there is one.
		 * @throws NullPointerException If there are no remaining characters. 
		 * @see #hasNextCharacter() Indicates whether or not this method can be called without throwing a
		 * NullPointerException.
		 */
		public char getNextCharacter() {
			
			return characters[this.head];
			
		}
		
		/**
		 * Returns true if there is currently a non-zero-length string that is ready to be consumed.
		 * 
		 * @return true if there is currently a non-zero-length string that is ready to be consumed.
		 * @see #getConsumedString()
		 */
		public boolean hasConsumedString() {
			
			return (this.head > this.tail);
			
		}
		
		/**
		 * Returns the characters that have been consumed via {@link #consume()} represented as a string.
		 * 
		 * @return The characters that have been consumed via #consume() represented as a string.
		 * @see #hasConsumedString() Indicates whether or not this method will return a non-zero-length string when
		 * called.
		 */
		public String getConsumedString() {
			
			StringBuilder builder = new StringBuilder();
			
			for (int i = this.tail; i < this.head; i++) {
				
				if (!this.indicesToSkip.isEmpty() && (this.indicesToSkip.peek() == i)) this.indicesToSkip.poll();
				else builder.append(this.characters[i]);
				
			}
			
			this.tail = this.head;
			
			return builder.toString();
			
		}
		
		/**
		 * Returns true if the entirety of the string provided in the constructor has been consumed via
		 * {@link #consume()} AND returned via {@link #getConsumedString()}.
		 * 
		 * @return true if the entirety of the string provided in the constructor has been consumed via #consume() AND
		 * returned via @link #getConsumedString().
		 */
		public boolean isFullyConsumed() {
			
			return (this.tail >= this.characters.length);
			
		}
		
	}
	
}