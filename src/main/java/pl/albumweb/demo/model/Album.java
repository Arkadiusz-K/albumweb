package pl.albumweb.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Album{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String tytul;
    private String autor;
    private String dataPremiery;
    private String playlista;
    private String opis;
    private double sumaOcen;
    private long iloscGlosow;

}
