/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 1:33 AM -- September 06th, 2018.
 * Classpath: io.trevorsears.code.java.jcli.output.formatting.IntelliJOutputFormatter
 */

package io.trevorsears.code.java.jcli.output.formatting;

public class IntelliJOutputFormatter implements OutputFormatter {
	
	@Override
	public String getFormattedText(String string, Color foregroundColor, Color backgroundColor, Decoration decoration) {
		
		String output = string;
		
		if (foregroundColor != null) output = foregroundColorText(output, foregroundColor);
		if (backgroundColor != null) output = backgroundColorText(output, backgroundColor) ;
		if (decoration != null) output = decorateText(output, decoration);
		
		return output;
		
	}
	
	public static String foregroundColorText(String string, Color foregroundColor) {
		
		switch (foregroundColor) {
			
			case BLACK:
				return IntelliJOutputFormatter.ForegroundColorEscapeCodes.BLACK.getEscapeCode() + string + IntelliJOutputFormatter.ResetEscapeCodes.ALL.getEscapeCode();
			
			case WHITE:
				return IntelliJOutputFormatter.ForegroundColorEscapeCodes.WHITE.getEscapeCode() + string + IntelliJOutputFormatter.ResetEscapeCodes.ALL.getEscapeCode();
			
			case RED:
				return IntelliJOutputFormatter.ForegroundColorEscapeCodes.RED.getEscapeCode() + string + IntelliJOutputFormatter.ResetEscapeCodes.ALL.getEscapeCode();
			
			case ORANGE:
				return IntelliJOutputFormatter.ForegroundColorEscapeCodes.ORANGE.getEscapeCode() + string + IntelliJOutputFormatter.ResetEscapeCodes.ALL.getEscapeCode();
			
			case YELLOW:
				return IntelliJOutputFormatter.ForegroundColorEscapeCodes.YELLOW.getEscapeCode() + string + IntelliJOutputFormatter.ResetEscapeCodes.ALL.getEscapeCode();
			
			case GREEN:
				return IntelliJOutputFormatter.ForegroundColorEscapeCodes.GREEN.getEscapeCode() + string + IntelliJOutputFormatter.ResetEscapeCodes.ALL.getEscapeCode();
			
			case BLUE:
				return IntelliJOutputFormatter.ForegroundColorEscapeCodes.BLUE.getEscapeCode() + string + IntelliJOutputFormatter.ResetEscapeCodes.ALL.getEscapeCode();
			
			case VIOLET:
				return IntelliJOutputFormatter.ForegroundColorEscapeCodes.VIOLET.getEscapeCode() + string + IntelliJOutputFormatter.ResetEscapeCodes.ALL.getEscapeCode();
			
			default:
				return string;
			
		}
		
	}
	
	public static String backgroundColorText(String string, Color backgroundColor) {
		
		switch (backgroundColor) {
			
			case BLACK:
				return IntelliJOutputFormatter.BackgroundColorEscapeCodes.BLACK.getEscapeCode() + string + IntelliJOutputFormatter.ResetEscapeCodes.ALL.getEscapeCode();
			
			case WHITE:
				return IntelliJOutputFormatter.BackgroundColorEscapeCodes.WHITE.getEscapeCode() + string + IntelliJOutputFormatter.ResetEscapeCodes.ALL.getEscapeCode();
			
			case RED:
				return IntelliJOutputFormatter.BackgroundColorEscapeCodes.RED.getEscapeCode() + string + IntelliJOutputFormatter.ResetEscapeCodes.ALL.getEscapeCode();
			
			case ORANGE:
				return IntelliJOutputFormatter.BackgroundColorEscapeCodes.ORANGE.getEscapeCode() + string + IntelliJOutputFormatter.ResetEscapeCodes.ALL.getEscapeCode();
			
			case YELLOW:
				return IntelliJOutputFormatter.BackgroundColorEscapeCodes.YELLOW.getEscapeCode() + string + IntelliJOutputFormatter.ResetEscapeCodes.ALL.getEscapeCode();
			
			case GREEN:
				return IntelliJOutputFormatter.BackgroundColorEscapeCodes.GREEN.getEscapeCode() + string + IntelliJOutputFormatter.ResetEscapeCodes.ALL.getEscapeCode();
			
			case BLUE:
				return IntelliJOutputFormatter.BackgroundColorEscapeCodes.BLUE.getEscapeCode() + string + IntelliJOutputFormatter.ResetEscapeCodes.ALL.getEscapeCode();
			
			case VIOLET:
				return IntelliJOutputFormatter.BackgroundColorEscapeCodes.VIOLET.getEscapeCode() + string + IntelliJOutputFormatter.ResetEscapeCodes.ALL.getEscapeCode();
			
			default:
				return string;
			
		}
		
	}
	
