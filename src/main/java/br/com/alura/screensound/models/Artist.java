package br.com.alura.screensound.models;

import br.com.alura.screensound.models.records.ArtistData;
import jakarta.persistence.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Music> musics;

    @Enumerated(EnumType.STRING)
    private GroupType groupType;

    public Artist(){}

    public Artist(ArtistData artistData, String groupType) {
        this.name = artistData.name();
        this.groupType = GroupType.fromString(groupType);
        this.musics = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        musics.forEach(music -> music.setArtist(this));
        this.musics = musics;
    }

    public void addMusic(Music music) {
        music.setArtist(this);
        this.musics.add(music);
    }

    @Override
    public String toString() {
        return "Artist: " + this.name +
                ", " + this.groupType;
    }
}
