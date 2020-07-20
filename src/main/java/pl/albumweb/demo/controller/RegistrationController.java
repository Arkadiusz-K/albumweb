package pl.albumweb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.albumweb.demo.model.UserDTO;

@Controller
public class RegistrationController {
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String registration2(@ModelAttribute UserDTO userDTO){
        //UserDTO userDTO = new UserDTO();
        //model.addAttribute("user",userDTO);
        return "home";
    }
}
