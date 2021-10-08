package sait.mms.problemdomain;
/**
 * This program is a class to identify "Movie" objects
 * 
 * @author Maria Laura Diaz Pena, Justin Van Groningen
 * @version May 22, 2020
 */
public class Movie {
	 //Attributes
    /**
     * this is the movies duration
     */
    private int duration;
    /**
     * this is the movies Title
     */
    private String title;
    /**
     * this is the year
     */
    private String year;
   
   
    //Constructors
    /** This is our movie constructor which takes in all movie information
     *
     * @param duration - how long the movie is
     * @param title - name of the movie
     * @param year - the year the movie was made
     */
   
    public Movie (int duration, String title, String year) {
        this.duration = duration;
        this.title = title;
        this.year = year;
    }
    // Methods
    /**
     * These are our getters and setters for the Movie class
     * Also included is a toString method that prints out
     *  the movies information as a string
     * There is also a format to File method that makes
     *  the information readable as it is in the file
     * @return
     */
   
    public int getDuration() {
        return duration;
    }
   
    public void setDuration(int duration) {
        this.duration = duration;
    }
   
    public String getTitle() {
        return title;
    }
   
    public void setTitle(String title) {
        this.title = title;
    }
   
    public String getYear() {
        return year;
    }
   
    public void setYear(String year) {
        this.year = year;
    }
   
    public String toString() {
        return String.format("%-10d %-25s %10s", duration,title,year);
    }
    public String formatToFile() {
        return String.format("%d, %s, %s", duration,title,year);
    }
}
