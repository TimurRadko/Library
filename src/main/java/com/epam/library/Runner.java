package com.epam.library;

import com.epam.library.data.BookListCreator;
import com.epam.library.data.BookDao;
import com.epam.library.data.BookParser;
import com.epam.library.data.FileDataAcquirer;
import com.epam.library.data.factory.BookComparatorFactory;
import com.epam.library.data.factory.BookComparatorFactoryImpl;
import com.epam.library.data.factory.SpecificationFactory;
import com.epam.library.data.factory.SpecificationFactoryImpl;
import com.epam.library.exception.DataException;
import com.epam.library.model.Book;
import com.epam.library.view.BooksPrinter;
import com.epam.library.view.factory.BooksPrinterFactory;
import com.epam.library.view.factory.ConsoleBooksPrinterFactory;
import org.apache.log4j.Logger;

import java.util.List;

public class Runner {
    private static final Logger LOGGER = Logger.getLogger(Runner.class);
    private static final String FILE_PATH = "data/creating_books.txt";
    private static final String LOGGER_MESSAGE = "Cause of exception is: ";

    public static void main(String[] args) {

        try {
            runLibrary();
        } catch (DataException e) {
            LOGGER.error(LOGGER_MESSAGE + e);
        }
    }

    private static void runLibrary() throws DataException {
        LOGGER.info("Program Started.");

        FileDataAcquirer dataAcquirer = new FileDataAcquirer();
        List<String> lines = dataAcquirer.read(FILE_PATH);

        BookParser bookParser = new BookParser();
        BookListCreator bookListCreator = new BookListCreator(bookParser);
        List<Book> bookList = bookListCreator.createBooksList(lines);

        SpecificationFactory specificationFactory = new SpecificationFactoryImpl();
        BookComparatorFactory comparatorFactory = new BookComparatorFactoryImpl();
        BookDao dao = new BookDao(bookList, specificationFactory, comparatorFactory);

        BooksPrinterFactory printerFactory = new ConsoleBooksPrinterFactory();
        BooksPrinter printer = printerFactory.create();
        printer.print(dao);

        LOGGER.info("Program ended.");
    }
}
