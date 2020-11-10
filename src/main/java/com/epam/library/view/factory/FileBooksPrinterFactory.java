package com.epam.library.view.factory;

import com.epam.library.view.BooksPrinter;
import com.epam.library.view.FileBooksPrinter;
import com.epam.library.view.factory.BooksPrinterFactory;

public class FileBooksPrinterFactory implements BooksPrinterFactory {
    private static final String FILE_PATH = "src/data/output_books.txt";

    @Override
    public BooksPrinter create() {
        return new FileBooksPrinter(FILE_PATH);
    }
}
