package com.epam.library.data.reader;

import com.epam.library.exception.DataException;

import java.util.List;

public interface DataReader {
    public List<String> read(String filename) throws DataException;
}
