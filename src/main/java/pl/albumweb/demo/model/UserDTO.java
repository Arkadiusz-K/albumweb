package pl.albumweb.demo.model;

import com.sun.istack.NotNull;

public class UserDTO {
    @NotNull
    private String name;

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
}
