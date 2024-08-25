import Enum.*;
import java.util.*;

public class BookMyShow {
    MovieController movieController;
    TheaterController theaterController;

    public BookMyShow() {
        movieController = new MovieController();
        theaterController = new TheaterController();
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();

        bookMyShow.createBooking(City.BANGALORE, "Tere 2");

    }

    public void createBooking(City city, String movieName) {
        List<Movie> moviesAvailableInCity = movieController.getMoviesByCity(city);
        System.out.println(moviesAvailableInCity);
        Movie possibleMovie = null;
        for (Movie movie : moviesAvailableInCity) {
            if (movie.getMovieName().equals(movieName)) {
                possibleMovie = movie;
            }
        }

        if (possibleMovie==null) {
            System.out.println("Movie " + movieName + " not present in " + city.name());
            return;
        }

        Map<Theater, List<Show>> movieShowsInCity = theaterController.getAllShows(city, possibleMovie);
        Map.Entry<Theater, List<Show>> entry = movieShowsInCity.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show selectedShow = runningShows.get(0);

        int selectedSeatNumber = 32;
        List<Integer> bookedSeats = selectedShow.getBookedSeats();
        if (!bookedSeats.contains(selectedSeatNumber)) {
            bookedSeats.add(selectedSeatNumber);

            Booking booking = new Booking();
            List<Seat> myBookedSeat = new ArrayList<>();
            for (Seat screenSeat: selectedShow.getScreen().getSeatList()) {
                if (screenSeat.getSeatID() == selectedSeatNumber) {
                    myBookedSeat.add(screenSeat);
                }
            }
            booking.setSeatIDList(myBookedSeat);
            booking.setShow(selectedShow);

            // handle payment
            booking.setPayment(new Payement() {});
            booking.getPayment().makePayment(1, 211);

        } else {
            System.out.println("Seat already booked");
            return;
        }

        System.out.println("Seat booked successfully!!");
    }

    public void initialize() {
        createMovies();
        createTheaters();
    }

    public void createTheaters() {
        Movie tere = movieController.getMovieByName("Tere");
        Movie tere2 = movieController.getMovieByName("Tere 2");

        Theater inox = new Theater("T-0001", City.BANGALORE);
        inox.setScreenList(getScreenList());
        List<Show> showList = new ArrayList<>();
        Show show1 = createShow("SH-0001", tere, inox.getScreenList().get(0), 8);
        Show show2 = createShow("SH-0002", tere2, inox.getScreenList().get(0), 11);
        showList.add(show1);
        showList.add(show2);
        inox.setShowsList(showList);

        theaterController.addTheater(City.BANGALORE, inox);
    }

    public List<Screen> getScreenList() {
        List<Screen> screenList = new ArrayList<>();
        Screen screen = new Screen();
        screen.setScreenID("SC-0001");
        screen.setSeatList(createSeats());
        screenList.add(screen);
        return screenList;
    }

    public List<Seat> createSeats() {
        List<Seat> seatList = new ArrayList<>();

        for (int i=0; i<50; i++) {
            Seat seat = new Seat(i, SeatCategory.SILVER);
            seatList.add(seat);
        }

        for (int i=51; i<80; i++) {
            Seat seat = new Seat(i, SeatCategory.GOLD);
            seatList.add(seat);
        }

        for (int i=81; i<100; i++) {
            Seat seat = new Seat(i, SeatCategory.PLATINUM);
            seatList.add(seat);
        }

        return seatList;
    }

    public void createMovies() {
        Movie movie1 = new Movie("M-0001", "Tere");
        Movie movie2 = new Movie("M-0002", "Tere 2");

        movieController.addMovie(City.DELHI, movie1);
        movieController.addMovie(City.DELHI, movie2);
        movieController.addMovie(City.BANGALORE, movie1);
        movieController.addMovie(City.BANGALORE, movie2);
    }

    public Show createShow(String showID, Movie movie, Screen screen, int startTime) {
        Show show = new Show(showID, movie, screen, startTime);
        return show;
    }
} 