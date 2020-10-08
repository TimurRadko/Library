package com.epam.library.view;

import com.epam.library.data.BookDao;
import com.epam.library.exception.DataException;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileBooksPrinter implements BooksPrinter {
    private static final Logger LOGGER = Logger.getLogger(FileBooksPrinter.class);
    private final String filename;

    public FileBooksPrinter(String filename) {
        this.filename = filename;
    }

    @Override
    public void print(BookDao bookDao) throws DataException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filename));
            writer.write(String.valueOf(bookDao));
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
}
