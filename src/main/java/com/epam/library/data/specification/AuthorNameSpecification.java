package com.epam.library.data.specification;

import com.epam.library.model.Book;

public class AuthorNameSpecification extends AbstractSpecification<String> {

    @Override
    boolean isFieldEqual(Book book, String value) {
        String authorName = book.getAuthorName();
        return value.equalsIgnoreCase(authorName);
    }
}
