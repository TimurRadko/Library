package com.epam.library.data.factory;

import com.epam.library.data.BooksField;
import com.epam.library.data.specification.Specification;

public interface SpecificationFactory {
    Specification create(BooksField booksField);
}
