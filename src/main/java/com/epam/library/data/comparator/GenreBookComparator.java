package com.epam.library.data.comparator;

import com.epam.library.model.Book;

public class GenreBookComparator extends AbstractBookComparator {

    @Override
    String getField(Book book) {
        return book.getGenre();
    }
}
