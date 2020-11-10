package com.epam.library.model;

public class Book {
    private final String title;
    private final String authorName;
    private final int writingYear;
    private final String genre;

    public Book(String title, String authorName, int writingYear, String genre) {
        this.title = title;
        this.authorName = authorName;
        this.writingYear = writingYear;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getWritingYear() {
        return writingYear;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Book book = (Book) o;

        if (writingYear != book.writingYear) {
            return false;
        }
        if (!title.equals(book.title)) {
            return false;
        }
        if (!authorName.equals(book.authorName)) {
            return false;
        }
        return genre.equals(book.genre);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + authorName.hashCode();
        result = 31 * result + writingYear;
        result = 31 * result + genre.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "\"" + title + "\", " + authorName + ", " + writingYear +
                ", Genre: " + genre;
    }
}