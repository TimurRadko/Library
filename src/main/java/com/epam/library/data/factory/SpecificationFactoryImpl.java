package com.epam.library.data.factory;

import com.epam.library.data.BooksField;
import com.epam.library.data.specification.*;

public class SpecificationFactoryImpl implements SpecificationFactory {

    @Override
    public <T> Specification<T> create(BooksField booksField) {
        switch (booksField) {
            case TITLE:
                return (Specification<T>) new TitleSpecification();
            case AUTHOR_NAME:
                return (Specification<T>) new AuthorNameSpecification();
            case WRITING_YEAR:
                return (Specification<T>) new WritingYearSpecification();
            case GENRE:
                return (Specification<T>) new GenreSpecification();
            default:
                throw new IllegalArgumentException(String.format("Book field (%s) not found", booksField));
        }
    }
}
