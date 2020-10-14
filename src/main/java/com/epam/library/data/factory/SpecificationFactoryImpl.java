package com.epam.library.data.factory;

import com.epam.library.data.BooksField;
import com.epam.library.data.specification.*;

public class SpecificationFactoryImpl implements SpecificationFactory {

    @Override
    public <T> Specification<T> create(BooksField booksField) {
        switch (booksField) {
            case TITLE:
                return new TitleSpecification<>();
            case AUTHOR_NAME:
                return new AuthorNameSpecification<>();
            case WRITING_YEAR:
                return new WritingYearSpecification();
            case GENRE:
                return new GenreSpecification<>();
            default:
                throw new IllegalArgumentException(String.format("Book field (%s) not found", booksField));
        }
    }
}
