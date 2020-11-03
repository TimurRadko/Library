package com.epam.library.data.specification;

import com.epam.library.model.Book;

public class GenreSpecification extends AbstractSpecification<String> {

    @Override
    public boolean isFieldEqual(Book book, String value) {
        String genre = book.getGenre();
        return value.equalsIgnoreCase(genre);
    }
}
