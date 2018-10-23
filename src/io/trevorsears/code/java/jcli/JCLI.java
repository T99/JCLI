/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 3:01 PM -- August 31st, 2018.
 * Classpath: io.trevorsears.code.java.jcli.JCLI
 */

package io.trevorsears.code.java.jcli;

import io.trevorsears.code.java.jcli.commands.Command;
import io.trevorsears.code.java.jcli.exceptions.runtime.JCLINotInitializedException;
import io.trevorsears.code.java.jcli.output.OutputContainer;
import io.trevorsears.code.java.trie.Trie;

import java.util.Scanner;

public class JCLI implements Runnable {
	
	private static JCLI instance;
	private Trie<Command> commandRegistry;
	private OutputContainer outputRegistry;
	private Thread thread;
	private Scanner stdin = new Scanner(System.in);
	
	private JCLI(boolean autoStart) {
	
		commandRegistry = new Trie<>();
		outputRegistry = OutputContainer.getRootContainer(this);
		thread = new Thread(this);
		
		if (autoStart) thread.start();
	
	}
	
	public static boolean initializeInstance() {
		
		return initializeInstance(true);
		
	}
	
	public static boolean initializeInstance(boolean autoStart) {
		
		if (instance == null) {
			
			instance = new JCLI(autoStart);
			
			instance.outputRegistry.addOutputContainer("Standard Log Levels");
			OutputContainer standardLogLevels = instance.outputRegistry.getOutputContainer("Standard Log Levels");
			standardLogLevels.addOutput("Stdout", true);
			standardLogLevels.getOutput("Stdout").setIsPrefixed(false);
			standardLogLevels.addOutput("INFO", false);
			standardLogLevels.addOutput("WARN", false);
			standardLogLevels.addOutput("ERR", false);
			standardLogLevels.addOutput("DEBUG", false);
			
			return true;
			
		} else return false;
		
	}
	
	public static JCLI getInstance() {
		
		if (instance == null) throw new JCLINotInitializedException();
		else return instance;
		
	}
	
	public void start() {
		
		thread.start();
		
	}
	
	public void stop() {
		
		thread.interrupt();
		
	}
	
	public void stopAndJoin() {
		
		if (thread.isInterrupted()) {
			
			try { thread.join(); }
			catch (InterruptedException ignored) { /* Do nothing. */ }
			
		} else {
			
			thread.interrupt();
			try { thread.join(); }
			catch (InterruptedException ignored) { /* Do nothing. */ }
			
		}
		
	}
	
	public void registerCommand(Command command) {
		
		commandRegistry.add(command.getName(), command);
		
	}
	
	public void deregisterCommand(String commandName) {
		
		commandRegistry.remove(commandName);
		
	}
	
	public OutputContainer getOutputRegistry() {
		
		return outputRegistry;
		
	}
	
	@Override
	public void run() {
		
		System.out.println("JCLI is starting...");
		
		while (!this.thread.isInterrupted()) {
		
		
			
		}
		
		System.out.println("JCLI is stopping...");
		
		// Remove the interrupt flag.
		this.thread.interrupt();
		
		// TODO - Handle interruption.
	
	}
	
}