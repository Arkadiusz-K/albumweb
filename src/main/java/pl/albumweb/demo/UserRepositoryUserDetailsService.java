package pl.albumweb.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.albumweb.demo.model.UserDTO;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {
    private UserDTORepo userDTORepo;
    @Autowired
    public UserRepositoryUserDetailsService(UserDTORepo userDTORepo){
        this.userDTORepo = userDTORepo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO userDTO = userDTORepo.findByUsername(username);
        if(userDTO != null) return userDTO;
        throw new UsernameNotFoundException("Użytkownik '"+username+"' nie został znaleziony");
    }
}
