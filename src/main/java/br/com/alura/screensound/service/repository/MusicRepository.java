package br.com.alura.screensound.service.repository;

import br.com.alura.screensound.models.Artist;
import br.com.alura.screensound.models.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MusicRepository extends JpaRepository<Artist, Long> {
    Optional<Artist> findByNameContainingIgnoreCase(String artistName);

    @Query("SELECT m from Music m")
    List<Music> findAllMusics();

    @Query("SELECT a from Artist a")
    List<Artist> findAllArtists();

    @Query("SELECT m from Artist a JOIN a.musics m WHERE a.name ILike %:artistName%")
    List<Music> findAllMusicsByArtist(String artistName);
}
