import java.util.*;

import Enum.City;

public class TheaterController {
    Map<City, List<Theater>> cityTheaterMappings;
    List<Theater> allTheaters;

    public TheaterController() {
        this.cityTheaterMappings = new HashMap<>();
        this.allTheaters = new ArrayList<>();
    }

    public void addTheater(City city, Theater theater) {
        allTheaters.add(theater);

        List<Theater> theaterList = this.cityTheaterMappings.getOrDefault(city, new ArrayList<>());
        theaterList.add(theater);
        this.cityTheaterMappings.put(city, theaterList);
    }

    public Map<Theater, List<Show>> getAllShows(City city, Movie movie) {
        Map<Theater, List<Show>> theaterShowMapping = new HashMap<>();
        List<Theater> theaters = cityTheaterMappings.get(city);

        for (Theater theater : theaters) {
            List<Show> theaterShows = new ArrayList<>();
            List<Show> shows = theater.getShowsList();

            for (Show show : shows) {
                if (show.movie.getMovieID().equals(movie.getMovieID())) {
                    theaterShows.add(show);
                }
            }

            if (!theaterShows.isEmpty()){
                theaterShowMapping.put(theater, theaterShows);
            }
            
        }

        return theaterShowMapping;
    } 
}
