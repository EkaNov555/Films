package ru.netology.films;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FilmsManagerTest {
    FilmsManager manager = new FilmsManager(5);

    @BeforeEach
    public void setup() {
        manager.add("Бладшот (боевик)");
        manager.add("Вперёд (мультфильм)");
        manager.add("Отель <Белград> (комедия)");
    }

    @Test
    public void shouldAllFilm() {

        String[] expected = {"Бладшот (боевик)", "Вперёд (мультфильм)", "Отель <Белград> (комедия)"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFilmEqualMax() {

        manager.add("Джентельмены (боевик)");
        manager.add("Человек-невидимка (ужасы)");

        String[] expected = {"Человек-невидимка (ужасы)", "Джентельмены (боевик)", "Отель <Белград> (комедия)", "Вперёд (мультфильм)", "Бладшот (боевик)"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowFilmEqualDefaultLimit() {
        FilmsManager manager = new FilmsManager();

        manager.add("Бладшот (боевик)");
        manager.add("Вперёд (мультфильм)");
        manager.add("Отель <Белград> (комедия)");
        manager.add("Джентельмены (боевик)");
        manager.add("Человек-невидимка (ужасы)");
        manager.add("Тролли.Мировой (мультфильм)");
        manager.add("Номер один (комедия)");
        manager.add("Movie 8");

        String[] expected = {"Movie 8", "Номер один (комедия)", "Тролли.Мировой (мультфильм)", "Человек-невидимка (ужасы)", "Джентельмены (боевик)", "Отель <Белград> (комедия)", "Вперёд (мультфильм)", "Бладшот (боевик)"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowFilmBelowLimit() {

        String[] expected = {"Отель <Белград> (комедия)", "Вперёд (мультфильм)", "Бладшот (боевик)"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowFilmAboveLimit() {

        manager.add("Джентельмены (боевик)");
        manager.add("Человек-невидимка (ужасы)");
        manager.add("Тролли.Мировой (мультфильм)");
        manager.add("Номер один (комедия)");

        String[] expected = {"Номер один (комедия)", "Тролли.Мировой (мультфильм)", "Человек-невидимка (ужасы)", "Джентельмены (боевик)", "Отель <Белград> (комедия)"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
