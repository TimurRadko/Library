package com.epam.library.data.specification;

import com.epam.library.exception.DataException;
import com.epam.library.model.Book;

import java.util.List;

public interface Specification<T> {
    List<Book> find(List<Book> books, T value) throws DataException;
}
