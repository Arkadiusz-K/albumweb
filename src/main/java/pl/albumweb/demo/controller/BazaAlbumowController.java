package pl.albumweb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bazaAlbumow")
public class BazaAlbumowController {
    @GetMapping
    public String bazaAlbumow(){
        return "bazaAlbumow";
    }
}
