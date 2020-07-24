package pl.albumweb.demo.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.albumweb.demo.RegistrationForm;
import pl.albumweb.demo.model.UserDTO;
import pl.albumweb.demo.repository.UserDTORepo;

@Controller
@RequestMapping("/registration")
public class RegistrationController{
    private UserDTORepo userDTORepo;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(4);
    public RegistrationController(UserDTORepo userDTORepo){
        this.userDTORepo = userDTORepo;
    }

    @GetMapping
    public String registration(Model model){
        UserDTO userDTO = new UserDTO();
       model.addAttribute("userDTO",userDTO);
        return "registration";
    }
    /*

    @PostMapping
    /*public String registrationFromForm(@ModelAttribute("userDTO") UserDTO userDTO){
        //UserDTO userDTOwithEncoding = new UserDTO(userDTO.getUsername(),passwordEncoder.encode(userDTO.getPassword()));
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        System.out.println("login: "+ userDTO.getUsername());
        System.out.println("id: "+userDTO.getId());
        System.out.println("pas: "+userDTO.getPassword());
        userDTORepo.save(userDTO);
        //return "redirect:/login";
        return "home";
    }*/
    @PostMapping
    public String registrationFromForm(@ModelAttribute("userDTO") UserDTO userDTO,RegistrationForm form) {
        //UserDTO userDTOwithEncoding = new UserDTO(userDTO.getUsername(),passwordEncoder.encode(userDTO.getPassword()));
        System.out.println("login: " + userDTO.getUsername());
        System.out.println("id: " + userDTO.getId());
        System.out.println("pas: " + userDTO.getPassword());
        userDTORepo.save(form.toUser(passwordEncoder));
        //userDTORepo.save(userDTO);
        //return "redirect:/login";
        return "home";
    }

}
