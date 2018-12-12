package org.superbiz.moviefun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.superbiz.moviefun.albums.AlbumFixtures;
import org.superbiz.moviefun.albums.AlbumInfo;
import org.superbiz.moviefun.albums.AlbumsClient;
import org.superbiz.moviefun.albums.AlbumsRepository;
import org.superbiz.moviefun.movies.MoviesRepository;
import org.superbiz.moviefun.moviesapi.MovieFixtures;
import org.superbiz.moviefun.moviesapi.MovieInfo;
import org.superbiz.moviefun.moviesapi.MoviesClient;


import java.util.Map;

@Controller
public class HomeController {

    private MoviesClient moviesClient;
    private AlbumsClient albumsClient;

    private final MovieFixtures movieFixtures;
    private final AlbumFixtures albumFixtures;

    public HomeController(MoviesClient moviesClient,  MovieFixtures movieFixtures,
                           AlbumFixtures albumFixtures, AlbumsClient albumsClient) {
        this.moviesClient = moviesClient;
        this.movieFixtures = movieFixtures;
        this.albumsClient=albumsClient;
        this.albumFixtures=albumFixtures;

}



   /* public HomeController(MoviesBean moviesBean,
                          //AlbumsBean albumsBean,
                          MovieFixtures movieFixtures
                          //, AlbumFixtures albumFixtures
                          ) {
        this.moviesBean = moviesBean;
       // this.albumsBean = albumsBean;
        this.movieFixtures = movieFixtures;
        //this.albumFixtures = albumFixtures;
    }*/

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/setup")
    public String setup(Map<String, Object> model) {
        for (MovieInfo movie : movieFixtures.load()) {
            moviesClient.addMovie(movie);
        }

        for (AlbumInfo album : albumFixtures.load()) {
            albumsClient.addAlbum(album);
        }

        model.put("movies", moviesClient.getMovies());
        model.put("albums", albumsClient.getAlbums());

        return "setup";
    }
}
