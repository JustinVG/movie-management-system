package sait.mms.application;
import java.io.*;

import sait.mms.managers.*;

/**
 * This is the program where MovieManagementSystem class runs the menu and the options
 * 
 * 
 * @author Maria Laura Diaz Pena, Justin Van Groningen
 * @version May 22, 2020
 */
public class AppDriver {
 
	/**
	 * The main method and also where we start the program.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		//we create a MovieManagementSystem instance into this class
		MovieManagementSystem mms = new MovieManagementSystem();
		
		//Calling the method from MovieManagementSystem to display our menu
		mms.displayMenu();
	}
}
