package com.epam.library.view;

import com.epam.library.data.BookDao;
import com.epam.library.exception.DataException;

public interface BooksPrinter {
    void print(BookDao bookDao) throws DataException;
}
