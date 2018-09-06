/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 7:35 PM -- September 01st, 2018.
 * Classpath: io.trevorsears.code.java.jcli.Environment
 */

package io.trevorsears.code.java.jcli;

import io.trevorsears.code.java.jcli.output.formatting.IntelliJOutputFormatter;
import io.trevorsears.code.java.jcli.output.formatting.LinuxOutputFormatter;
import io.trevorsears.code.java.jcli.output.formatting.OutputFormatter;

public enum Environment {
	
	WINDOWS			(null),
	LINUX			(new LinuxOutputFormatter()),
	LINUX_INTELLIJ	(new IntelliJOutputFormatter()),
	MACINTOSH		(null),
	UNKNOWN			(null);
	
	private static Environment environment;
	
	private final OutputFormatter environmentSpecificOutputFormatter;
	
	Environment(OutputFormatter environmentSpecificOutputFormatter) {
		
		this.environmentSpecificOutputFormatter = environmentSpecificOutputFormatter;
		
	}
	
	public static Environment getEnvironment() {
		
		if (environment == null) {
			
			String osString = System.getProperty("os.name");
			
			if (osString.contains("Windows")) environment = WINDOWS;
			else if (osString.contains("Linux")) {
				
				if (System.getProperty("java.class.path").contains("idea_rt.jar")) environment = LINUX_INTELLIJ;
				else environment = LINUX;
				
			} else if (osString.contains("Mac")) environment = MACINTOSH;
			else environment = UNKNOWN;
			
		}
		
		return environment;
		
	}
	
	public OutputFormatter getEnvironmentSpecificOutputFormatter() {
		
		return environmentSpecificOutputFormatter;
		
	}
	
}