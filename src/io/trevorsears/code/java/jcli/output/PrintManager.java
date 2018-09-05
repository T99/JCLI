/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 5:32 PM -- September 03rd, 2018.
 * Classpath: io.trevorsears.code.java.jcli.output.PrintManager
 */

package io.trevorsears.code.java.jcli.output;

import io.trevorsears.code.java.jcli.output.formatting.Color;
import io.trevorsears.code.java.jcli.output.formatting.Decoration;

public class PrintManager {
	
//	private static PrintManager instance;

//	public static PrintManager getInstance() {
//
//		if (instance == null) instance = new PrintManager();
//		return instance;
//
//	}
	
	
	
	public static void print(String string, Color color, Decoration decoration, Output output) {
		
		output.write(new OutputObject(string, color, decoration));
		
	}
	
}