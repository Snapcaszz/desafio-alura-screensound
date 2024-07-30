package br.com.alura.screensound.models;

import br.com.alura.screensound.models.records.MusicData;
import jakarta.persistence.*;

@Entity
@Table(name = "musics", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "artist_id"}))
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    public Music(){}

    public Music(MusicData musicData, String genre){
        this.name = musicData.name();
        this.genre = Genre.fromString(genre);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Music: " + name +
                ", genre=" + genre +
                ", by " + artist;
    }
}
