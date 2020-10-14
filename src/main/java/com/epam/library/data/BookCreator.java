package com.epam.library.data;

import com.epam.library.Runner;
import com.epam.library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookCreator {
    private static final String DATA_SEPARATOR = "\n";
    private static final String LINE_SEPARATOR = ",";
    private static final int TITLE = 0;
    private static final int AUTHOR_NAME = 1;
    private static final int WRITING_YEAR = 2;
    private static final int GENRE = 3;

    public List<Book> createBooksList(String data) {
        String[] lines = data.split(DATA_SEPARATOR);
        List<Book> creatingBooks = new ArrayList<>();

        for (String line : lines) {
            Book book = createBook(line);
            creatingBooks.add(book);
        }
        Runner.LOGGER.info("Adding books to the Library.");
        return creatingBooks;
    }

    private Book createBook(String line) {
        String[] fields = line.split(LINE_SEPARATOR);

        String title = fields[TITLE];
        String authorName = fields[AUTHOR_NAME];
        int writingYear = Integer.parseInt(fields[WRITING_YEAR]);
        String genre = fields[GENRE];

        return new Book(title, authorName, writingYear, genre);
    }
}
