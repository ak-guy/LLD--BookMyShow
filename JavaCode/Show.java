import java.util.*;

public class Show {
    String showID;
    Movie movie;
    Screen screen;
    int startTime;
    List<Integer> bookedSeats = new ArrayList<>();

    public String getShowID() {
        return showID;
    }
    public void setShowID(String showID) {
        this.showID = showID;
    }
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    public Screen getScreen() {
        return screen;
    }
    public void setScreen(Screen screen) {
        this.screen = screen;
    }
    public int getStartTime() {
        return startTime;
    }
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
    public List<Integer> getBookedSeats() {
        return bookedSeats;
    }
    public void setBookedSeats(List<Integer> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

}
