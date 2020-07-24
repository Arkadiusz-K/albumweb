package pl.albumweb.demo;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.albumweb.demo.model.UserDTO;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    PasswordEncoder passwordEncoder;
    public UserDTO toUser(PasswordEncoder passwordEncoder){
        System.out.println("RF: username-> "+username+" ,pass-> "+password);
        return new UserDTO(username,passwordEncoder.encode(password) );
    }
}
