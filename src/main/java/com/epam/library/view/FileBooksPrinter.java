package com.epam.library.view;

import com.epam.library.data.BookDao;
import com.epam.library.exception.DataException;
import com.epam.library.model.Book;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileBooksPrinter implements BooksPrinter {
    private static final Logger LOGGER = Logger.getLogger(FileBooksPrinter.class);
    private final String filename;

    public FileBooksPrinter(String filename) {
        this.filename = filename;
    }

    @Override
    public void print(BookDao bookDao) throws DataException {
        BufferedWriter writer = null;
        List<Book> books = getBookFromDao(bookDao);
        try {
            writer = new BufferedWriter(new FileWriter(filename));
            for (Book book : books) {
                writer.write(book.toString() + "\n");
            }
        } catch (IOException e) {
            throw new DataException("File not found", e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }

    private List<Book> getBookFromDao(BookDao bookDao) {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < bookDao.size(); i++) {
            Book book = bookDao.get(i);
            books.add(book);
        }
        return books;
    }
}
