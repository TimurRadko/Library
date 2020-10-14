package com.epam.library.data.factory;

import com.epam.library.data.BooksField;
import com.epam.library.data.specification.Specification;

public interface SpecificationFactory {
    <T> Specification<T> create(BooksField booksField);
}
