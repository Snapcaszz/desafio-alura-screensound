package br.com.alura.screensound.models.records;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiDataForArtistSearch(@JsonAlias("response") ArtistResponseData response) {
}