	public static String decorateText(String string, Decoration decoration) {
		
		switch (decoration) {
			
			case BOLD:
				return DecorationEscapeCodes.BOLD.getEscapeCode() + string + ResetEscapeCodes.BOLD.getEscapeCode();
			
			case DIM:
				return DecorationEscapeCodes.DIM.getEscapeCode() + string + ResetEscapeCodes.DIM.getEscapeCode();
			
			case UNDERLINED:
				return DecorationEscapeCodes.UNDERLINED.getEscapeCode() + string + ResetEscapeCodes.UNDERLINED.getEscapeCode();
			
			case BLINK:
				return DecorationEscapeCodes.BLINK.getEscapeCode() + string + ResetEscapeCodes.BLINK.getEscapeCode();
			
			case REVERSE:
				return DecorationEscapeCodes.REVERSE.getEscapeCode() + string + ResetEscapeCodes.REVERSE.getEscapeCode();
			
			case HIDDEN:
				return DecorationEscapeCodes.HIDDEN.getEscapeCode() + string + ResetEscapeCodes.HIDDEN.getEscapeCode();
			
			default:
				return string;
			
		}
		
	}
	
	private enum ForegroundColorEscapeCodes {
		
		BLACK	("\033[30m"),
		WHITE	("\033[97m"),
		RED		("\033[31m"),
		ORANGE	("\033[91m"),
		YELLOW	("\033[33m"),
		GREEN	("\033[32m"),
		BLUE	("\033[34m"),
		VIOLET	("\033[35m");
		
		private final String escapeCode;
		
		ForegroundColorEscapeCodes(String escapeCode) {
			
			this.escapeCode = escapeCode;
			
		}
		
		private String getEscapeCode() {
			
			return escapeCode;
			
		}
		
		
	}
	
	private enum BackgroundColorEscapeCodes {
		
		BLACK	("\033[40m"),
		WHITE	("\033[107m"),
		RED		("\033[41m"),
		ORANGE	("\033[101m"),
		YELLOW	("\033[43m"),
		GREEN	("\033[42m"),
		BLUE	("\033[44m"),
		VIOLET	("\033[45m");
		
		private final String escapeCode;
		
		BackgroundColorEscapeCodes(String escapeCode) {
			
			this.escapeCode = escapeCode;
			
		}
		
		private String getEscapeCode() {
			
			return escapeCode;
			
		}
		
		
	}
	
	private enum DecorationEscapeCodes {
		
		BOLD		("\033[1m"),
		DIM			("\033[2m"),
		UNDERLINED	("\033[4m"),
		BLINK		("\033[5m"),
		REVERSE		("\033[7m"),
		HIDDEN		("\033[8m");
		
		private final String escapeCode;
		
		DecorationEscapeCodes(String escapeCode) {
			
			this.escapeCode = escapeCode;
			
		}
		
		private String getEscapeCode() {
			
			return escapeCode;
			
		}
		
	}
	
	private enum ResetEscapeCodes {
		
		ALL			("\033[0m"),
		BOLD		("\033[21m"),
		DIM			("\033[22m"),
		UNDERLINED	("\033[24m"),
		BLINK		("\033[25m"),
		REVERSE		("\033[27m"),
		HIDDEN		("\033[28m");
		
		private final String escapeCode;
		
		ResetEscapeCodes(String escapeCode) {
			
			this.escapeCode = escapeCode;
			
		}
		
		private String getEscapeCode() {
			
			return escapeCode;
			
		}
		
	}
	
}