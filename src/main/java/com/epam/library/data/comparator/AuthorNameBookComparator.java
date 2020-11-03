package com.epam.library.data.comparator;

import com.epam.library.model.Book;

import java.util.Comparator;

public class AuthorNameBookComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        if (firstBook == null) {
            return secondBook == null ? 0 : 1;
        }
        if (secondBook == null) {
            return 1;
        }
        String fistBookAuthorName = firstBook.getAuthorName();
        String secondBookAuthorName = secondBook.getAuthorName();

        return fistBookAuthorName.compareToIgnoreCase(secondBookAuthorName);
    }
}
