package com.epam.library.data.factory;

import com.epam.library.data.BooksField;
import com.epam.library.model.Book;

import java.util.Comparator;

public interface BookComparatorFactory {
    Comparator<Book> create(BooksField booksField);
}
