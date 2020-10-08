package com.epam.library.data.specification;

import com.epam.library.model.Book;

public class GenreSpecification extends AbstractSpecification {

    @Override
    String getField(Book book) {
        return book.getGenre();
    }
}
