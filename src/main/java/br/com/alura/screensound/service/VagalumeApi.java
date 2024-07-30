package br.com.alura.screensound.service;

public class VagalumeApi {
    private static final String BASE_URL = "https://api.vagalume.com.br/search";
    private static final String API_KEY = System.getenv("VAGALUME_CREDENTIALS");

    public static String getArtist(String artistName){
        String formatedArtistName = artistName.replace(" ", "%20");
        return ApiRequest.getData(BASE_URL + ".art?" + "apikey="+ API_KEY + "&q=" + formatedArtistName + "&limit=1");
    }

    public static String getMusicByArtist(String musicName, String artistName){
        String formatedArtistAndMusicName = (musicName+" "+artistName).replace(" ", "%20");
        return ApiRequest.getData(BASE_URL + ".artmus?" + "apikey="+ API_KEY + "&q=" + formatedArtistAndMusicName + "&limit=1");
    }
}
