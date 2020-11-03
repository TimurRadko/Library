package com.epam.library.data;

import com.epam.library.exception.DataException;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataAcquirer {
    private static final Logger LOGGER = Logger.getLogger(FileDataAcquirer.class);

    public List<String> read(String filename) throws DataException {
        BufferedReader reader = null;
        List<String> lines = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
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
        return lines;
    }
}
