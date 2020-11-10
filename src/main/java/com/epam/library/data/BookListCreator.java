package com.epam.library.data;

import com.epam.library.exception.DataException;
import com.epam.library.model.Book;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class BookListCreator {
    private static final Logger LOGGER = LogManager.getLogger(BookListCreator.class);
    private final BookParser bookParser;

    public BookListCreator(BookParser bookParser) {
        this.bookParser = bookParser;
    }

    public List<Book> createBooksList(List<String> lines) throws DataException {
        if (lines == null) {
            throw new DataException("The list doesn't have the data");
        }
        List<Book> creatingBooks = new ArrayList<>();

        for (String line : lines) {
            Book book = bookParser.parse(line);
            creatingBooks.add(book);
        }
        LOGGER.info("Adding books to the Library.");
        return creatingBooks;
    }
}
