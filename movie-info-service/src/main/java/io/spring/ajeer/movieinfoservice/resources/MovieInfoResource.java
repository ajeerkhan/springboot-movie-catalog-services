package io.spring.ajeer.movieinfoservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.spring.ajeer.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movie-info")
public class MovieInfoResource {

    List<Movie> movieInfo = Arrays.asList(
    new Movie(1000, "Varisu", "Vijay acting, box office hit movie."),
    new Movie(1001, "Thunivu", "Ajith acting, box office hit movie."),
    new Movie(1002, "Paasa Malar", "Shivaji acting, box office hit movie."),
    new Movie(1003, "Panakaran", "Rajinikanth acting, box office hit movie."),
    new Movie(1004, "Chinnakounder", "Vijaykanth acting, box office hit movie."),
    new Movie(1005, "Nadodimannan", "MGR acting, box office hit movie.")
    );

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        List<Movie> filteredItems = movieInfo.stream().filter(item->item.getMovieId() == Integer.parseInt(movieId)).collect(Collectors.toList());
        if(filteredItems.size()>0)
            return filteredItems.get(0);
        return new Movie(0, "","" );
    }
}
