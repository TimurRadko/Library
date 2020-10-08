package com.epam.library.data;

import com.epam.library.Runner;
import com.epam.library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookCreator {
    private final static String DATA_SEPARATOR = "\n";
    private final static String LINE_SEPARATOR = ",";

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

        String title = fields[0];
        String authorName = fields[1];
        int writingYear = Integer.parseInt(fields[2]);
        String genre = fields[3];

        return new Book(title, authorName, writingYear, genre);
    }
}
