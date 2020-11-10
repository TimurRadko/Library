package com.epam.library.view;

import com.epam.library.data.BookDao;
import com.epam.library.model.Book;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ConsoleBooksPrinter implements BooksPrinter {
    private static final Logger LOGGER = LogManager.getLogger(ConsoleBooksPrinter.class);

    @Override
    public void print(BookDao bookDao) {
        LOGGER.info("Now, in our bookshelves:");
        for (int i = 0; i < bookDao.size(); i++) {
            Book book = bookDao.get(i);
            LOGGER.info(book);
        }
    }
}
