package br.com.alura.screensound.models.records;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MusicResponseData(@JsonAlias("docs") List<MusicData> docs) {
}
