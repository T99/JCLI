/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 2:05 AM -- September 18th, 2018.
 * Classpath: io.trevorsears.code.java.jcli.input.CharacterNode
 */

package io.trevorsears.code.java.jcli.input;

import java.util.Arrays;
import java.util.HashSet;

public class CharacterNode {
	
	private static final HashSet<Character> ESCAPE_CHARACTERS = new HashSet<>(Arrays.asList('\\'));
	private static final HashSet<Character> DELIMITER_CHARACTERS = new HashSet<>(Arrays.asList('"', '\'', '`'));
	
	private final char character;
	private CharacterNode last, next;
	
	private CharacterNode(char character, CharacterNode last) {
		
		this.character = character;
		this.last = last;
		
	}
	
	/**
	 * Set the next CharacterNode for this CharacterNode to the provided CharacterNode.
	 * 
	 * @param next The CharacterNode to set as this CharacterNode's next/child CharacterNode.
	 * @throws IllegalAccessException Thrown when 
	 */
	void setNext(CharacterNode next) throws IllegalAccessException {
		
		if (this.next == null) this.next = next;
		else throw new IllegalAccessException("Cannot modify the next sequential node of a CharacterNode once it has already been set.");
		
	}
	
	/**
	 * Constructs a linked set of CharacterNodes from a provided String, returning the root CharacterNode (i.e. the
	 * first character represented as a CharacterNode).
	 * 
	 * @param string The String to convert to a linked set of CharacterNodes.
	 * @return The root CharacterNode of the newly created linked set (i.e. the first character represented as a
	 * CharacterNode).
	 */
	public static CharacterNode constructCharacterNodeString(String string) {
		
		if (string.length() <= 0) return null;
		
		char[] characters = string.toCharArray();
		CharacterNode root = new CharacterNode(characters[0], null);
		CharacterNode previousNode = root;
		
		for (int index = 0; index < characters.length; index++) {
			
			CharacterNode currentNode = new CharacterNode(characters[index], previousNode);
			previousNode.setNext(currentNode);
			previousNode = currentNode;
			
		}
		
		return root;
		
	}
	
}