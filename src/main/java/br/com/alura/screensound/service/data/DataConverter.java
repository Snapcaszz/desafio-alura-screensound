package br.com.alura.screensound.service.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConverter implements IDataConverter {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T stringToObject(String json, Class<T> $class) {
        try {
            return mapper.readValue(json, $class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}