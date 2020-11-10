package com.epam.library.data.comparator;

import com.epam.library.model.Book;

import java.util.Comparator;

public class TitleBookComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        String fistBookTitle = firstBook.getTitle();
        String secondBookTitle = secondBook.getTitle();
        if (fistBookTitle == null && secondBookTitle == null) {
            return 0;
        }
        if (fistBookTitle == null) {
            return -1;
        }
        if (secondBookTitle == null) {
            return 1;
        }
        return fistBookTitle.compareToIgnoreCase(secondBookTitle);
    }
}
