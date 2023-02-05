package io.spring.ajeer.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.spring.ajeer.moviecatalogservice.model.CatalogItem;
import io.spring.ajeer.moviecatalogservice.model.CatalogItems;
import io.spring.ajeer.moviecatalogservice.model.Movie;
import io.spring.ajeer.moviecatalogservice.model.MovieRating;
import io.spring.ajeer.moviecatalogservice.model.UserRatings;

@RestController
@RequestMapping("/catalog")
public class MovieCataglogResource {
    
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public CatalogItems getCatalog(@PathVariable("userId") String userId) {
        //RestTemplate restTemplate = new RestTemplate();
        CatalogItems catalogItems = new CatalogItems();
        catalogItems.setUserId(userId);

        UserRatings userMovieRatings = restTemplate.getForObject("http://movie-rating-service/ratings/user/"+ userId, UserRatings.class);
        List<MovieRating> movieRatings  = userMovieRatings.getRatings();

        List<CatalogItem> itemsList = movieRatings.stream().map( movie -> {
            Movie movieInfo = restTemplate.getForObject("http://movie-info-service/movie-info/"+ movie.getMovieId(), Movie.class);
            return (new CatalogItem(movieInfo.getMovieName(), movieInfo.getMovieDesc(), movie.getRatings()));
        })
        .collect(Collectors.toList());
        catalogItems.setCatalogItems(itemsList);
        return catalogItems;    
        //return Collections.singletonList(new CatalogItem("Vaarisu", "Family moview", 100));
    }
}
