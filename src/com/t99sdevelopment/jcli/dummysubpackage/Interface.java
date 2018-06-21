package com.t99sdevelopment.jcli.dummysubpackage;

import java.util.Random;
import java.util.Scanner;

public class Interface implements Runnable {
	
	private Thread interfaceThread;
	private String name;
	private volatile boolean isConnected = false;
	private final boolean allowSuggestedYield;
	
	private final Scanner input;
	
	Interface() {
		
		this(generateName(), false);
		
	}
	
	Interface(String name) {
		
		this(name, false);
		
	}
	
	Interface(boolean allowSuggestedYield) {
		
		this(generateName(), allowSuggestedYield);
		
	}
	
	Interface(String name, boolean allowSuggestedYield) {
		
		this.name = name;
		this.allowSuggestedYield = allowSuggestedYield;
		input = new Scanner(System.in);
		InterfaceManager.registerInterface(name, this);
		
		// We have to instantiate the Thread here, otherwise we can get NullPointerExceptions down the line.
		interfaceThread = new Thread(this, "'" + name + "' Interface");
		
		if (InterfaceManager.getCurrentInterface() == null) this.connect();
		
	}
	
	public boolean connect() {
		
		if (isConnected) return false;
		else {
			
			if (InterfaceManager.setCurrentInterface(this)) {
				
				isConnected = true;
				interfaceThread = new Thread(this, "'" + name + "' Interface");
				interfaceThread.start();
				return true;
				
			} else {
				
				PrintManager.printDebug(name + " interface failed to connect.");
				return false;
				
			}
			
		}
	
	}
	
	public boolean disconnect() {
	
		if (isConnected) {
			
			isConnected = false;
			InterfaceManager.removeCurrentInterface(this);
			PrintManager.printDebug(name + " interface successfully disconnected.");
			return true;
			
		} else {
			
			PrintManager.printDebug(name + " interface failed to disconnect.");
			return false;
			
		}
	
	}
	
	void suggestYield() { // Override this if you want different functionality.
		
		if (allowSuggestedYield) {
			
			disconnect();
			
		}
		
	}
	
	public boolean isConnected() {
	
		if (isConnected && interfaceThread.isAlive() && InterfaceManager.checkIfCurrentInterface(this)) {
			
			return true;
			
		} else return false;
	
	}
	
	boolean doesAllowSuggestedYield() {
		
		return allowSuggestedYield;
		
	}
	
	private static String generateName() {
		
		StringBuilder output = new StringBuilder();
		Random random = new Random();
		
		char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWYXZabcdefghijklmnopqrstuvwyxz1234567890=+".toCharArray();
		
		for (int i = 0; i < 8; i++) {
			
			output.append(chars[random.nextInt(chars.length)]);
			
		}
		
		return output.toString();
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		InterfaceManager.updateInterfaceName(this.name, name);
		this.name = name;
		interfaceThread.setName(name);
		
	}
	
	@Override
	public void run() {
	
		while (isConnected) {
			
			PrintManager.printPrompt(this);
			String rawInput = input.nextLine();
			PrintManager.confirmNewLine();
			CommandInterpreter.interpret(rawInput);
			
		}
	
	}
	
}