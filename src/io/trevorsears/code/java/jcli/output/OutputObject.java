/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 8:55 AM -- September 05th, 2018.
 * Classpath: io.trevorsears.code.java.jcli.output.OutputObject
 */

package io.trevorsears.code.java.jcli.output;

import io.trevorsears.code.java.jcli.output.formatting.Color;
import io.trevorsears.code.java.jcli.output.formatting.Decoration;

import java.time.LocalDateTime;

public class OutputObject {
	
	String string;
	Color foregroundColor;
	Color backgroundColor;
	Decoration decoration;
	LocalDateTime timestamp;
	boolean hasDefinedStyle;
	
	protected OutputObject(String string) {
		
		this(string, null, null);
		
	}
	
	protected OutputObject(String string, Color foregroundColor) {
		
		this(string, foregroundColor, null);
		
	}
	
	protected OutputObject(String string, Color foregroundColor, Decoration decoration) {
		
		this(string, foregroundColor, null, decoration);
		
	}
	
	protected OutputObject(String string, Color foregroundColor, Color backgroundColor, Decoration decoration) {
		
		this.string = string;
		this.foregroundColor = foregroundColor;
		this.backgroundColor = backgroundColor;
		this.decoration = decoration;
		this.timestamp = LocalDateTime.now();
		
		this.hasDefinedStyle =	foregroundColor != null ||
								backgroundColor != null ||
								decoration != null;
		
	}
	
	protected boolean hasDefinedStyle() {
		
		return hasDefinedStyle;
		
	}
	
	@Override
	public String toString() {
		
		return super.toString();
		
	}
	
}