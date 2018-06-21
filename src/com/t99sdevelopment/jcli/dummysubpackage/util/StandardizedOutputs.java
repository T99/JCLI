package com.t99sdevelopment.jcli.dummysubpackage.util;

import com.t99sdevelopment.jcli.dummysubpackage.PrintManager;

public class StandardizedOutputs {
	
	public static void invalidArgument(String invalidArgument) {
		
		PrintManager.printWarn("Received an invalid argument of '" + invalidArgument + "'.");
		
	}
	
	public static void incorrectNumberOfArgumentsProvided(int correctNumberOfArguments, int numberOfArgumentsProvided) {
		
		PrintManager.printWarn(numberOfArgumentsProvided + " arguments were passed, rather than " + correctNumberOfArguments + ".");
		
	}
	
	public static void tooFewArgumentsProvided(int minimumNumberOfArguments, int numberOfArgumentsProvided) {
		
		PrintManager.printWarn(numberOfArgumentsProvided + " arguments were passed, rather than " + minimumNumberOfArguments + " or more.");
		
	}
	
	public static void interfaceDoesNotExist(String... nonexistantInterfaces) {
		
		PrintManager.printError("The following Interfaces could not be found in the InterfaceManager's registry: " + HumanReadableOutput.humanReadableArray(nonexistantInterfaces) + ".");
		
	}
	
	public static void commandDoesNotExist(String nonexistantCommand) {
		
		PrintManager.printWarn("No command found for: '" + nonexistantCommand + "'.");
		
	}
	
}
