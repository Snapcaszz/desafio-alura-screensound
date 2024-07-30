package br.com.alura.screensound.models.records;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ArtistResponseData(@JsonAlias("docs") List<ArtistData> docs) {
}
