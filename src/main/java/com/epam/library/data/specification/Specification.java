package com.epam.library.data.specification;

import com.epam.library.model.Book;

import java.util.List;

public interface Specification {
    List<Book> find(List<Book> books, String value);
}
