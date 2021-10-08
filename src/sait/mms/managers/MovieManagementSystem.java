package sait.mms.managers;

import java.io.*;
import java.util.*;

import sait.mms.problemdomain.Movie;

/**
 * This program loads the file and reads from it. Also displays the menu where you can:
 * -Add a new movie to the file, and save it.
 * -Generate a list of movies from a specific year.
 * -Generate a list of random movies.
 * 
 * @author Maria Laura Diaz Pena, Justin Van Groningen
 * @version May 22, 2020
 */
public class MovieManagementSystem {
	// constants
	private static final String PATH = "rsc\\movies.txt";

	// attributes
	private Scanner input;
	/**
	 * This arrayList stores all of the movies.
	 */
	ArrayList<Movie> movies;

	// Constructors
	/**
	 * This is the default constructor.
	 * @throws FileNotFoundException
	 */
	public MovieManagementSystem() throws FileNotFoundException {
		input = new Scanner(System.in);

		movies = new ArrayList<Movie>();

		loadMovieList();
	}

	//Methods
	/**
	 * The displayMenu method, where we are introducing the other methods that make our 
	 * program work.
	 * @throws IOException
	 */
	public void displayMenu() throws IOException {

		int option = -1;

		while (option != 4) {

			System.out.println("Movie Management System");
			System.out.println("1     Add New Movie and Save");
			System.out.println("2     Generate List of Movies Released in a Year");
			System.out.println("3     Generate a List of Random Movies");
			System.out.println("4     Exit");

			System.out.print("Enter an option: ");
			option = input.nextInt();

			switch (option) {
			case 1:
				addMovie();
				break;
			case 2:
				generateMovieListInYear();
				break;
			case 3:
				generateRandomMovieList();
				break;
			case 4:
				System.out.println("Closing...");

				break;
			default:
				System.out.println("Invalid option!");
			}

		}

	}

	/**
	 * the AddMovie method where we add a new movie, duration, title and year, to our txt file.
	 * This method also saves the addition to the file.
	 * @throws IOException
	 */
	private void addMovie() throws IOException {
		System.out.print("Enter duration: ");
		int addDuration = input.nextInt();
		input.nextLine();

		System.out.print("Enter movie title: ");
		String addMovieT = input.next();

		System.out.print("Enter year: ");
		String addYear = input.next();

		movies.add(new Movie(addDuration, addMovieT, addYear));

		System.out.println("Saving movies...");
		System.out.println("Added movie to the data file.");


	FileWriter fw = new FileWriter(PATH, true);
		PrintWriter outputFile = new PrintWriter(fw);
		for (Movie tmpMovie : movies) {
			outputFile.println((tmpMovie).formatToFile());
		}
		outputFile.close();
	}

	/**
	 * generateMovieListInYear method we input the year and we get a list of all the movies
	 * made that year and adds up the duration at the end.
	 * @throws FileNotFoundException
	 */
	public void generateMovieListInYear() throws FileNotFoundException{
		Scanner inFile = new Scanner(new File(PATH));
		System.out.print("Enter in year: ");
		String generateYear = input.next();
		
		
		String[] columns;
		String line = "";
		System.out.printf("%-10s %-10s %20s\n", "Duration", "Title", "Year");
		int totalDuration = 0;
		while (inFile.hasNextLine()) {
			line = inFile.nextLine();
			columns = line.split(",");

			Movie tmpMovie = new Movie(Integer.parseInt(columns[0]), columns[1], columns[2]);
			if(generateYear.equals(tmpMovie.getYear())){ 

				totalDuration += tmpMovie.getDuration();
				tmpMovie.toString();
				System.out.printf("%-10d %-20s %10s\n", tmpMovie.getDuration(), tmpMovie.getTitle(), tmpMovie.getYear());
			}
			
		}System.out.println("Total duration: " + totalDuration + " minutes");
		System.out.println("");
	}

	/**
	 * generateRandomMovieList method gets a list of random  movies, as many as you specify, 
	 * and adds up the duration a the end.
	 * @throws FileNotFoundException
	 */
	public void generateRandomMovieList() throws FileNotFoundException{
		int totalDuration = 0;

		System.out.print("Enter number of movies: ");
		int numMovies = input.nextInt();
		System.out.println("");
		System.out.println("Movie List");
		System.out.printf("%-10s %-10s %25s\n", "Duration", "Title", "Year");

		for (int i = numMovies; i > 0; i--) {
			Collections.shuffle(movies);
			System.out.println(movies.get(0).toString());

			totalDuration += movies.get(0).getDuration();

		}
		System.out.println("Total duration: " + totalDuration + " minutes");
	}
	
	/**
	 * loadMovieList methods loads the movie into our program.
	 * @throws FileNotFoundException
	 */
	public void loadMovieList() throws FileNotFoundException {

		Scanner inFile = new Scanner(new File(PATH));
		
		String line = "";
		String[] columns;
		while (inFile.hasNextLine()) {
			line = inFile.nextLine();
			columns = line.split(",");
			
			Movie tmpMovie = new Movie(Integer.parseInt(columns[0]), columns[1], columns[2]);
			
			movies.add(tmpMovie);

		}
		inFile.close();
		System.out.println("File is loaded!");
	}

}