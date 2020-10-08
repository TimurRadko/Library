package com.epam.library.data;

import com.epam.library.exception.DataException;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileDataAcquirer {
    private static final Logger LOGGER = Logger.getLogger(FileDataAcquirer.class);
    private static final String SEPARATOR = "\n";
    private final String filename;

    public FileDataAcquirer(String filename) {
        this.filename = filename;
    }

    public String read() throws DataException {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append(SEPARATOR);
            }
        } catch (IOException e) {
            throw new DataException("File not found.", e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
        return builder.toString();
    }
}
