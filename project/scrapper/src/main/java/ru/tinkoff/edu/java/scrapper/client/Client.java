package ru.tinkoff.edu.java.scrapper.client;

import java.util.Optional;


public interface Client {
    <T> Optional<T> get(String uri, Class<T> destClass);
}
