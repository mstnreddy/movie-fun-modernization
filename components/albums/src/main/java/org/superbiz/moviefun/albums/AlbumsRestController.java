package org.superbiz.moviefun.albums;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;
import static org.springframework.http.HttpMethod.GET;

@RestController
@RequestMapping("/albums/api")
public class AlbumsRestController {
   private AlbumsRepository albumsRepository;

    public AlbumsRestController(AlbumsRepository albumsRepository) {
        this.albumsRepository = albumsRepository;
    }


    @PostMapping
    public void addAlbum(@RequestBody Album album) {
        albumsRepository.addAlbum(album);

    }

    @GetMapping
    public List<Album> getAlbums() {
        return albumsRepository.getAlbums();
    }
    @GetMapping("/{id}")
    public Album find(@PathVariable long id) {
        return albumsRepository.find(id);
    }
}
