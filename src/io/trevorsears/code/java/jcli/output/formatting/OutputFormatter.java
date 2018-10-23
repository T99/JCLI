/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 2:22 PM -- September 05th, 2018.
 * Classpath: io.trevorsears.code.java.jcli.output.formatting.OutputFormatter
 */

package io.trevorsears.code.java.jcli.output.formatting;

public interface OutputFormatter {
	
	String getFormattedText(String string, Color foregroundColor, Color backgroundColor, Decoration decoration);
	
}
