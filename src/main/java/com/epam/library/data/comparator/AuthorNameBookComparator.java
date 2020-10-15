package com.epam.library.data.comparator;

import com.epam.library.model.Book;

public class AuthorNameBookComparator implements BookComparator {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        String fistBookAuthorName = firstBook.getAuthorName();
        String secondBookAuthorName = secondBook.getAuthorName();
        return fistBookAuthorName.compareToIgnoreCase(secondBookAuthorName);
    }
}
