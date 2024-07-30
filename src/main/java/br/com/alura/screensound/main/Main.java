package br.com.alura.screensound.main;

import br.com.alura.screensound.models.Artist;
import br.com.alura.screensound.models.Music;
import br.com.alura.screensound.models.records.ApiDataForArtistSearch;
import br.com.alura.screensound.models.records.ApiDataForMusicSearch;
import br.com.alura.screensound.models.records.ArtistData;
import br.com.alura.screensound.models.records.MusicData;
import br.com.alura.screensound.service.ArtistWebSearch;
import br.com.alura.screensound.service.data.IDataConverter;
import br.com.alura.screensound.service.repository.MusicRepository;
import br.com.alura.screensound.utils.PromptReader;
import br.com.alura.screensound.service.VagalumeApi;

import java.util.List;
import java.util.Optional;

public class Main {
    private final PromptReader READER;
    private final IDataConverter DATA_CONVERTER;
    private final MusicRepository MUSIC_REPOSITORY;

    private Optional<Artist> artistBusca;

    public Main(PromptReader promptReader, IDataConverter dataConverter, MusicRepository musicRepository){
        this.READER = promptReader;
        this.DATA_CONVERTER = dataConverter;
        this.MUSIC_REPOSITORY = musicRepository;
    }

    public void run() {
        Integer option = null;
        String menuMessage = """
               \n*** Screen Sound ***
               \s
                1 - Register Artist
                2 - Register Music
                3 - List Musics
                4 - List Musics by Artist
                5 - List Artists
                6 - Search Artist on Web
                               \s
                0 - Exit
               \s""";

        do {
            System.out.println(menuMessage);
            System.out.println("\n Select an option: ");
            option = READER.readInt();

            switch (option){
                case 1:
                    registerArtist();
                    break;
                case 2:
                    registerMusic();
                    break;
                case 3:
                    listMusics();
                    break;
                case 4:
                    ListMusicByArtist();
                    break;
                case 5:
                    ListArtists();
                    break;
                case 6:
                    searchArtistOnWeb();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Option, try again!");
            }
        } while (option != 0);
    }



    private void registerArtist() {
        System.out.println("\nType the artist Name: ");
        String artistName = READER.readString();
        String response = VagalumeApi.getArtist(artistName);

        System.out.println("Type the group type of the artist - Choose from (Band, singer, pair): ");
        String groupType = READER.readString();

        ApiDataForArtistSearch artistData = DATA_CONVERTER.stringToObject(response, ApiDataForArtistSearch.class);
        
        for (ArtistData artist : artistData.response().docs()){
            if (artist.name() != null){
                Artist artistToSave = new Artist(artist, groupType);
                MUSIC_REPOSITORY.save(artistToSave);
            }
        }
    }

    private void registerMusic() {
        System.out.println("\nType music name: ");
        String musicName = READER.readString();
        System.out.println("\nType artist name: ");
        String artistName = READER.readString();
        String response = VagalumeApi.getMusicByArtist(musicName, artistName);
        System.out.println("Type the genre of the music - Choose from (Rock, Country, Classic, Jazz, Pop, Rap): ");
        String genre = READER.readString();

        ApiDataForMusicSearch musicData = DATA_CONVERTER.stringToObject(response, ApiDataForMusicSearch.class);

        Music musicToSave = null;
        for (MusicData music : musicData.response().docs()){
            if (music.name() != null){
                musicToSave = new Music(music, genre);
            }
        }

        artistBusca = MUSIC_REPOSITORY.findByNameContainingIgnoreCase(artistName);
        if (artistBusca.isPresent()){
            Artist artistToSave = artistBusca.get();
            artistToSave.addMusic(musicToSave);
            MUSIC_REPOSITORY.save(artistToSave);
        }else {
            Artist artistToSave = registerSearchedArtist(artistName);
            artistToSave.addMusic(musicToSave);
            MUSIC_REPOSITORY.save(artistToSave);
        }
    }

    private Artist registerSearchedArtist(String artistName) {
        System.out.println("\n --> Artist not registered, saving the new Artist to the DataBase.");
        String response = VagalumeApi.getArtist(artistName);

        System.out.println("Type the group type of the artist - Choose from (Band, singer, pair): ");
        String groupType = READER.readString();

        ApiDataForArtistSearch artistData = DATA_CONVERTER.stringToObject(response, ApiDataForArtistSearch.class);
        
        Artist artistToSave = null;
        for (ArtistData artist : artistData.response().docs()){
            if (artist.name() != null){
                artistToSave = new Artist(artist, groupType);
            }
        }
        return artistToSave;
    }

    private void listMusics() {
        List<Music> listOfMusics = MUSIC_REPOSITORY.findAllMusics();
        listOfMusics.forEach(System.out::println);
    }

    private void ListMusicByArtist() {
        System.out.println("\n Type an Artist's name to find their music: ");
        String artistName = READER.readString();
        List<Music> listOfMusics = MUSIC_REPOSITORY.findAllMusicsByArtist(artistName);
        listOfMusics.forEach(System.out::println);

    }

    private void ListArtists() {
        List<Artist> listOfArtists = MUSIC_REPOSITORY.findAllArtists();
        listOfArtists.forEach(System.out::println);
    }

    private void searchArtistOnWeb() {
        System.out.println("Type an artist name to search on the Web: ");
        String artistName = READER.readString();

        String artistInformation = ArtistWebSearch.searchArtistInformation(artistName);
        System.out.println(artistInformation);
    }
}
