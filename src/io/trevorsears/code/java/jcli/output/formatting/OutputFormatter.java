/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 2:22 PM -- September 05th, 2018.
 * Classpath: io.trevorsears.code.java.jcli.output.formatting.OutputFormatter
 */

package io.trevorsears.code.java.jcli.output.formatting;

public interface OutputFormatter {
	
	default String getFormattedText(String string, Color foregroundColor) {
		
		return getFormattedText(string, foregroundColor, null, null);
		
	}
	
	default String getFormattedText(String string, Color foregroundColor, Color backgroundColor) {
		
		return getFormattedText(string, foregroundColor, backgroundColor, null);
		
	}
	
	default String getFormattedText(String string, Color foregroundColor, Decoration decoration) {
		
		return getFormattedText(string, foregroundColor, null, decoration);
		
	}
	
	String getFormattedText(String string, Color foregroundColor, Color backgroundColor, Decoration decoration);
	
}
