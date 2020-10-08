package com.epam.library;

import com.epam.library.data.BookCreator;
import com.epam.library.data.BookDao;
import com.epam.library.data.BooksField;
import com.epam.library.data.FileDataAcquirer;
import com.epam.library.exception.DataException;
import com.epam.library.model.Book;
import com.epam.library.view.BooksPrinter;
import com.epam.library.view.factory.BooksPrinterFactory;
import com.epam.library.view.factory.ConsoleBooksPrinterFactory;
import org.apache.log4j.Logger;

import java.util.List;

public class Runner {
    public static final Logger LOGGER = Logger.getLogger(Runner.class);
    private static final String FILE_PATH = "data/creating_books.txt";
    private static final Book CORRECT_ADDED_BOOK = new Book("1984", "Orwell G.", 1948, "Dystopian");
    private static final Book FAILED_BOOK_FOR_ADD = new Book("A Feast for Crows", "Martin G.", 2005, "Fantasy");
    private static final Book FAILED_BOOK_TO_REMOVE = new Book("A Dance with Dragons", "Martin G.", 2011, "Fantasy");
    private static final String LOGGER_MESSAGE = "Cause of exception is: ";
    private static final String AUTHOR_NAME_FOR_FINDING = "Martin G.";

    public static void main(String[] args) {

        try {
            runLibrary();
        } catch (DataException e) {
            LOGGER.error(LOGGER_MESSAGE + e);
        }
    }

    private static void runLibrary() throws DataException {
        LOGGER.info("Program Started.");

        FileDataAcquirer dataAcquirer = new FileDataAcquirer(FILE_PATH);
        String data = dataAcquirer.read();

        BookCreator bookCreator = new BookCreator();
        List<Book> bookList = bookCreator.createBooksList(data);

        BookDao dao = new BookDao(bookList);

        BooksPrinterFactory printerFactory = new ConsoleBooksPrinterFactory();
        BooksPrinter printer = printerFactory.create();
        printer.print(dao);

        dao.addBook(CORRECT_ADDED_BOOK);

        dao.sortBooksByTag(BooksField.GENRE);

        addFailedBook(dao);

        removeFailedBook(dao);

        List<Book> findByAuthor = dao.findByTag(BooksField.AUTHOR_NAME, AUTHOR_NAME_FOR_FINDING);
        BookDao findingByAuthor = new BookDao(findByAuthor);
        printer.print(findingByAuthor);

        LOGGER.info("Program ended.");
    }

    private static void addFailedBook(BookDao dao) {
        try {
            dao.addBook(FAILED_BOOK_FOR_ADD);
        } catch (DataException e) {
            LOGGER.error(LOGGER_MESSAGE + e);
        }
    }

    private static void removeFailedBook(BookDao dao) {
        try {
            dao.removeBook(FAILED_BOOK_TO_REMOVE);
        } catch (DataException e) {
            LOGGER.error(LOGGER_MESSAGE + e);
        }
    }
}
