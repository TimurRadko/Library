package com.epam.library.data.comparator;

import com.epam.library.model.Book;

import java.util.Comparator;

public class WritingYearBookComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        int firstBookWritingYear = firstBook.getWritingYear();
        int secondBookWritingYear = secondBook.getWritingYear();
        return firstBookWritingYear - secondBookWritingYear;
    }
}
