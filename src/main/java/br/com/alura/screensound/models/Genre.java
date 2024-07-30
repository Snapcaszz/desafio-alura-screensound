package br.com.alura.screensound.models;

public enum Genre {
    ROCK ("Rock"),
    COUNTRY ("Country"),
    CLASSIC ("Classic"),
    JAZZ ("Jazz"),
    RAP ("Rap"),
    POP ("Pop");

    private final String GENRE;

    Genre (String genre) {
        this.GENRE = genre;
    }

    public static Genre fromString(String text) {
        for (Genre genre : Genre.values()) {
            if (genre.GENRE.equalsIgnoreCase(text)) {
                return genre;
            }
        }
        throw new IllegalArgumentException("No Genre found for the provided text: " + text);
    }
}
