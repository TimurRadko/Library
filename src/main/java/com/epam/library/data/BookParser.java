package com.epam.library.data;

import com.epam.library.model.Book;

public class BookParser {
    private static final String LINE_SEPARATOR = ",";
    private static final int TITLE = 0;
    private static final int AUTHOR_NAME = 1;
    private static final int WRITING_YEAR = 2;
    private static final int GENRE = 3;

    public Book parse(String line) {
        String[] fields = line.split(LINE_SEPARATOR);

        String title = fields[TITLE];
        String authorName = fields[AUTHOR_NAME];
        int writingYear = Integer.parseInt(fields[WRITING_YEAR]);
        String genre = fields[GENRE];

        return new Book(title, authorName, writingYear, genre);
    }
}
