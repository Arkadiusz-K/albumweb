package pl.albumweb.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.albumweb.demo.model.Album;


public interface AlbumRepository extends JpaRepository<Album, Long> {
}
