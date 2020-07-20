package pl.albumweb.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.albumweb.demo.model.UserDTO;
import pl.albumweb.demo.repository.UserDTORepo;

@Component
public class UserStart {
    private UserDTORepo userDTORepo;
    @Autowired
    public UserStart(UserDTORepo userDTORepo){
        this.userDTORepo = userDTORepo;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void runExample(){
        UserDTO userDTO = new UserDTO("Arek");
        userDTORepo.save(userDTO);
    }
}
