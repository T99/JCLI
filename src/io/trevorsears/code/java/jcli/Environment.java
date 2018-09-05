/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 7:35 PM -- September 01st, 2018.
 * Classpath: io.trevorsears.code.java.jcli.Environment
 */

package io.trevorsears.code.java.jcli;

import io.trevorsears.code.java.jcli.output.formatting.LinuxOutputFormatter;

public class Environment {
	
	private static Environment instance;
	private final OperatingSystem operatingSystem;
	
	private Environment() {
		
		String osString = System.getProperty("os.name");
		
		if (osString.contains("Windows")) operatingSystem = OperatingSystem.Windows;
		else if (osString.contains("Linux")) operatingSystem = OperatingSystem.Linux;
		else if (osString.contains("Mac")) operatingSystem = OperatingSystem.Macintosh;
		else operatingSystem = OperatingSystem.Unknown;
		
	}
	
	public static Environment getInstance() {
		
		if (instance == null) instance = new Environment();
		return instance;
		
	}
	
	public OperatingSystem getOperatingSystem() {
		
		return operatingSystem;
		
	}
	
	public enum OperatingSystem {
		
		Windows		(null),
		Linux		(new LinuxOutputFormatter()),
		Macintosh	(),
		Unknown		(null);
		
		TextFormatter environmentSpecificTextFormatter;
		
		OperatingSystem(TextFormatter environmentSpecificTextFormatter) {
			
			this.environmentSpecificTextFormatter = environmentSpecificTextFormatter;
			
		}
		
		public TextFormatter getEnvironmentSpecificTextFormatter() {
			
			return environmentSpecificTextFormatter;
			
		}
		
	}
	
}