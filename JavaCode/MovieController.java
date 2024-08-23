import java.util.*;

public class MovieController {
    Map<City, List<Movie>> cityMovieMappings;
    List<Movie> allMovies;

    public MovieController() {
        cityMovieMappings = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    public void addMovie(City city, Movie movie) {
        this.allMovies.add(movie);

        List<Movie> moviesList = this.cityMovieMappings.getOrDefault(city, new ArrayList<>());
        moviesList.add(movie);
        this.cityMovieMappings.put(city, moviesList);
    }

    public List<Movie> getMoviesByCity(City city) {
        return this.cityMovieMappings.get(city);
    }
}
