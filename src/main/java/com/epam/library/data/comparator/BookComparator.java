package com.epam.library.data.comparator;

import com.epam.library.model.Book;

import java.util.Comparator;

public interface BookComparator extends Comparator<Book> {

    @Override
    int compare(Book firstBook, Book secondBook);
}
