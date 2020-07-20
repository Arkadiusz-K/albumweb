package pl.albumweb.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.albumweb.demo.model.UserDTO;

@Repository
public interface UserDTORepo extends CrudRepository<UserDTO, Integer> {
}
