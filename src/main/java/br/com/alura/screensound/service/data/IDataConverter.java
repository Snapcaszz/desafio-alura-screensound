package br.com.alura.screensound.service.data;

public interface IDataConverter {
    <T> T  stringToObject(String json, Class<T> classe);
}
