package pl.albumweb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.albumweb.demo.model.Album;
import pl.albumweb.demo.AlbumRepository;

@Controller
@RequestMapping("/dodajAlbum")
public class DodajAlbumController {
    private AlbumRepository albumRepository;
    public DodajAlbumController(AlbumRepository albumRepository){
        this.albumRepository = albumRepository;
    }
    @GetMapping
    public String bazaAlbumow(){
        return "dodajAlbum";
    }
    @PostMapping
    public String bazaAlbumowPost(@ModelAttribute("album") Album album){
        System.out.println("Obsluga formularza");
        System.out.println(album.getAutor());
        album.setIloscGlosow(0);
        album.setSumaOcen(0.0);
        albumRepository.save(album);
        return "dodajAlbum";
    }
}
