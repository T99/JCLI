/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 8:55 AM -- September 05th, 2018.
 * Classpath: io.trevorsears.code.java.jcli.output.OutputObject
 */

package io.trevorsears.code.java.jcli.output;

import io.trevorsears.code.java.jcli.Environment;
import io.trevorsears.code.java.jcli.output.formatting.Color;
import io.trevorsears.code.java.jcli.output.formatting.Decoration;
import io.trevorsears.code.java.jcli.output.formatting.OutputFormatter;

import java.time.LocalDateTime;

public class OutputObject {
	
	String content;
	Color foregroundColor;
	Color backgroundColor;
	Decoration decoration;
	LocalDateTime timestamp;
	boolean hasDefinedStyle;
	
	// TODO - Make these constructors protected again later...
	
	public OutputObject(String content) {
		
		this(content, null, null, null);
		
	}
	
	public OutputObject(String content, Color foregroundColor) {
		
		this(content, foregroundColor, null, null);
		
	}
	
	public OutputObject(String content, Decoration decoration) {
		
		this(content, null, null, decoration);
		
	}
	
	public OutputObject(String content, Color foregroundColor, Color backgroundColor) {
		
		this(content, foregroundColor, backgroundColor, null);
		
	}
	
	public OutputObject(String content, Color foregroundColor, Decoration decoration) {
		
		this(content, foregroundColor, null, decoration);
		
	}
	
	public OutputObject(String content, Color foregroundColor, Color backgroundColor, Decoration decoration) {
		
		this.content = content;
		this.foregroundColor = foregroundColor;
		this.backgroundColor = backgroundColor;
		this.decoration = decoration;
		this.timestamp = LocalDateTime.now();
		
		this.hasDefinedStyle =	foregroundColor != null ||
								backgroundColor != null ||
								decoration != null;
		
	}
	
	public String getContent() {
		
		return content;
		
	}
	
	public Color getForegroundColor() {
		
		return foregroundColor;
		
	}
	
	public Color getBackgroundColor() {
		
		return backgroundColor;
		
	}
	
	public Decoration getDecoration() {
		
		return decoration;
		
	}
	
	public LocalDateTime getTimestamp() {
		
		return timestamp;
		
	}
	
	protected boolean hasDefinedStyle() {
		
		return hasDefinedStyle;
		
	}
	
	@Override
	public String toString() {
		
		OutputFormatter outputFormatter = Environment.getEnvironment().getEnvironmentSpecificOutputFormatter();
		return outputFormatter.getFormattedText(content, foregroundColor, backgroundColor, decoration);
		
	}
	
}