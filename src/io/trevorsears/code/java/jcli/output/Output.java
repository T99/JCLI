/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 10:37 PM -- September 04th, 2018.
 * Classpath: io.trevorsears.code.java.jcli.output.Output
 */

package io.trevorsears.code.java.jcli.output;

import io.trevorsears.code.java.jcli.output.formatting.Color;
import io.trevorsears.code.java.jcli.output.formatting.Decoration;

import java.util.LinkedList;

public class Output extends OutputNode {
	
	Color standardForegroundOutputColor;
	Color standardBackgroundOutputColor;
	Decoration standardOutputDecoration;
	
	LinkedList<OutputObject> outputHistory = new LinkedList<>();
	
	protected Output(OutputContainer parent, String name, boolean enabled) {
		
		super(parent, name, enabled);
		
	}
	
	public void write(OutputObject output) {
		
		if ()
		
		System.out.println(output);
		outputHistory.add(output);
		
	}
	
}