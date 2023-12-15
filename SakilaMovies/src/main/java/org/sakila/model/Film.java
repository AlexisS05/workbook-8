package org.sakila.model;

import java.time.LocalDate;

public class Film {

    private final int filmId;
    private final String title;
    private final String description;
    private final LocalDate releaseYear;
    private final int length;

    public Film(int filmId, String title, String description, LocalDate releaseYear, int length) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.length = length;
    }

    public int getFilmId() {
        return filmId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getReleaseYear() {
        return releaseYear;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseYear=" + releaseYear +
                ", length=" + length +
                '}';
    }
}
