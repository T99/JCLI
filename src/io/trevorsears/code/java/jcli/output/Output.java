/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 10:37 PM -- September 04th, 2018.
 * Classpath: io.trevorsears.code.java.jcli.output.Output
 */

package io.trevorsears.code.java.jcli.output;

import io.trevorsears.code.java.jcli.Environment;
import io.trevorsears.code.java.jcli.output.formatting.Color;
import io.trevorsears.code.java.jcli.output.formatting.Decoration;
import io.trevorsears.code.java.jcli.output.formatting.OutputFormatter;

import java.util.LinkedList;

public class Output extends OutputNode {
	
	Color standardForegroundOutputColor;
	Color standardBackgroundOutputColor;
	Decoration standardOutputDecoration;
	boolean isPrefixed;
	
	LinkedList<OutputObject> outputHistory = new LinkedList<>();
	
	protected Output(OutputContainer parent, String name, boolean enabled) {
		
		super(parent, name, enabled);
		
	}
	
	protected Output(OutputContainer parent, String name, boolean enabled, Color standardForegroundOutputColor, Color standardBackgroundOutputColor, Decoration standardOutputDecoration) {
		
		super(parent, name, enabled);
		
		this.standardForegroundOutputColor = standardForegroundOutputColor;
		this.standardBackgroundOutputColor = standardBackgroundOutputColor;
		this.standardOutputDecoration = standardOutputDecoration;
		
	}
	
	private String getPrefix() {
		
		return (isPrefixed) ? "[" + this.getName() + "] " : "";
		
	}
	
	public void setIsPrefixed(boolean isPrefixed) {
		
		this.isPrefixed = isPrefixed;
		
	}
	
	public void write(OutputObject outputObject) {
		
		OutputFormatter outputFormatter = Environment.getEnvironment().getEnvironmentSpecificOutputFormatter();
		
		if (outputObject.hasDefinedStyle()) {
			
			System.out.println(outputFormatter.getFormattedText(this.getPrefix() + outputObject.getContent(),
				outputObject.getForegroundColor(),
				outputObject.getBackgroundColor(),
				outputObject.getDecoration()));
			
		} else {
			
			System.out.println(outputFormatter.getFormattedText(outputObject.getContent(),
				standardForegroundOutputColor,
				standardBackgroundOutputColor,
				standardOutputDecoration));
			
		}
		
		outputHistory.add(outputObject);
		
	}
	
}