/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 8:36 PM -- September 01st, 2018.
 * Classpath: io.trevorsears.code.java.jcli.output.formatting.TextFormatter
 */

package io.trevorsears.code.java.jcli.output.formatting;

import io.trevorsears.code.java.jcli.Environment;

public class TextFormatter {
	
	private static TextFormatter instance;
	private final TextFormatter environmentFormatter;
	
	TextFormatter() {
		
		switch (Environment.getInstance().getOperatingSystem()) {
			
			case Windows:
				// TODO - Add Windows text formatter.
				environmentFormatter = null;
				break;
				
			case Linux:
				environmentFormatter = new LinuxTextFormatter();
				break;
				
			case Macintosh:
				// TODO - Add Macintosh text formatter.
				environmentFormatter = null;
				break;
				
			default:
				// TODO - What to do, what to do...
				environmentFormatter = null;
				break;
				
		}
		
	}
	
	public static TextFormatter getInstance() {
		
		if (instance == null) instance = new TextFormatter();
		return instance;
		
	}
	
}