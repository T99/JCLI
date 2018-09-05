/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 7:35 PM -- September 01st, 2018.
 * Classpath: io.trevorsears.code.java.jcli.Environment
 */

package io.trevorsears.code.java.jcli;

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
		
		Windows,
		Linux,
		Macintosh,
		Unknown;
		
	}
	
}