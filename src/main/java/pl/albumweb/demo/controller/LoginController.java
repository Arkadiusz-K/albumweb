package pl.albumweb.demo.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.albumweb.demo.model.UserDTO;
import pl.albumweb.demo.UserDTORepo;

@Controller
@RequestMapping("/login")
public class LoginController {
    private UserDTORepo userDTORepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public LoginController(UserDTORepo userDTORepo) {
        this.userDTORepo = userDTORepo;
    }

    @GetMapping
    public String login(Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("userDTO", userDTO);
        return "login";
    }

    @PostMapping
    public String logFromForm(@ModelAttribute("userDTO") UserDTO userDTO) {
        System.out.println("login: " + userDTO.getUsername());
        if (isAuthenticated(userDTO)) {
            System.out.println("POPRAWNIE ZALOGOWANO");
            return "home";
        }
        return "home";
    }

    private boolean isAuthenticated(UserDTO userDTO) {
        UserDTO userDTOfinded = userDTORepo.findByUsername(userDTO.getUsername());
        //assert userDTOfinded != null;
        System.out.println("zakodowane hasło: "+userDTOfinded.getPassword());
        System.out.println("przekazane haslo: "+userDTO.getPassword());
        if(bCryptPasswordEncoder.matches((CharSequence)userDTO.getPassword(),userDTOfinded.getPassword())){
            System.out.println("Prawidłowy login i hasło");
            return true;
        }else {
            System.out.println("Login jest w bazie ale bledne haslo");
            return false;
        }
        // (userDTO.getPassword().equals(userDTOfinded.getPassword())) {
    }
}
