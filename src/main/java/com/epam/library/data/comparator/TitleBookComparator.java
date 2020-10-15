package com.epam.library.data.comparator;

import com.epam.library.model.Book;

public class TitleBookComparator implements BookComparator {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        String fistBookTitle = firstBook.getTitle();
        String secondBookTitle = secondBook.getTitle();
        return fistBookTitle.compareToIgnoreCase(secondBookTitle);
    }
}
