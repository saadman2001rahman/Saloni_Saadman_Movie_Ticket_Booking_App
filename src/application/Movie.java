package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Movie{
    private String movieName = "";
    private final String[] movieGenre;
    private int movieLengthMin;
    private ArrayList<Theater> theatre;
    private double basePrice;

    public Movie(String mName,String[] mGenre, int mLen,double basePrice){
        this.movieName = mName;
        this.movieGenre = mGenre;
        this.movieLengthMin = mLen;
        this.basePrice = basePrice;
        this.theatre = new ArrayList<>();
    }

    public String getMovieName(){
        return this.movieName;
    }

    public Boolean movieGenreMatch(String[] movieGenre, String[] selectedGenre){
        int counter = 0;
        if(Arrays.equals(movieGenre, selectedGenre)){
            return true;
        }
        for(String genre: selectedGenre){
            for(String sGenre : movieGenre){
                if(Objects.equals(genre, sGenre)) {
                    counter++;
                    break;
                }
            }
        }
        return counter == selectedGenre.length;
    }

    public Movie getMovieFromGenre(String[] mGenre){
        if (movieGenreMatch(this.movieGenre, mGenre)){
            return this;
        }
        else{
            return null;
        }
    }

    public double getBasePrice(){
        return this.basePrice;
    }

    public void setTheatre(ArrayList<Theater> theatre){
        this.theatre = theatre;
    }

    public void addTheatre(Theater theatre){
        this.theatre.add(theatre);
    }

    public ArrayList<Theater> getTheatres(){
        return this.theatre;
    }



}
