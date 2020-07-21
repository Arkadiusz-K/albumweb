package pl.albumweb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.albumweb.demo.model.UserDTO;
import pl.albumweb.demo.repository.UserDTORepo;

@Controller
@RequestMapping("/login")
public class LoginController {
    private UserDTORepo userDTORepo;
    public LoginController(UserDTORepo userDTORepo){
        this.userDTORepo = userDTORepo;
    }
    @GetMapping
    public String login(Model model){
        UserDTO userDTO = new UserDTO();
        model.addAttribute("userDTO",userDTO);
        return "login";
    }

    @PostMapping
    public String logFromForm(@ModelAttribute("userDTO") UserDTO userDTO){
        System.out.println("login: "+ userDTO.getLogin());
        UserDTO userDTOfinded = userDTORepo.findByLogin(userDTO.getLogin());
        System.out.println(userDTOfinded.getPassword());
        if(userDTO.getPassword().equals(userDTOfinded.getPassword()) )
            System.out.println("te same hasla");
        else
            System.out.println("INNE hasla");
        return "home";
    }
}
