package com.epam.library.data.comparator;

import com.epam.library.model.Book;

import java.util.Comparator;

public class AuthorNameBookComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        String fistBookAuthorName = firstBook.getAuthorName();
        String secondBookAuthorName = secondBook.getAuthorName();
        if (fistBookAuthorName == null && secondBookAuthorName == null) {
            return 0;
        }
        if (fistBookAuthorName == null) {
            return -1;
        }
        if (secondBookAuthorName == null) {
            return 1;
        }

        return fistBookAuthorName.compareToIgnoreCase(secondBookAuthorName);
    }
}
