package com.epam.library.data.comparator;

import com.epam.library.model.Book;

import java.util.Comparator;

public class AuthorNameBookComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        String fistBookAuthorName = firstBook.getAuthorName();
        String secondBookAuthorName = secondBook.getAuthorName();
        return fistBookAuthorName.compareToIgnoreCase(secondBookAuthorName);
    }
}
