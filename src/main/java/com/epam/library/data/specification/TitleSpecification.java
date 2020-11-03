package com.epam.library.data.specification;

import com.epam.library.model.Book;

public class TitleSpecification extends AbstractSpecification<String> {

    @Override
    public boolean isFieldEqual(Book book, String value) {
        String title = book.getTitle();
        return value.equalsIgnoreCase(title);
    }
}
