package com.epam.library.data.factory;

import com.epam.library.data.BooksField;
import com.epam.library.data.specification.AbstractSpecification;

public interface SpecificationFactory {
    <T> AbstractSpecification<T> create(BooksField booksField);
}
