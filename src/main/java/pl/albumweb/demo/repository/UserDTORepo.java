package pl.albumweb.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.albumweb.demo.model.UserDTO;

import java.util.List;

@Repository
public interface UserDTORepo extends CrudRepository<UserDTO, Integer> {
    UserDTO findByLogin(String login);
}
