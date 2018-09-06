/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 5:32 PM -- September 03rd, 2018.
 * Classpath: io.trevorsears.code.java.jcli.output.PrintManager
 */

package io.trevorsears.code.java.jcli.output;

import io.trevorsears.code.java.jcli.output.formatting.Color;
import io.trevorsears.code.java.jcli.output.formatting.Decoration;

public class PrintManager {
	
	public static void print(String string, Output output) {
		
		output.write(new OutputObject(string, null, null, null));
		
	}
	
	public static void print(String string, Color color, Decoration decoration, Output output) {
		
		output.write(new OutputObject(string, color, decoration));
		
	}
	
}