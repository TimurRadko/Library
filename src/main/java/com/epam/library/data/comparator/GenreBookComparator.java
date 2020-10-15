package com.epam.library.data.comparator;

import com.epam.library.model.Book;

import java.util.Comparator;

public class GenreBookComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        String fistBookGenre = firstBook.getGenre();
        String secondBookGenre = secondBook.getGenre();
        return fistBookGenre.compareToIgnoreCase(secondBookGenre);
    }
}
