package com.epam.library.view;

import com.epam.library.Runner;
import com.epam.library.data.BookDao;

public class ConsoleBooksPrinter implements BooksPrinter {

    @Override
    public void print(BookDao bookDao) {
        Runner.LOGGER.info(bookDao);
    }
}
