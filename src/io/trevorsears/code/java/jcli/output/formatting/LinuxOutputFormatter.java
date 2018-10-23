/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 2:26 PM -- September 05th, 2018.
 * Classpath: io.trevorsears.code.java.jcli.output.formatting.LinuxOutputFormatter
 */

package io.trevorsears.code.java.jcli.output.formatting;

public class LinuxOutputFormatter implements OutputFormatter {
	
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
				return ForegroundColorEscapeCodes.BLACK.getEscapeCode() + string + ResetEscapeCodes.ALL.getEscapeCode();
			
			case WHITE:
				return ForegroundColorEscapeCodes.WHITE.getEscapeCode() + string + ResetEscapeCodes.ALL.getEscapeCode();
				
			case RED:
				return ForegroundColorEscapeCodes.RED.getEscapeCode() + string + ResetEscapeCodes.ALL.getEscapeCode();
				
			case ORANGE:
				return ForegroundColorEscapeCodes.ORANGE.getEscapeCode() + string + ResetEscapeCodes.ALL.getEscapeCode();
				
			case YELLOW:
				return ForegroundColorEscapeCodes.YELLOW.getEscapeCode() + string + ResetEscapeCodes.ALL.getEscapeCode();
				
			case GREEN:
				return ForegroundColorEscapeCodes.GREEN.getEscapeCode() + string + ResetEscapeCodes.ALL.getEscapeCode();
				
			case BLUE:
				return ForegroundColorEscapeCodes.BLUE.getEscapeCode() + string + ResetEscapeCodes.ALL.getEscapeCode();
				
			case VIOLET:
				return ForegroundColorEscapeCodes.VIOLET.getEscapeCode() + string + ResetEscapeCodes.ALL.getEscapeCode();
				
			default:
				return string;
				
		}
		
	}
	
	public static String backgroundColorText(String string, Color backgroundColor) {
		
		switch (backgroundColor) {
			
			case BLACK:
				return BackgroundColorEscapeCodes.BLACK.getEscapeCode() + string + ResetEscapeCodes.ALL.getEscapeCode();
			
			case WHITE:
				return BackgroundColorEscapeCodes.WHITE.getEscapeCode() + string + ResetEscapeCodes.ALL.getEscapeCode();
			
			case RED:
				return BackgroundColorEscapeCodes.RED.getEscapeCode() + string + ResetEscapeCodes.ALL.getEscapeCode();
			
			case ORANGE:
				return BackgroundColorEscapeCodes.ORANGE.getEscapeCode() + string + ResetEscapeCodes.ALL.getEscapeCode();
			
			case YELLOW:
				return BackgroundColorEscapeCodes.YELLOW.getEscapeCode() + string + ResetEscapeCodes.ALL.getEscapeCode();
			
			case GREEN:
				return BackgroundColorEscapeCodes.GREEN.getEscapeCode() + string + ResetEscapeCodes.ALL.getEscapeCode();
			
			case BLUE:
				return BackgroundColorEscapeCodes.BLUE.getEscapeCode() + string + ResetEscapeCodes.ALL.getEscapeCode();
			
			case VIOLET:
				return BackgroundColorEscapeCodes.VIOLET.getEscapeCode() + string + ResetEscapeCodes.ALL.getEscapeCode();
			
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
		
		BLACK	("\033[38;5;0m"),
		WHITE	("\033[38;5;15m"),
		RED		("\033[38;5;9m"),
		ORANGE	("\033[38;5;209m"),
		YELLOW	("\033[38;5;11m"),
		GREEN	("\033[38;5;46m"),
		BLUE	("\033[38;5;75m"),
		VIOLET	("\033[38;5;207m");
		
		private final String escapeCode;
		
		ForegroundColorEscapeCodes(String escapeCode) {
			
			this.escapeCode = escapeCode;
			
		}
		
		private String getEscapeCode() {
			
			return escapeCode;
			
		}
		
		
	}
	
	private enum BackgroundColorEscapeCodes {
		
		BLACK	("\033[48;5;0m"),
		WHITE	("\033[48;5;15m"),
		RED		("\033[48;5;9m"),
		ORANGE	("\033[48;5;209m"),
		YELLOW	("\033[48;5;11m"),
		GREEN	("\033[48;5;10m"),
		BLUE	("\033[48;5;4m"),
		VIOLET	("\033[48;5;207m");
		
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