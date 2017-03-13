package main;

import java.util.ArrayList;

public class Main {
	private static ArrayList<String> files = new ArrayList<String>();
	private static MethodsToExecute methods = new MethodsToExecute(files); 
		
	/**
	 * Main method. Called when the program is run by the computer.
	 * @param args
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		methods.readUserInput();
	}
}
