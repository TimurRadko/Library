package com.epam.library.data.factory;

import com.epam.library.data.BooksField;
import com.epam.library.data.specification.*;

public class SpecificationFactoryImpl implements SpecificationFactory {

    @Override
    public <T> AbstractSpecification<T> create(BooksField booksField) {
        switch (booksField) {
            case TITLE:
                return (AbstractSpecification<T>) new TitleSpecification();
            case AUTHOR_NAME:
                return (AbstractSpecification<T>) new AuthorNameSpecification();
            case WRITING_YEAR:
                return (AbstractSpecification<T>) new WritingYearSpecification();
            case GENRE:
                return (AbstractSpecification<T>) new GenreSpecification();
            default:
                throw new IllegalArgumentException("Book field " + booksField + " not found");
        }
    }
}
