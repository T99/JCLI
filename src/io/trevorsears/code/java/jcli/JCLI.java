/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 3:01 PM -- August 31st, 2018.
 * Classpath: io.trevorsears.code.java.jcli.JCLI
 */

package io.trevorsears.code.java.jcli;

import io.trevorsears.code.java.jcli.commands.Command;
import io.trevorsears.code.java.jcli.exceptions.JCLINotInitializedException;
import io.trevorsears.code.java.trie.Trie;

import java.util.Scanner;

public class JCLI implements Runnable {
	
	private static JCLI instance;
	private Trie<Command> commandRegistry;
	private Thread thread;
	private Scanner stdin = new Scanner(System.in);
	
	private JCLI(boolean autoStart) {
	
		commandRegistry = new Trie<>();
		thread = new Thread(this);
		
		if (autoStart) thread.start();
	
	}
	
	public static boolean initializeInstance() {
		
		return initializeInstance(true);
		
	}
	
	public static boolean initializeInstance(boolean autoStart) {
		
		if (instance == null) {
			
			instance = new JCLI(autoStart);
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
	
	public void registerCommand(String commandName, Command command) {
		
		commandRegistry.add(commandName, command);
		
	}
	
	public void deregisterCommand(String commandName) {
		
		commandRegistry.remove(commandName);
		
	}
	
	@Override
	public void run() {
		
		System.out.println("JCLI is starting...");
		
		while (!this.thread.isInterrupted()) {
			
			InputInterpreter.interpret(stdin.nextLine());
			
		}
		
		System.out.println("JCLI is stopping...");
		
		// Remove the interrupt flag.
		this.thread.interrupt();
		
		// TODO - Handle interruption.
	
	}
	
}