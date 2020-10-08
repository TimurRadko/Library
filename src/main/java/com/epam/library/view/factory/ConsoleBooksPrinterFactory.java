package com.epam.library.view.factory;

import com.epam.library.view.BooksPrinter;
import com.epam.library.view.ConsoleBooksPrinter;

public class ConsoleBooksPrinterFactory implements BooksPrinterFactory {

    @Override
    public BooksPrinter create() {
        return new ConsoleBooksPrinter();
    }
}
