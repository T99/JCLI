package com.t99sdevelopment.jcli.dummysubpackage.util;

public class EnvironmentHelper {
	
	private static Boolean isRunningOnIntelliJ;
	private static Environment environment;
	
	public static boolean isRunningInIntelliJ() {
		
		if (isRunningOnIntelliJ == null) {
			
			isRunningOnIntelliJ = System.getProperty("java.class.path").contains("idea_rt.jar");
		}
		
		return isRunningOnIntelliJ;
		
	}
	
	public static Environment getEnvironment() {
		
		if (environment == null) {
			
			String os = System.getProperty("os.name").toLowerCase();
			
			if (os.contains("linux")) environment = Environment.LINUX;
			else if (os.contains("windows")) environment = Environment.WINDOWS;
			else if (os.contains("mac")) environment = Environment.MAC;
			else if (os.contains("sunos")) environment = Environment.SOLARIS;
			
		}
		
		return environment;
		
	}
	
	public enum Environment {
		
		LINUX,
		WINDOWS,
		MAC,
		SOLARIS;
		
	}
	
}
