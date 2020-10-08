package com.epam.library.data.factory;

import com.epam.library.data.BooksField;
import com.epam.library.data.comparator.*;
import com.epam.library.model.Book;

import java.util.Comparator;

public class BookComparatorFactoryImpl implements BookComparatorFactory {

    @Override
    public Comparator<Book> create(BooksField booksField) {
        switch (booksField) {
            case TITLE:
                return new TitleBookComparator();
            case AUTHOR_NAME:
                return new AuthorNameBookComparator();
            case WRITING_YEAR:
                return new WritingYearBookComparator();
            case GENRE:
                return new GenreBookComparator();
            default:
                throw new IllegalArgumentException(String.format("Book field (%s) not found", booksField));
        }
    }
}
