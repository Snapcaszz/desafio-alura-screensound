package br.com.alura.screensound.models.records;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MusicData(@JsonAlias("title")String name,
                        @JsonAlias("band") String nomeArtista) {
}
