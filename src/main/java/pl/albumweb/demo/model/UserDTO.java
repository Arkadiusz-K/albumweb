package pl.albumweb.demo.model;

import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.*;
//@Table(name="users")

@Entity
@Data
public class UserDTO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    public UserDTO(){};
    public UserDTO(String name){
        this.name=name;
    }
}

