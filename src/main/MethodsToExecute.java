package main;

import java.util.ArrayList;
import java.util.Scanner;

public class MethodsToExecute {
	private static ArrayList<String> files; 
	private static final Scanner sc = new Scanner(System.in);
	
	private static final String addTaskInput = "add";
	private static final String removeTaskInput = "remove";
	private static final String listTaskInput = "list"; 
	private static final String listAllTaskInput = "list all"; 
	private static final String findTaskInput = "find";
	
	private static final int addTaskIntInput = 1; 
	private static final int removeTaskIntInput = 2; 
	private static final int listTaskIntInput = 3; 
	private static final int listAllTaskIntInput = 4;
	private static final int findTaskIntInput = 5; 
	
	/**
	 * Constructor for the methods to execute class.
	 */
	public MethodsToExecute(ArrayList<String> files) {
		this.files = files;
	}
	/**
	 * The main operation of the software, all based on user input. 
	 * TODO:
	 * 	- USE GUI RATHER THAN TEXT
	 *  - IMPLEMENT TRY/CATCH STATEMENTS
	 */
	public static void readUserInput() {
		String strUserInput, strDataTypeChoice;
		int intUserInput;
		
		while(true) {
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("Welcome to our file tracking machine!");
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			
			System.out.println("Your options are: add, remove, list, list all, and find..");
			System.out.println("OR: 1 (add), 2 (rem), 3 (list), 4 (list all), or 5 (find)");
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("Integer or string input: ");
			strDataTypeChoice = sc.nextLine(); 
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			
			System.out.println("Enter your task: ");
			if(strDataTypeChoice.contains("str")) {
				strUserInput = sc.nextLine(); 
				
				switch(strUserInput) {
				case addTaskInput:
					System.out.println("Enter what you'd like to add: ");
					String addTask = sc.nextLine(); 
					addFileByName(addTask);
				case removeTaskInput:
					System.out.println("Enter an index position you'd like to remove: ");
					int removeTask = sc.nextInt();
					removeFileAtIndex(removeTask);
				case listTaskInput:
					System.out.println("Enter an index position you'd like to list: ");
					int listTask = sc.nextInt();
					listFileAtIndex(listTask);
				case listAllTaskInput:
					listAllFiles();
				case findTaskInput:
					System.out.println("Enter a file you'd like to find: ");
					String findTask = sc.nextLine();
					findFile(findTask);
				}
			}
			else if(strDataTypeChoice.contains("int")) {
				intUserInput = sc.nextInt(); 
				
				switch(intUserInput) {
				case addTaskIntInput:
					System.out.println("Enter what you'd like to add: ");
					String addTask = sc.nextLine(); 
					addFileByName(addTask);
				case removeTaskIntInput:
					System.out.println("Enter an index position you'd like to remove: ");
					int removeTask = sc.nextInt();
					removeFileAtIndex(removeTask);
				case listTaskIntInput:
					System.out.println("Enter an index position you'd like to list: ");
					int listTask = sc.nextInt();
					listFileAtIndex(listTask);
				case listAllTaskIntInput:
					listAllFiles();
				case findTaskIntInput:
					System.out.println("Enter a file you'd like to find: ");
					String findTask = sc.nextLine();
					findFile(findTask);
				}
			}
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		}
	}
	
	
	/**
	 * Add a new file to the array list. 
	 * 
	 * @param filename
	 */
	public static void addFileByName(String filename) {
		files.add(filename);
	}
	
	/**
	 * Remove a file at an index based on user input. 
	 * @param index
	 */
	public static void removeFileAtIndex(int index) {
		if(files.size() >= 0) {
			if(checkIndex(index))
				files.remove(index);
		} else {
			System.out.println("There are no files!");
		}
	}
	
	/**
	 * List a file at an index based on user input. 
	 * @param index
	 */
	public static void listFileAtIndex(int index) {
		if(files.size() != 0) {
			if(checkIndex(index)) {
				String filename = files.get(index);
				System.out.println(filename);
			}
		} else {
			System.out.println("There are no files!");
		}
	}
	
	/** 
	 * List all of the files in our array list. 
	 */
	public static void listAllFiles() {
		if(files.size() != 0) {
			for(String filename : files) {
				System.out.println(filename);
			}
		} else {
			System.out.println("There are no files!");
		}
	}
	
	/**
	 * Find a file in our array list, based on userInput.
	 * 
	 * @param searchString  user's search request
	 */
	public static void findFile(String searchString) {
		String error = null;
		if(files.size() != 0) {
			for(String filename : files) {
				if(filename.contains(searchString)) {
					System.out.println(filename);
				} else {
					error = "Nothing found, please try again.";
				}
			}
			if(error != null) {
				System.out.println(error);
			}
		} else {
			System.out.println("There are no files!");
		}
	}
	
	/**
	 * Return the number of files, or the length, of our array list. 
	 * 
	 * @return  the number of "files" in the array list / the length of the array list
	 */
	public static int getNumberOfFiles() {
		return files.size(); 
	}
	
	/**
	 * 
	 */
	public static boolean checkIndex(int index) {
		if(index >= 0 && index < files.size())
			return true;
		else 
			return false;
	}
}
