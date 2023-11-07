package ru.netology.films;

public class FilmsManager {
    private String[] films = new String[0];
    private int defaultCountFilm; // кол-во фильмов по умолчанию

    public FilmsManager(int defaultCountMovie) { // конструктор с редактируемым количеством фильмов
        this.defaultCountFilm = defaultCountMovie;
    }

    public FilmsManager() { // конструктор с кол-вом фильмов
        this.defaultCountFilm = 8;
    }

    public String[] findAll() {
        return films;
    }
    public void add(String movie) {
        String[] tmp = new String[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = movie;
        films = tmp;
    }
    public String[] findLast() {
        int resultLength;
        if (films.length < defaultCountFilm) {
            resultLength = films.length;
        } else {
            resultLength = defaultCountFilm;
        }
        String[] tmp = new String[resultLength];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = films[films.length - 1 - i];
        }
        return tmp;
    }
}
