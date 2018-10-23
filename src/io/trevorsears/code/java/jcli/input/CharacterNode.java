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
	private CharacterNode parent, child;
	
	private CharacterNode(char character, CharacterNode parent) {
		
		this.character = character;
		this.parent = parent;
		
	}
	
	public static CharacterNode constructCharacterNodeString(String string) {
		
		if (string.length() <= 0) return null;
		
		CharacterNode rootNode = null;
		CharacterNode currentNode = null;
		
		for (int index = 0; index < string.length(); index++) {
			
			char currentCharacter = string.charAt(index);
			
			if (rootNode == null) {
				
				rootNode = new CharacterNode(currentCharacter, null);
				currentNode = rootNode;
				
			} else {
				
				currentNode.child = new CharacterNode(currentCharacter, currentNode);
				currentNode = currentNode.child;
				
			}
			
		}
		
		return rootNode;
		
	}
	
	char getCharacter() {
		
		return character;
		
	}
	
	boolean hasParent() {
		
		return (parent != null);
		
	}
	
	CharacterNode getParent() {
		
		if (hasParent()) return parent;
		else return null;
		
	}
	
	boolean hasChild() {
		
		return (child != null);
		
	}
	
	CharacterNode getChild() {
		
		if (hasChild()) return child;
		else return null;
		
	}
	
	String consume(char consumeTo) {
		
		StringBuilder stringBuilder = new StringBuilder();
		CharacterNode node = this;
		while(node.hasParent() && node.getParent().getCharacter() != consumeTo) node = node.getParent();
		
		while(true) {
			
			if (!node.isEscapeCharacter()) stringBuilder.append(node.getCharacter());
			
			if (node.hasChild() && !node.equals(this)) node = node.getChild();
			else {
				
				if (node.hasChild() && node.isIgnored()) node.getChild().parent = null;
				break;
				
			}
			
		}
		
		return stringBuilder.toString().trim();
		
	}
	
	boolean isEscapeCharacter() {
		
		if (parent != null) return ESCAPE_CHARACTERS.contains(this.character) && !parent.isEscapeCharacter();
		else return ESCAPE_CHARACTERS.contains(this.character);
		
	}
	
	boolean isDelimiter() {
		
		if (parent != null) return DELIMITER_CHARACTERS.contains(this.character) && !parent.isEscapeCharacter();
		else return DELIMITER_CHARACTERS.contains(this.character);
		
	}
	
	boolean isWhitespace() {
	
		if (parent != null) return Character.isWhitespace(character) && !parent.isEscapeCharacter();
		else return Character.isWhitespace(character);
	
	}
	
	boolean isIgnored() {
		
		return isEscapeCharacter() || isDelimiter() || isWhitespace();
		
	}
	
}