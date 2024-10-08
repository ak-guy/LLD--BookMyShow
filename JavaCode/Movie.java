import Enum.MovieCategory;

public class Movie {
    String movieID;
    String movieName;
    int duration;
    MovieCategory movieCategory;

    public Movie(String movieID, String movieName) {
        this.movieID = movieID;
        this.movieName = movieName;
        this.duration = 120;
        this.movieCategory = MovieCategory.ACTION;
    }

    public String getMovieID() {
        return movieID;
    }
    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }
    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public MovieCategory getMovieCategory() {
        return movieCategory;
    }
    public void setMovieCategory(MovieCategory movieCategory) {
        this.movieCategory = movieCategory;
    }
    
}
