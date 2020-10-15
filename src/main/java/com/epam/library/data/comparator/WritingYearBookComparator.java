package com.epam.library.data.comparator;

import com.epam.library.model.Book;

public class WritingYearBookComparator implements BookComparator {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        int firstBookWritingYear = firstBook.getWritingYear();
        int secondBookWritingYear = secondBook.getWritingYear();
        return firstBookWritingYear - secondBookWritingYear;
    }
}
